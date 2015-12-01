package net.gfu.seminar.spring.lab.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Guest myGuest() {
		Guest guest = new Guest();
		guest.setFirstName("Anna");
		guest.setLastName("Gramm");
		return guest;
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public GreetingService greeting() {
		MockGreetingService greetingService = new MockGreetingService();
		greetingService.setGuest(myGuest());
		return greetingService;
	}
}
