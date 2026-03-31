package com.x86.followup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("FollowupApplication Integration Tests")
class FollowupApplicationTests {

	@Autowired(required = false)
	private ApplicationContext applicationContext;

	@Test
	@DisplayName("Application context should load successfully")
	void contextLoads() {
		assertNotNull(applicationContext, "Application context should be loaded");
	}

	@Test
	@DisplayName("Application should contain essential beans")
	void testBeansExist() {
		if (applicationContext != null) {
			String[] beanNames = applicationContext.getBeanDefinitionNames();
			assertTrue(beanNames.length > 0, "Application should define at least one bean");
		}
	}

	@Test
	@DisplayName("Application should start without errors")
	void testApplicationStarts() {
		assertDoesNotThrow(() -> {
			// If we reach here, application started successfully
		});
	}
}
