package com.cftechsol.data.examples.services;

import org.springframework.stereotype.Service;

import com.cftechsol.data.examples.entities.ExampleAuditEntity;
import com.cftechsol.data.examples.repositories.ExampleAuditRepository;
import com.cftechsol.data.services.GenericService;

/**
 * Example audit service to run the tests.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ExampleAuditService extends GenericService<ExampleAuditRepository, ExampleAuditEntity, Long> {

}
