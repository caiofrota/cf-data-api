package com.cftechsol.data.examples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cftechsol.data.examples.entities.ExampleEntity;

/**
 * Example repository to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {

}
