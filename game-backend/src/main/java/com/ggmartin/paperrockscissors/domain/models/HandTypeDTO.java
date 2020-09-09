package com.ggmartin.paperrockscissors.domain.models;

import java.util.Objects;
import java.util.Random;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * HandTypeDTO
 */
@Validated
public class HandTypeDTO {
	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("desc")
	private String desc = null;

	public HandTypeDTO id(Integer id) {
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

	private static Integer getRandomHand() {
		return new Random().nextInt(3) + 2;
	}

	public HandTypeDTO desc(String desc) {
		this.desc = desc;
		return this;
	}

	/**
	 * Id of the game
	 * 
	 * @return desc
	 **/
	@ApiModelProperty(value = "Id of the game")

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HandTypeDTO handType = (HandTypeDTO) o;
		return Objects.equals(this.id, handType.id) && Objects.equals(this.desc, handType.desc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, desc);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HandTypeDTO {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
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

	/**
	 * This method will return the winner in a play. In case the id is 1 (Random), a
	 * hand value will be generated
	 * 
	 * @param o
	 * @return
	 */
	public static int winner(Integer hand1, Integer hand2) {
		if (hand1 == hand2)
			return 0;
		switch (hand1) {
		case 2:
			return hand2 == 3 ? 2 : 1;
		case 3:
			return hand2 == 4 ? 2 : 1;
		case 4:
			return hand2 == 2 ? 2 : 1;
		default:
			throw new IllegalArgumentException("Unexpected value: " + hand1);
		}
	}

	public static Integer getValidHand(Integer hand) {
		return hand != 1 ? hand : HandTypeDTO.getRandomHand();
	}
}
