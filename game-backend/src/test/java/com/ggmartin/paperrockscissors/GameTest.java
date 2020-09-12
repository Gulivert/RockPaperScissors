package com.ggmartin.paperrockscissors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.ggmartin.paperrockscissors.domain.models.GameDTO;
import com.ggmartin.paperrockscissors.domain.ports.DataService;
import com.ggmartin.paperrockscissors.domain.ports.GameControllerApi;

@SpringBootTest
class GameTest {

	@Autowired
	GameControllerApi controller;

	@MockBean
	DataService service;

	@Test
	void requestGame() {
		Integer stoneHand = 2;
		Integer paperHand = 3;

		Mockito.when(service.merge((GameDTO) any(GameDTO.class))).then(AdditionalAnswers.returnsFirstArg());

		ResponseEntity<GameDTO> playGame = controller.createGame(stoneHand, paperHand);
		assertNotNull(playGame);

		GameDTO body = playGame.getBody();
		assertNotNull(body);
		assertEquals(body.getPlayer2Victories(), Integer.valueOf(1));

	}

}
