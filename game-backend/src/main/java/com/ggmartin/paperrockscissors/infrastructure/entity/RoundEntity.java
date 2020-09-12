package com.ggmartin.paperrockscissors.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@SuppressWarnings("unused")
@Entity
@Table(name = "ROUND")
public class RoundEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id @Setter(AccessLevel.PRIVATE) Integer id;

	@Column(name = "HAND_PLAYER_1")
	private Integer handPlayer1Id;

	@Column(name = "HAND_PLAYER_2")
	private Integer handPlayer2Id;
	
	private Integer winner;
	
	@ManyToOne
	@JoinColumn(updatable = false, insertable = false)
	private GameEntity game;

	@Column(name = "GAME_ID")
	private Integer gameId;
}
