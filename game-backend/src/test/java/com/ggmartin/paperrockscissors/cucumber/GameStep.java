package com.ggmartin.paperrockscissors.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ggmartin.paperrockscissors.domain.models.GameDTO;
import com.ggmartin.paperrockscissors.domain.models.RoundDTO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class GameStep{
    
    private GameDTO game;
    
	@Given("is a new game")
	public void is_a_new_game() {
		game = new GameDTO();
	}
	
	@When("play a game")
	public void start_a_new_game() {
		game.play(1, 1);
	}
	@Then("the number of rounds is {int}")
	public void the_number_of_rounds_is(Integer int1) {
		@Valid
		List<RoundDTO> roundDTOs = game.getRoundList();
		assertNotNull(roundDTOs);
		assertEquals(roundDTOs.size(), int1.intValue());
	}
	
	@Given("is an old game")
	public void is_an_old_game() {
		game = new GameDTO();
		game.play(1, 1);
	}

	@Then("the number of rounds is not {int}")
	public void the_number_of_rounds_is_not (Integer int1) {
		@Valid
		List<RoundDTO> roundDTOs = game.getRoundList();
		assertNotNull(roundDTOs);
		assertNotEquals(roundDTOs.size(), int1.intValue());
	}
}
