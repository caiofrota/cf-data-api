package com.cftechsol.data.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity superclass that maps an entity with audit fields.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0
 * @since 1.0
 *
 * @param <PK>
 *            Primary Key
 */
@MappedSuperclass
@Getter
@Setter
public class GenericAuditEntity<PK> extends GenericEntity<PK> {

	private static final long serialVersionUID = -145159901714827356L;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "updated_by")
	private long updatedBy;

	@Column(name = "updated_on")
	private Date updatedOn;

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || this.getClass() != o.getClass())
			return false;

		GenericAuditEntity<PK> that = (GenericAuditEntity<PK>) o;
		// @formatter:off
		return super.equals(o) &&
				Objects.equals(this.getCreatedBy(), that.getCreatedBy()) &&
				Objects.equals(this.getCreatedOn(), that.getCreatedOn()) &&
				Objects.equals(this.getUpdatedBy(), that.getUpdatedBy()) &&
				Objects.equals(this.getUpdatedOn(), that.getUpdatedOn());
		// @formatter:on
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.getCreatedBy(), this.getCreatedOn(), this.getUpdatedBy(),
				this.getUpdatedOn());
	}

}
