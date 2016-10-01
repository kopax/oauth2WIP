package com;

import com.common.config.DataV1DataSourceSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

// Replacement for IntelliJ IDEA 2016.1.3 @Autowired issue (see http://stackoverflow.com/questions/26889970/intellij-incorrectly-saying-no-beans-of-type-found-for-autowired-repository)
@Configuration
@ComponentScan
@EnableAutoConfiguration
// @SpringBootApplication generate Error on IntelliJ IDEA 2016.1.3 when using @Autowired annotation
//@SpringBootApplication
//@EnableAutoConfiguration
@RestController
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private DataV1DataSourceSettings dataV1DataSourceSettings;

	@Override
	public void run(String... args) throws Exception {
		logger.info("URL: " + dataV1DataSourceSettings.getUrl());
		logger.info("VERSION: " + dataV1DataSourceSettings.getVersion());
	}

	public static void main(String[] args) throws Exception {
		logger.debug("Starting app with SpringApplication.run");
		SpringApplication.run(Application.class, args);
		logger.info("KOPAX api started!");
	}

	@RequestMapping("/")
	public HashMap home() throws Exception {
		HashMap<String, Object> hi = new HashMap<>();
		hi.put("message", "Welcome to our API");
		hi.put("status", HttpStatus.OK);
		return hi;
	}

}
