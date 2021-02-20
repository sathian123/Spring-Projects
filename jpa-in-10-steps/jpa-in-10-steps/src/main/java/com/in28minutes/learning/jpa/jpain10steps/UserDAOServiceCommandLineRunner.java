package com.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserDAOService userService;

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {

		User user = new User("sathian", "dev");
		long userId = userService.insert(user);

		logger.info("User Created " + userId);
	}

}
