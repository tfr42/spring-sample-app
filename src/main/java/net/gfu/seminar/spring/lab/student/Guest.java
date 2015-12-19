package net.gfu.seminar.spring.lab.student;

import javax.inject.Named;

/**
 * A guest.
 */
@Named("guest")
public class Guest {
    private String firstName;
    private String lastName;
    
    public Guest() {
		// TODO Auto-generated constructor stub
	}

    public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
