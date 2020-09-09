package com.ggmartin.paperrockscissors.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GameDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-08-18T22:54:07.930203400+02:00[Europe/Madrid]")

public class GameDTO {
	@JsonProperty("id")
	private Integer id = Integer.valueOf(0);

	@JsonProperty("player1Victories")
	private Integer player1Victories = Integer.valueOf(0);

	@JsonProperty("player2Victories")
	private Integer player2Victories = Integer.valueOf(0);

	@JsonProperty("draws")
	private Integer draws = Integer.valueOf(0);

	@JsonProperty("numberRounds")
	private Integer numberRounds  = Integer.valueOf(0);

	@JsonProperty("roundList")
	@Valid
	private List<RoundDTO> roundList = new ArrayList<RoundDTO>();

	public GameDTO id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Id of the game
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Id of the game")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GameDTO player1Victories(Integer player1Victories) {
		this.player1Victories = player1Victories;
		return this;
	}

	/**
	 * Victories of the player 1
	 * 
	 * @return player1Victories
	 **/
	@ApiModelProperty(value = "Victories of the player 1")

	public Integer getPlayer1Victories() {
		return player1Victories;
	}

	public void setPlayer1Victories(Integer player1Victories) {
		this.player1Victories = player1Victories;
	}

	public GameDTO player2Victories(Integer player2Victories) {
		this.player2Victories = player2Victories;
		return this;
	}

	/**
	 * Victories of the player 2
	 * 
	 * @return player2Victories
	 **/
	@ApiModelProperty(value = "Victories of the player 2")

	public Integer getPlayer2Victories() {
		return player2Victories;
	}

	public void setPlayer2Victories(Integer player2Victories) {
		this.player2Victories = player2Victories;
	}

	public GameDTO draws(Integer draws) {
		this.draws = draws;
		return this;
	}

	/**
	 * Draws rounds
	 * 
	 * @return draws
	 **/
	@ApiModelProperty(value = "Draws rounds")

	public Integer getDraws() {
		return draws;
	}

	public void setDraws(Integer draws) {
		this.draws = draws;
	}

	public GameDTO numberRounds(Integer numberRounds) {
		this.numberRounds = numberRounds;
		return this;
	}

	/**
	 * Total rounds played
	 * 
	 * @return numberRounds
	 **/
	@ApiModelProperty(value = "Total rounds played")

	public Integer getNumberRounds() {
		return numberRounds;
	}

	public void setNumberRounds(Integer numberRounds) {
		this.numberRounds = numberRounds;
	}

	public GameDTO roundList(List<RoundDTO> roundList) {
		this.roundList = roundList;
		return this;
	}

	public GameDTO addRoundListItem(RoundDTO roundListItem) {
		if (this.roundList == null) {
			this.roundList = new ArrayList<RoundDTO>();
		}
		this.roundList.add(roundListItem);
		return this;
	}

	/**
	 * Get roundList
	 * 
	 * @return roundList
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public List<RoundDTO> getRoundList() {
		return roundList;
	}

	public void setRoundList(List<RoundDTO> roundList) {
		this.roundList = roundList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GameDTO gameDTO = (GameDTO) o;
		return Objects.equals(this.id, gameDTO.id) && Objects.equals(this.player1Victories, gameDTO.player1Victories)
				&& Objects.equals(this.player2Victories, gameDTO.player2Victories)
				&& Objects.equals(this.draws, gameDTO.draws) && Objects.equals(this.numberRounds, gameDTO.numberRounds)
				&& Objects.equals(this.roundList, gameDTO.roundList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, player1Victories, player2Victories, draws, numberRounds, roundList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GameDTO {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    player1Victories: ").append(toIndentedString(player1Victories)).append("\n");
		sb.append("    player2Victories: ").append(toIndentedString(player2Victories)).append("\n");
		sb.append("    draws: ").append(toIndentedString(draws)).append("\n");
		sb.append("    numberRounds: ").append(toIndentedString(numberRounds)).append("\n");
		sb.append("    roundList: ").append(toIndentedString(roundList)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public RoundDTO play(Integer player1, Integer player2) {
		RoundDTO round = new RoundDTO().handPlayer1Id(player1).handPlayer2Id(player2).play();

		switch (round.getWinner()) {
		case 0 -> ++this.draws;
		case 1 -> ++this.player1Victories;
		case 2 -> ++this.player2Victories;
		default -> throw new IllegalArgumentException("Unexpected value: " + round.getWinner());
		}
		++(this.numberRounds);
		this.roundList.add(round);

		return round;
	}

}
