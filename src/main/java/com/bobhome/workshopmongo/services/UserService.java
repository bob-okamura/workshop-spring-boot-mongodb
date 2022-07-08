package com.bobhome.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bobhome.workshopmongo.domain.User;
import com.bobhome.workshopmongo.dto.UserDTO;
import com.bobhome.workshopmongo.repositories.UserRepositoty;
import com.bobhome.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepositoty repository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findById(String id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDTOtoEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(String id, UserDTO dto) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(()-> new ResourceNotFoundException(id));
		copyDTOtoEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void copyDTOtoEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}
}
