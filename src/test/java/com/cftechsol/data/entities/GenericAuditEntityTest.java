package com.cftechsol.data.entities;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cftechsol.data.examples.entities.ExampleAuditEntity;

/**
 * Generic entity test class.
 * 
 * @author Caio Frota {@literal <contact@cftechsol.com>}
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenericAuditEntityTest {

	@Test
	public void shouldBeEqualsWithSameObject() throws Exception {
		ExampleAuditEntity entity = new ExampleAuditEntity();

		Assert.assertEquals(entity, entity);
	}

	@Test
	public void shouldBeEqualsWithSameAttributes() throws Exception {
		ExampleAuditEntity entity1 = new ExampleAuditEntity();
		ExampleAuditEntity entity2 = new ExampleAuditEntity();
		
		Date date = new Date();
		entity1.setId(1l);
		entity1.setName("Test");
		entity1.setCreatedBy(1l);
		entity1.setCreatedOn(date);
		entity1.setUpdatedBy(1l);
		entity1.setUpdatedOn(date);
		entity2.setId(1l);
		entity2.setName("Test");
		entity2.setCreatedBy(1l);
		entity2.setCreatedOn(date);
		entity2.setUpdatedBy(1l);
		entity2.setUpdatedOn(date);

		Assert.assertEquals(entity1, entity2);
		Assert.assertEquals(entity1.hashCode(), entity2.hashCode());
	}
	
	@Test
	public void shouldBeDifferentNull() throws Exception {
		ExampleAuditEntity entity = new ExampleAuditEntity();
		
		Assert.assertNotEquals(entity, null);
	}
	
	@Test
	public void shouldBeDifferentWithDifferentId() throws Exception {
		ExampleAuditEntity entity1 = new ExampleAuditEntity();
		ExampleAuditEntity entity2 = new ExampleAuditEntity();

		Date date = new Date();
		entity1.setId(1l);
		entity1.setName("Test");
		entity1.setCreatedBy(1l);
		entity1.setCreatedOn(date);
		entity1.setUpdatedBy(1l);
		entity1.setUpdatedOn(date);
		entity2.setId(2l);
		entity2.setName("Test");
		entity2.setCreatedBy(1l);
		entity2.setCreatedOn(date);
		entity2.setUpdatedBy(1l);
		entity2.setUpdatedOn(date);

		Assert.assertNotEquals(entity1, entity2);
		Assert.assertNotEquals(entity1.hashCode(), entity2.hashCode());
	}
	
	@Test
	public void shouldBeDifferentOtherObject() throws Exception {
		ExampleAuditEntity entity = new ExampleAuditEntity();

		Assert.assertNotEquals(entity, new Object());
	}

}
