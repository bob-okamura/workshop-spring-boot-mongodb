package com.bobhome.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bobhome.workshopmongo.domain.User;
import com.bobhome.workshopmongo.repositories.UserRepositoty;

@Service
public class UserService {
	
	@Autowired
	private UserRepositoty repository;

	public List<User> findAll(){
		return repository.findAll();
	}
	
}
