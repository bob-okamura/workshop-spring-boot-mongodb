package com.bobhome.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bobhome.workshopmongo.domain.User;

@Repository
public interface UserRepositoty extends MongoRepository<User, String>{

}
