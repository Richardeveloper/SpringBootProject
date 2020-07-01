package com.richardeveloper.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.richardeveloper.entities.Order;
import com.richardeveloper.entities.User;
import com.richardeveloper.repositories.OrderRepository;
import com.richardeveloper.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Eric Clapton", "Eric@outlook.com", "98245643", "12345");
		User u2 = new User(null, "Billy Ocean", "Billy@hotmail.com", "96547321", "54321");
		
		Order o1 = new Order(null, Instant.parse("2020-03-30T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2020-01-14T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2020-06-21T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
