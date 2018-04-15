package com.cftechsol.data.examples.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cftechsol.data.entities.GenericEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Example entity to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "example")
public class ExampleEntity extends GenericEntity<Long> {

	private static final long serialVersionUID = 7159209110712597658L;

	@Column
	private String name;

	public ExampleEntity(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getName());
	}

}