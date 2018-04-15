package com.cftechsol.data.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cftechsol.data.examples.entities.ExampleAuditEntity;
import com.cftechsol.data.examples.entities.ExampleEntity;
import com.cftechsol.data.examples.services.ExampleAuditService;
import com.cftechsol.data.examples.services.ExampleService;

/**
 * GenericService test class.
 * 
 * @author Caio Frota{@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenericServiceTest {

	@Autowired
	private ExampleService service;
	@Autowired
	private ExampleAuditService auditService;

	private String name = "Example";

	@Test
	public void shouldFindAll() throws Exception {
		ExampleEntity example = new ExampleEntity(name);
		example = service.save(example);
		
		List<ExampleEntity> found = service.findAll();
		Assert.assertFalse(found.isEmpty());
	}

	@Test
	public void shouldFindOneById() throws Exception {
		ExampleEntity example = new ExampleEntity(name);
		example = service.save(example);
		
		ExampleEntity found = service.findById(example.getId());
		Assert.assertEquals(found.getId(), example.getId());
	}

	@Test
	public void shouldUpdateOneById() throws Exception {
		ExampleEntity example = new ExampleEntity(name);
		example = service.save(example);

		String newName = "Example Changed";
		example.setName(newName);
		example = service.save(example);
		
		ExampleEntity found = service.findById(example.getId());
		found.setName(newName);
		found = service.save(found);
		Assert.assertEquals(found.getName(), newName);
	}

	@Test
	public void shouldSaveAuditFields() throws Exception {
		ExampleAuditEntity example = new ExampleAuditEntity(name + " Audit");
		example = auditService.save(example, 1l);

		Assert.assertEquals(example.getCreatedBy(), 1l);
		Assert.assertEquals(example.getUpdatedBy(), 1l);
		Assert.assertNotNull(example.getCreatedOn());
		Assert.assertNotNull(example.getUpdatedOn());
		Assert.assertEquals(example.getCreatedOn(), example.getUpdatedOn());
	}

	@Test
	public void shouldUpdateAuditFields() throws Exception {
		ExampleAuditEntity example = new ExampleAuditEntity(name + " Audit");
		example = auditService.save(example, 1l);
		auditService.save(example, 2l);

		Assert.assertEquals(example.getCreatedBy(), 1l);
		Assert.assertEquals(example.getUpdatedBy(), 2l);
		Assert.assertNotNull(example.getCreatedOn());
		Assert.assertNotNull(example.getUpdatedOn());
		Assert.assertNotEquals(example.getCreatedOn(), example.getUpdatedOn());
	}
	
	@Test
	public void shouldSaveOkWhenCallAuditWithNonAuditObject() throws Exception {
		ExampleEntity example = new ExampleEntity(name + " Audit");
		example = service.save(example, 1l);

		ExampleEntity found = service.findById(example.getId());
		Assert.assertEquals(found.getId(), example.getId());
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldDeleteById() throws Exception {
		ExampleEntity example = new ExampleEntity(name);
		example = service.save(example);
		
		service.delete(example.getId());
		service.findById(example.getId());
	}

}
