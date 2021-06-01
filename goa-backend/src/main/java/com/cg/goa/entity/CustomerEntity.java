package com.cg.goa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.goa.model.AddressModel;

/* This is an Entity class*/
@Entity
@Table(name = "customer_entity")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email")
	private String email;

	@Embedded
	private AddressModel address;

	@Column(name = "role")
	private String role; // sales representative or retailer

	/*
	 * A default Constructor with no implementation
	 */

	public CustomerEntity() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public CustomerEntity(int customerId, String customerName, String mobileNo, String email, AddressModel address,
			String role) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	/*
	 * toString() method overridden here
	 * 
	 */

	@Override
	public String toString() {
		return String.format(
				"CustomerEntity [customerId=%s, customerName=%s, mobileNo=%s, email=%s, address=%s, role=%s]",
				customerId, customerName, mobileNo, email, address, role);
	}

}