package net.gfu.seminar.spring.lab.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.gfu.seminar.spring.lab.database.DatabaseConfiguration;
import net.gfu.seminar.spring.lab.database.DummyDataSource;

@Configuration
@ComponentScan(basePackageClasses = {DatabaseConfiguration.class})
// Folgende String-basierte Suche würde für Plugin-Systeme Sinn machen, sonst ist die obere typsichere Variante zu bevorzugen
// @ComponentScan(basePackages = {"net.gfu.seminar.spring.lab.plugins"})
public class ApplicationConfig {

	@Autowired
	DummyDataSource dataSource;
	
	@Bean
	public Guest myGuest() {
		return new Guest("Anna", "Gramm");
	}
	
	@Bean
	public Guest hisGuest() {
		return new Guest("Olga", "Grimm");
	}
	
	/**
	 * Obwohl zwei Kandidaten vom Typ Guest existieren, wird nur einer ausgewählt:
	 * Die Bean mit dem gleichen Namen wie der Parameter wird von Spring injeziert
	 */
	@Bean @Autowired 
	public GreetingService greeting(Guest myGuest) {
		System.out.println(dataSource);
		return new MockGreetingService(myGuest);
	}
}
