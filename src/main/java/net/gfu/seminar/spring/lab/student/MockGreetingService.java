package net.gfu.seminar.spring.lab.student;

/**
 * A simple mock greeting service saying hello.
 */
public class MockGreetingService implements GreetingService {
	
	private Guest guest;
	
	public MockGreetingService() {
		// TODO Auto-generated constructor stub
	}
	
	public MockGreetingService(Guest guest) {
		this.guest = guest;
	}
	
	/**
	 * @deprecated "as of Spring DI convention either use setter or constructor injection to pass reference
	 * @see #sayHello
	 */
	@Deprecated
    public String sayHelloTo(Guest guest) {
		this.setGuest(guest);
		return this.sayHello();
    }

	@Override
	public String sayHello() {
		return String.format("Hello, %1s %2s!", this.guest.getFirstName(), this.guest.getLastName());
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	public void init() {
		System.out.println("Init was called on " + this.toString());
	}
	
	protected void destroy() {
		System.out.println("Destroy was called on " + this.toString());
	}

}
