package net.gfu.seminar.spring.lab.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Guest myGuest() {
		return new Guest("Anna", "Gramm");
	}
	
	@Bean
	public GreetingService greeting() {
		return new MockGreetingService(myGuest());
	}
}
