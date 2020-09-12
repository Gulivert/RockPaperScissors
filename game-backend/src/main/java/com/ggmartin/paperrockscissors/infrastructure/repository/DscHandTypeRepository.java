package com.ggmartin.paperrockscissors.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggmartin.paperrockscissors.infrastructure.entity.DscHandTypeEntity;

public interface DscHandTypeRepository extends JpaRepository<DscHandTypeEntity, Integer> {
}
