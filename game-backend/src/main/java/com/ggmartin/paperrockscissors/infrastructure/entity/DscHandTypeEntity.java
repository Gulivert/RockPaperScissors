package com.ggmartin.paperrockscissors.infrastructure.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("unused")
@Entity
@Table(name = "DSC_HAND_TYPE")
public class DscHandTypeEntity {
	private @Id @Setter(AccessLevel.PRIVATE) Integer id;
	private String desc;
}
