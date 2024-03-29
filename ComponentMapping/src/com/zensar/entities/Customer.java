package com.zensar.entities;

import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



/**
 * @author Rahul Bangalore Sridhar
 * @version 1.0
 * @Creation_date 26th sept 2019 14.53
 * @modification_date 26th sept 2019 14.53
 * @copyright zensar technologies. All rights reserved.
 * @description this is a component mapping pgm.
 * 				
 *
 */

@Entity
@Table(name ="customer")
public class Customer {
	
	@Id
	@Column(name = "cid")
	private int customerId;
	private Name customerName;
	private String gender;
	private int age;
	@Column(nullable = true)
	private String address;
	private LocalDate birtDate;
	private Blob profilePhoto;	//binary large object to store img,audio,vdo
	private Clob description;	//Character Large OBject
	
	public Customer() {
		// TODO Auto-generated constructor stub
	
	}

	public Customer(int customerId, Name customerName, String gender, int age, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender + ", age="
				+ age + ", address=" + address + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}

	public Blob getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(Blob profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public Clob getDescription() {
		return description;
	}

	public void setDescription(Clob description) {
		this.description = description;
	}

	

	
	
}
