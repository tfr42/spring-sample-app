package net.gfu.seminar.spring.lab.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Guest guest()  {
		return new Guest("Hans","Dampf");
	}
	
	@Bean @Autowired
	public GreetingService greeting(Guest guest) {
		return new MockGreetingService(guest);
	}
}
