package com.example.accessingdatamysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AccessingDataMysqlApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataMysqlApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args)->{
			repository.save(new User("ricardo", "ricardo@gmail.com"));
			repository.save(new User("Eddie", "eddie@gmail.com"));
			repository.save(new User("Marco", "marco@gmail.com"));
			repository.save(new User("Stephen", "stephen@gmail.com"));
			repository.save(new User("Kenneth", "kenneth@gmail.com"));

			log.info("User found with findAll");
			log.info("-----------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			Optional<User> user = repository.findById(1);
			log.info("-----------------------");
			log.info(user.toString());
			log.info("");

			log.info("Customer found with findByName('Eddie')");
			log.info("-----------------------");
			repository.findByName("Eddie").forEach(bauer-> log.info(bauer.toString()));
			log.info("");
		};
	}
}
