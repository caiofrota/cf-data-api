package com.cftechsol.data.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cftechsol.data.entities.GenericAuditEntity;

/**
 * Generic service with common methods to accelerate the creation of services.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0
 * @since 1.0
 *
 * @param <R>
 *            extends JpaRepository
 * @param <E>
 *            Entity
 * @param <PK>
 *            Primary key
 */
public class GenericService<R extends JpaRepository<E, PK>, E, PK> {

	@Autowired
	protected R repository;

	/**
	 * Find all objects from database.
	 * 
	 * @return List of objects.
	 */
	public List<E> findAll() {
		return this.repository.findAll();
	}

	/**
	 * Find one object by primary key.
	 * 
	 * @param id
	 *            Primary key.
	 * @return Entity.
	 */
	public E findById(PK id) {
		Optional<E> object = this.repository.findById(id);
		return (object.isPresent()) ? object.get() : null;
	}

	/**
	 * Save an object.
	 * 
	 * @param object
	 *            Object to save.
	 * @return Object saved.
	 * @throws Exception
	 */
	public E save(E object) throws Exception {
		return this.repository.save(object);
	}
	
	/**
	 * Save an object.
	 * 
	 * @param object
	 *            Object to save.
	 * @return Object saved.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public E save(E object, long user) throws Exception {
		if (object instanceof GenericAuditEntity) {
			GenericAuditEntity<PK> audit = (GenericAuditEntity<PK>) object;
			Date now = new Date();
			if (audit.getId() == null || this.findById(audit.getId()) == null) {
				audit.setCreatedBy(user);
				audit.setCreatedOn(new Date());
			}
			audit.setUpdatedBy(user);
			audit.setUpdatedOn(now);
			return this.repository.save((E) audit);
		} else {
			return this.repository.save(object);
		}
	}

	/**
	 * Delete one object.
	 * 
	 * @param object
	 *            Object to delete.
	 * @throws Exception
	 */
	public void delete(PK object) throws Exception {
		this.repository.deleteById(object);
	}

}
