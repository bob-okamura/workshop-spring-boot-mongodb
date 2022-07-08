package com.bobhome.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobhome.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User(1L, "Maria", "maria@gmail.com");
		User bob = new User(2L, "Bob", "bob@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, bob));
		return ResponseEntity.ok().body(list);
	}

}
