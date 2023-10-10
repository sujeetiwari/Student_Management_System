package edu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserNameAndPassword(String userName, String password);
}
