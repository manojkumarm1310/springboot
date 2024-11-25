package com.digitech.springsecurityjwtexample2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.digitech.springsecurityjwt.api.entity.User;
import com.digitech.springsecurityjwt.api.repository.UserRepository;

@SpringBootApplication(scanBasePackages = "com.digitech.springsecurityjwt.api")
@EnableJpaRepositories(basePackages = "com.digitech.springsecurityjwt.api.repository")
@EntityScan(basePackages = "com.digitech.springsecurityjwt.api.entity")
@CrossOrigin(origins = "http://localhost:9191")
/*
 * Run in postman, post method, http://localhost:9191/authenticate
 * you will get jwt token, copy and paste in https://jwt.io/ to
 * decode the token
 * 
 */
public class SpringSecurityJwtExample2Application {
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
							new User(101,"asr","asr@123","asr@gmail.com"),
							new User(102,"user1","pwd1","user1@gmail.com"),
							new User(103,"user2","pwd2","user2@gmail.com"),
							new User(104,"user3","pwd3","user3@gmail.com")
				).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExample2Application.class, args);
	}

}
