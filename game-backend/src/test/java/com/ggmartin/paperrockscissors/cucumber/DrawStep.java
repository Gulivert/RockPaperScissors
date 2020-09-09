package com.ggmartin.paperrockscissors.cucumber;

import static org.junit.Assert.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ggmartin.paperrockscissors.domain.models.GameDTO;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class DrawStep {
	private GameDTO game;

	@When("the player1 and player2 play a game with the same hand")
	public void the_player_and_player_have_the_same_hand() {
		game = new GameDTO();
		game.play(2, 2);
	}

	@Then("no one win, is a draw")
	public void no_one_win_is_a_draw() {
		assertEquals(game.getDraws(), Integer.valueOf(1));
	}
}
