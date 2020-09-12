package com.ggmartin.paperrockscissors.infrastructure.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "GAME")
public class GameEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id @Setter(AccessLevel.PRIVATE) Integer id;

	@Column(name = "VICTORIES_PLAYER_1")
	private Integer player1Victories;
	@Column(name = "VICTORIES_PLAYER_2")
	private Integer player2Victories;
	@Column(name = "DRAWS")
	private Integer draws;
	@Column(name = "NUMBER_ROWS")
	private Integer numberRounds;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="game")
	private List<RoundEntity> roundList;
}
