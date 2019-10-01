package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Rahul Bangalore Sridhar
 * @version 1.0
 * @Creation_date 26th sept 2019 14.44
 * @modification_date 26th sept 2019 14.44
 * @copyright zensar technologies. All rights reserved.
 * @description this is a component mapping pgm.
 * 				
 *
 */

@Embeddable
public class Name {

	@Column(name="first",length = 30)
	private String firstName;
	@Column(name="middle")
	private String middleName;
	private String lastName;

public Name() {
	// TODO Auto-generated constructor stub
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Name(String firstName, String middleName, String lastName) {
	super();
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
}

@Override
public String toString()
{
	return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
}


}
