package com.ggmartin.paperrockscissors.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ggmartin.paperrockscissors.domain.models.GameDTO;
import com.ggmartin.paperrockscissors.domain.models.HandTypeDTO;
import com.ggmartin.paperrockscissors.domain.models.RoundDTO;
import com.ggmartin.paperrockscissors.domain.ports.DataService;
import com.ggmartin.paperrockscissors.domain.util.GameException;

@Component
public class GameApplication {

	@Autowired
	private DataService data;

	public GameApplication(DataService data) {
		this.data = data;
	}

	public GameDTO play(Integer id, Integer player1Hand, Integer player2Hand) throws GameException {
		GameDTO game;
		if(id==null)
			game = new GameDTO();
		else
			game = data.getGameById(id);
		
		RoundDTO round = game.play(player1Hand, player2Hand);
		data.merge(game);
		data.merge(round,game.getId());
		
		return game;
	}

	public List<HandTypeDTO> getHands() {
		List<HandTypeDTO> allHands = data.getAllHands();
		return allHands;
	}

	public GameDTO clean(Integer id) throws GameException {
		data.clean(id);
		return data.getGameById(id);
	}

}
