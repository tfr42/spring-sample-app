package net.gfu.seminar.spring.lab.database;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import net.gfu.seminar.spring.lab.student.Guest;

@Component
public class DummyDataSource {

	public void drop (String tableName) {
		System.out.println("drop called");
	}
	
	/**
	 * Wenngleich es möglich ist, in beliebigen Managed Beans Methoden
	 * mit @Bean Annotation zu plazieren, wird davon abgeraten 
	 */
	@Bean
	public Guest dbGuest() {
		return new Guest();
	}
	
}
