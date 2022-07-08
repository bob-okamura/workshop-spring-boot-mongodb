package com.bobhome.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.bobhome.workshopmongo.domain.User;
import com.bobhome.workshopmongo.repositories.UserRepositoty;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepositoty repository;

	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
