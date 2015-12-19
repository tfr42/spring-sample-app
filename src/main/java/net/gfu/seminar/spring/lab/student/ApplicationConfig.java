package net.gfu.seminar.spring.lab.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/guest.properties")
@ComponentScan
public class ApplicationConfig {

	@Autowired
	private Environment environment;
/*
	@Bean
	public Guest guest(@Value("#{environment.firstName}") String firstName, @Value("#{environment.lastName}") String lastName)  {
		return new Guest(firstName,lastName);
	}
	
	@Bean @Autowired
	public GreetingService greeting(Guest guest) {
		return new MockGreetingService(guest);
	}*/
}
