package net.gfu.seminar.spring.lab.student;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * A simple mock greeting service saying hello.
 */
public class MockGreetingService implements GreetingService {

	final private Guest guest;
	
	public MockGreetingService(Guest guest) {
		this.guest = guest;
	}
	
	/**
	 * @deprecated "as of Spring DI convention either use setter or constructor injection to pass reference
	 * @see #sayHello
	 */
	@Deprecated
    public String sayHelloTo(Guest guest) {
		//this.setGuest(guest);
		return this.sayHello();
    }

	@Override
	public String sayHello() {
		return String.format("Hello, %1s %2s!", this.guest.getFirstName(), this.guest.getLastName());
	}

	public Guest getGuest() {
		return guest;
	}

	@PostConstruct
	public void init() {
		System.out.println("Init was called on " + this.toString());
	}
	
	@PreDestroy
	protected void destroy() {
		System.out.println("Destroy was called on " + this.toString());
	}

}
