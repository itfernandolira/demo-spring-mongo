package com.itfernandolira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfernandolira.workshopmongo.domain.Post;
import com.itfernandolira.workshopmongo.domain.User;
import com.itfernandolira.workshopmongo.dto.UserDTO;
import com.itfernandolira.workshopmongo.repository.PostRepository;
import com.itfernandolira.workshopmongo.services.exceptions.ObjectNorFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNorFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}



}
