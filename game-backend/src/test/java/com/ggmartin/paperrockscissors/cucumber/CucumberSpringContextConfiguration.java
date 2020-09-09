package com.ggmartin.paperrockscissors.cucumber;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.ggmartin.paperrockscissors.Application;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@CucumberContextConfiguration
public class CucumberSpringContextConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);
	
	@Before
	public void setUp() {
		LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
	}
}
