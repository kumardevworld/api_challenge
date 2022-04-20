package com.disney.studios.service;

import com.disney.studios.jpa.UserRepository;
import com.disney.studios.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
    UserRepository userRepository;
    
    @Override
    public User save(User user) {
    	User duplicateUser = findByUsername(user.getUsername());
	    	if(null == duplicateUser){
	        user.setPassword(user.getPassword());
	        User newUser = userRepository.save(user);
	        newUser.setPassword(null);
	        return newUser;
    	}
	    return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
