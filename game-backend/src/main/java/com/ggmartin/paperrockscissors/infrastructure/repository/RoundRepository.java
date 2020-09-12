package com.ggmartin.paperrockscissors.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggmartin.paperrockscissors.infrastructure.entity.RoundEntity;

public interface RoundRepository extends JpaRepository<RoundEntity, Integer> {
	
	List<RoundEntity> deleteByGameId(Integer gameId);
}
