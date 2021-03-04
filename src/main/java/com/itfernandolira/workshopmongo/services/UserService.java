package com.itfernandolira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfernandolira.workshopmongo.domain.User;
import com.itfernandolira.workshopmongo.dto.UserDTO;
import com.itfernandolira.workshopmongo.repository.UserRepository;
import com.itfernandolira.workshopmongo.services.exceptions.ObjectNorFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNorFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.save(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
