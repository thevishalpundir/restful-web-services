package com.vishal.microservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;

	static {
		users.add(new User(userCount++, "vishal pundir", LocalDate.now().minusYears(30)));
		users.add(new User(userCount++, "vishal pundir", LocalDate.now().minusYears(30)));
		users.add(new User(userCount++, "vishal pundir", LocalDate.now().minusYears(30)));

	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(Integer id) {
		Optional<User> userOptional = users.stream().filter(x -> x.getId().equals(id)).findFirst();
		return userOptional.isPresent() ? userOptional.get() : null;
	}
	
	public User deleteOne(Integer id) {
		Optional<User> userOptional = users.stream().filter(x -> x.getId().equals(id)).findFirst();
		if(userOptional.isPresent()) {
			users.remove(userOptional.get());
			return userOptional.get();
		}else {
			return null;
		}
	}

	public User saveUser(User user) {
		user.setId(userCount++);
		users.add(user);
		return user;
	}
}
