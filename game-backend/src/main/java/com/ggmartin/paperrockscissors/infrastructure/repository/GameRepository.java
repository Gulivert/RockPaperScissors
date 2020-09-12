package com.ggmartin.paperrockscissors.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ggmartin.paperrockscissors.infrastructure.entity.GameEntity;

public interface GameRepository extends JpaRepository<GameEntity, Integer> {

	@Query("select distinct a from GameEntity a join fetch a.roundList")
	List<GameEntity> findAll();

	@Query("from GameEntity a left join fetch a.roundList where a.id=:id")
	Optional<GameEntity> findById(@Param("id") Integer id);
	
//	@Modifying
//    @Query("UPDATE GameEntity a SET a.address = :address WHERE c.id = :companyId")
//	void cleanById(Integer id);
}
