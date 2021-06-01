package com.cg.goa.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserdataModel {

	/*
	 * Private Members Validation
	 */
	@NotNull(message = "userId cannot be null")
	@NotBlank(message = "userId cannot be blank")
	private Long userId;

	@NotNull(message = "userName cannot be null")
	@NotBlank(message = "userName cannot be blank")
	private String userName;

	@NotNull(message = "user Type cannot be null")
	private String userType;

	@NotNull(message = "userPasswordcannot be null")
	@Pattern(regexp =  "[a-zA-Z0-9]{8,14}")
	private String userPassword;

	/*
	 * A default Constructor with no implementation
	 */

	public UserdataModel() {
		// no implementation
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public UserdataModel(String userName, Long userId, String userType, String userPassword) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/*
	 * Corresponding HashCode and Equals methods
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		UserdataModel other = (UserdataModel) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("UserdataModel [userId=%s, userName=%s, userType=%s, userPassword=%s]", userId, userName,
				userType, userPassword);
	}

}
