package net.gfu.seminar.spring.lab.student;

/**
 * A simple mock greeting service saying hello.
 */
public class MockGreetingService implements GreetingService {

    public String sayHelloTo(Guest guest) {
        return String.format("Hello, %1s %2s!", guest.getFirstName(), guest.getLastName());
    }
}
