package com.cg.goa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "user_data")
public class Userdata implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_Name")
	private String userName;

	@Column(name = "user_Type")
	private String userType;

	@Column(name = "user_Password")
	private String userPassword;
    
	@OneToOne(mappedBy = "userId")
	private OrderEntity order;

	@OneToOne(mappedBy = "userId")
	private CartItemEntity cart;

	@OneToOne(mappedBy = "userId")
	private WishlistItemEntity Wishlist;


	/*
	 * A default Constructor with no implementation
	 */

	public Userdata() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public Userdata(String userName, Long userId, String userType, String userPassword) {
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

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public CartItemEntity getCart() {
		return cart;
	}

	public void setCart(CartItemEntity cart) {
		this.cart = cart;
	}

	public WishlistItemEntity getWishlist() {
		return Wishlist;
	}

	public void setWishlist(WishlistItemEntity wishlist) {
		Wishlist = wishlist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Wishlist == null) ? 0 : Wishlist.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		Userdata other = (Userdata) obj;
		if (Wishlist == null) {
			if (other.Wishlist != null)
				return false;
		} else if (!Wishlist.equals(other.Wishlist))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
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
		return "Userdata [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", userPassword="
				+ userPassword + ", order=" + order + ", cart=" + cart + ", Wishlist=" + Wishlist + "]";
	}

	

	/*
	 * toString() method overridden here
	 * 
	 */

}
