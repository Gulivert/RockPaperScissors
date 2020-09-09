package com.rockpaperscissors.web.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ggmartin.paperrockscissors.client.ApiException;
import com.ggmartin.paperrockscissors.client.api.GameControllerApi;
import com.ggmartin.paperrockscissors.client.model.GameDTO;
import com.ggmartin.paperrockscissors.client.model.HandTypeDTO;
import com.rockpaperscissors.web.utils.WebException;

@Controller
public class WebController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GameControllerApi api;

	@Value("${const.player1Hand}")
	private String player1HandDesc;
	private Integer player1Hand;

	@Value("${const.player2Hand}")
	private String player2HandDesc;
	private Integer player2Hand;

	String[] hands;

	@PostConstruct
	private void postConstruct() throws WebException {
		List<HandTypeDTO> handTypes;
		try {
			handTypes = api.getHandTypes();
		} catch (ApiException e) {
			LOGGER.error("Error calling handTypes api: ", e);
			throw new WebException(e);
		}
		
		this.hands = new String[handTypes.size() + 1];

		for (HandTypeDTO handTypeDTO : handTypes) {
			if (handTypeDTO.getDesc().equalsIgnoreCase(player1HandDesc))
				player1Hand = handTypeDTO.getId();
			if (handTypeDTO.getDesc().equalsIgnoreCase(player2HandDesc))
				player2Hand = handTypeDTO.getId();

			this.hands[handTypeDTO.getId()] = handTypeDTO.getDesc();
		}

		if (player1Hand == null || player2Hand == null)
			throw new WebException("Hands value are not valid");
	}

	public <K, V> Stream<K> keys(Map<K, V> map, V value) {
		return map.entrySet().stream().filter(entry -> value.equals(entry.getValue())).map(Map.Entry::getKey);
	}

	@GetMapping("/")
	public String main(Model model, HttpSession session) {
		model.addAttribute("hands", hands);
		model.addAttribute("game", null);
		session.setAttribute("idGame", null);
		return "index"; // view
	}

	@GetMapping("/play")
	public String mainWithParam(Model model, HttpSession session) throws WebException {
		model.addAttribute("hands", hands);
		Integer idGame = (Integer) session.getAttribute("idGame");
		GameDTO playGame;
		try {
			if (idGame == null)
				playGame = api.createGame(player1Hand, player2Hand);
			else
				playGame = api.continueGame(idGame, player1Hand, player2Hand);
		} catch (ApiException e) {
			LOGGER.error("Error calling play api: ", e);
			throw new WebException(e);
		}
		if (idGame == null && playGame != null)
			session.setAttribute("idGame", playGame.getId());
		model.addAttribute("game", playGame);
		return "index"; // view
	}

	@GetMapping("/clean")
	public String clean(Model model, HttpSession session) throws WebException {
		model.addAttribute("hands", hands);
		Integer idGame = (Integer) session.getAttribute("idGame");
		if (idGame != null) {
			try {
				GameDTO cleanGame = api.cleanGame(idGame);
				model.addAttribute("game", cleanGame);
			} catch (ApiException e) {
				LOGGER.error("Error calling clean api: ", e);
				throw new WebException(e);
			}
		}
		return "index"; // view
	}

}