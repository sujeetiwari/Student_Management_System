package edu.sms.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.sms.entity.User;
import edu.sms.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login/{user}/{pass}")
	public String login(@PathVariable("user") String userName,
			@PathVariable("pass") String password) 
			throws ServletException
	{
		String jwtToken="";
		//checking if user name and password is blank
		if(userName.isBlank() || password.isBlank())
		{
			throw new ServletException("Please fill in username and password.");
		}
		
		User user = userService.login(userName, password);
		
		//checking whether user details is present in DB or not
		if(user==null)
		{
			throw new ServletException("User details not found.");
		}
		
		jwtToken = Jwts.builder().setSubject(user.getUserName())
		.claim("role", user.getRole().getRoleName())
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
		.signWith(SignatureAlgorithm.HS256, "lolipop")
		.compact();
		
		return jwtToken;
	}
	
}
