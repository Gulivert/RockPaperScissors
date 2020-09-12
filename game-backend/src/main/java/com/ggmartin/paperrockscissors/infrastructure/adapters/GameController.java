package com.ggmartin.paperrockscissors.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggmartin.paperrockscissors.application.GameApplication;
import com.ggmartin.paperrockscissors.domain.models.GameDTO;
import com.ggmartin.paperrockscissors.domain.models.HandTypeDTO;
import com.ggmartin.paperrockscissors.domain.ports.GameControllerApi;
import com.ggmartin.paperrockscissors.domain.util.GameException;

import io.swagger.annotations.Api;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-18T22:38:00.537012+02:00[Europe/Madrid]")

@Controller
@Api(value = "GameController",tags = {"GameController"})
@SuppressWarnings("unchecked")
public class GameController implements GameControllerApi {
	
	private final Logger LOGGER = LoggerFactory.getLogger(GameController.class);
	
	@Autowired
	private GameApplication application;
	
	
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public GameController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }
    
	@Override
	public ResponseEntity<List<HandTypeDTO>> getHandTypes() {
		List<HandTypeDTO> hands = application.getHands();
        return new ResponseEntity<List<HandTypeDTO>>(hands,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GameDTO> cleanGame(Integer id) {
		try {
			GameDTO game = application.clean(id);
	        return new ResponseEntity<GameDTO>(game,HttpStatus.OK);
		} catch (GameException e) {
			return (ResponseEntity<GameDTO>) manageError(e);
		}
	}

	@Override
	public ResponseEntity<GameDTO> continueGame(Integer id, @NotNull @Valid Integer player1HandId,
			@NotNull @Valid Integer player2HandId) {
		GameDTO play;
		try {
			play = application.play(id, player1HandId, player2HandId);
	        return new ResponseEntity<GameDTO>(play,HttpStatus.OK);
		} catch (GameException e) {
			return (ResponseEntity<GameDTO>) manageError(e);
		}
	}

	@Override
	public ResponseEntity<GameDTO> createGame(@NotNull @Valid Integer player1HandId,
			@NotNull @Valid Integer player2HandId) {
		GameDTO play;
		try {
			play = application.play(null, player1HandId, player2HandId);
	        return new ResponseEntity<GameDTO>(play,HttpStatus.OK);
		} catch (GameException e) {
			return (ResponseEntity<GameDTO>) manageError(e);
		}
	}

    
	private ResponseEntity<?> manageError(GameException e){
		LOGGER.error("Error: ",e);
		switch (e.getCode()) {
		case 400:
			return new ResponseEntity<GameDTO>(HttpStatus.BAD_REQUEST);
		case 404:
			return new ResponseEntity<GameDTO>(HttpStatus.NOT_FOUND);
		default:
			return new ResponseEntity<GameDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
    
}
