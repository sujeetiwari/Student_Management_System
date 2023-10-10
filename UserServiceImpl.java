package edu.sms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sms.entity.User;

import edu.sms.repository.UserRepository;
import edu.sms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User login(String userName, String password) {
		
		return userRepository.findByUserNameAndPassword(userName, password);
		
	}

	
}
