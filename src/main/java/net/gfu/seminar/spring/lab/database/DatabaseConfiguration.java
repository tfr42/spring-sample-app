package net.gfu.seminar.spring.lab.database;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.gfu.seminar.spring.lab.student.ApplicationConfig;

/**
 * Hier wird gezeigt, dass Konfiguration auch aufgespalten werden kann.
 * Über die @ComponentScan Annotation in {@link ApplicationConfig} wird diese
 * gefunden und automatisch aktiviert
 * 
 * @author Rene Gielen
 */
@Configuration
public class DatabaseConfiguration {

	@Bean
	public DataSource dataSource() {
		return  null;
	}
	
}
