package com.disney.studios.service;

import com.disney.studios.models.User;

public interface UserService {
	
	 public User save(User user);
	 public User findByUsername(String username);
	 

}
