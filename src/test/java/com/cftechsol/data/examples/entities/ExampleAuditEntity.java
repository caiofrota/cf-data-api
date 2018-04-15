package com.cftechsol.data.examples.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cftechsol.data.entities.GenericAuditEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Example audit entity to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "example_audit")
public class ExampleAuditEntity extends GenericAuditEntity<Long> {

	private static final long serialVersionUID = 1539463196938544379L;

	@Column
	private String name;
	
	public ExampleAuditEntity(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getName());
	}

}