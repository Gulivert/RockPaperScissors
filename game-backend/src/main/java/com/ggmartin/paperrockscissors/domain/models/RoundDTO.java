package com.ggmartin.paperrockscissors.domain.models;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Round
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-04T16:56:50.034Z")
public class RoundDTO {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("handPlayer1Id")
	private Integer handPlayer1Id = null;

	@JsonProperty("handPlayer2Id")
	private Integer handPlayer2Id = null;

	@JsonProperty("winner")
	private Integer winner = null;

	public RoundDTO id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Id of the round
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Id of the round")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoundDTO handPlayer1Id(Integer handPlayer1Id) {
		this.handPlayer1Id = HandTypeDTO.getValidHand(handPlayer1Id);
		return this;
	}

	/**
	 * Get handPlayer1Id
	 * 
	 * @return handPlayer1Id
	 **/
	@ApiModelProperty(value = "")

	public Integer getHandPlayer1Id() {
		return handPlayer1Id;
	}

	public void setHandPlayer1Id(Integer handPlayer1Id) {
		this.handPlayer1Id = HandTypeDTO.getValidHand(handPlayer1Id);
	}

	public RoundDTO handPlayer2Id(Integer handPlayer2Id) {
		this.handPlayer2Id = HandTypeDTO.getValidHand(handPlayer2Id);
		return this;
	}

	/**
	 * Get handPlayer2Id
	 * 
	 * @return handPlayer2Id
	 **/
	@ApiModelProperty(value = "")

	public Integer getHandPlayer2Id() {
		return handPlayer2Id;
	}

	public void setHandPlayer2Id(Integer handPlayer2Id) {
		this.handPlayer2Id = HandTypeDTO.getValidHand(handPlayer2Id);
	}

	public RoundDTO winner(Integer winner) {
		this.winner = winner;
		return this;
	}

	/**
	 * Who won the game 0 draw 1 player1 2 player2
	 * 
	 * @return winner
	 **/
	@ApiModelProperty(value = "Who won the game   0 draw   1 player1   2 player2 ")

	public Integer getWinner() {
		return winner;
	}

	public void setWinner(Integer winner) {
		this.winner = winner;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RoundDTO roundDTO = (RoundDTO) o;
		return Objects.equals(this.id, roundDTO.id) && Objects.equals(this.handPlayer1Id, roundDTO.handPlayer1Id)
				&& Objects.equals(this.handPlayer2Id, roundDTO.handPlayer2Id)
				&& Objects.equals(this.winner, roundDTO.winner);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, handPlayer1Id, handPlayer2Id, winner);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RoundDTO {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    handPlayer1Id: ").append(toIndentedString(handPlayer1Id)).append("\n");
		sb.append("    handPlayer2Id: ").append(toIndentedString(handPlayer2Id)).append("\n");
		sb.append("    winner: ").append(toIndentedString(winner)).append("\n");
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

	public RoundDTO play() {
		this.winner = HandTypeDTO.winner(this.handPlayer1Id, this.handPlayer2Id);
		return this;
	}

}
