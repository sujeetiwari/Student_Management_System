package edu.sms.service;

import edu.sms.entity.User;

public interface UserService {

	User login(String userName, String password);
}
