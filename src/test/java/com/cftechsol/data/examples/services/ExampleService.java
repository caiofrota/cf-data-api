package com.cftechsol.data.examples.services;

import org.springframework.stereotype.Service;

import com.cftechsol.data.examples.entities.ExampleEntity;
import com.cftechsol.data.examples.repositories.ExampleRepository;
import com.cftechsol.data.services.GenericService;

/**
 * Example service to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ExampleService extends GenericService<ExampleRepository, ExampleEntity, Long> {

}
