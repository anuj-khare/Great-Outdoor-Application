package com.cg.goa.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CustomerModel {
	/*
	 * Private Members Validation
	 * */
	@NotNull(message = "customer Id cannot be null")
	@NotBlank(message = "customer Id cannot be blank")
	private int customerId;

	@NotBlank(message = "customer Name cannot be blank")
	private String customerName;

	@NotNull(message = "mobileNo cannot be null")
	@Pattern(regexp = "[1-9][0-9]{9}")
	private String mobileNo;

	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	private String email;

	@Valid
	private AddressModel address;

	@NotBlank(message = "role cannot be blank")
	private String role; // sales representative or retailer
	/*
	 * A default Constructor with no implementation
	 */

	public CustomerModel() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public CustomerModel(int customerId, String customerName, String mobileNo, String email,
			@Valid AddressModel address, String role) {
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
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerModel other = (CustomerModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	/* 
	 *toString() method overridden here
	 * 
	 * */
	@Override
	public String toString() {
		return String.format("Customer [customerId=%s, customerName=%s, mobileNo=%s, email=%s, address=%s, role=%s]",
				customerId, customerName, mobileNo, email, address, role);
	}
}