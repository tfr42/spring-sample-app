package net.gfu.seminar.spring.lab.student;

/**
 * A greeting service.
 */
public interface GreetingService {

	@Deprecated
    String sayHelloTo(Guest guest);
	
	String sayHello();
}
