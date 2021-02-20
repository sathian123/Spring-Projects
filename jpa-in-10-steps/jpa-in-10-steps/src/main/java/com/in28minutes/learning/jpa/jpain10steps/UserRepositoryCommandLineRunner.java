package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {

		User user = new User("sathian", "dev");
		userRepo.save(user);
		logger.info("User Created " + user.getId());

		Optional<User> userWithId = userRepo.findById(1L);
		logger.info("User retrived " + userWithId);

		List<User> users = userRepo.findAll();
		for (User user2 : users) {
			System.out.println(user2);

		}

	}

}
