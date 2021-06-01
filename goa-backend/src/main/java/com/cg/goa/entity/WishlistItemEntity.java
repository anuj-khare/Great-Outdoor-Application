package com.cg.goa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "wishlist_item_entity")
public class WishlistItemEntity implements Serializable {

	//private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "wishlist_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long wishlistId;

	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name = "userId")
	private Userdata userId;

	@Column(name = "product_id")
	private String productId;

	/*
	 * A default Constructor with no implementation
	 */
	public WishlistItemEntity() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public WishlistItemEntity(Long wishlistId, Userdata userId, String productId) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.productId = productId;
	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */

	public Long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Userdata getUserId() {
		return userId;
	}

	public void setUserId(Userdata userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((wishlistId == null) ? 0 : wishlistId.hashCode());
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
		WishlistItemEntity other = (WishlistItemEntity) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (wishlistId == null) {
			if (other.wishlistId != null)
				return false;
		} else if (!wishlistId.equals(other.wishlistId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("WishlistItemEntity [wishlistId=%s, userId=%s, productId=%s]", wishlistId, userId,
				productId);
	}



	/*
	 * toString() method overridden here
	 * 
	 */

}
