package com.tns.jwttoken.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tns.jwttoken.entities.User;
import com.tns.jwttoken.repository.UserRepository;

@Service
public class UserService {

	//private List<User> store=new ArrayList<>();
	
//	public UserService() {
//		store.add(new User(UUID.randomUUID().toString(),"akash kumar","akash@gmail.com","12345678"));
//		store.add(new User(UUID.randomUUID().toString(),"aarush kumar","aarush@gmail.com","23424555"));
//		store.add(new User(UUID.randomUUID().toString(),"akanshu kumar","akanshu@gmail.com","5787854"));
//		store.add(new User(UUID.randomUUID().toString(),"rohit kumar","rohit@gmail.com","23456789"));
//	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
