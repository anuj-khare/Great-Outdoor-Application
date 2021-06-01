package com.cg.goa.entity;

import java.io.Serializable;
//import java.util.Map;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "cart_item_entity")
public class CartItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;

	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private Userdata userId;

	
	@Column(name = "cart_total_price")
	private long cartTotalPrice;

	@Column(name = "total_quantity")
	private long totalQuantity;
	
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productId;

	
//	@OneToMany(mappedBy = "cart",cascade= CascadeType.ALL)
//	private List<ProductEntity> products=new ArrayList<>();


	/*
	 * A default Constructor with no implementation
	 */

	public CartItemEntity() {
		// no implementation
	}

	
	public CartItemEntity(Long cartId, Userdata userId, long cartTotalPrice, long totalQuantity, ProductEntity productId) {
	super();
	this.cartId = cartId;
	this.userId = userId;
	this.cartTotalPrice = cartTotalPrice;
	this.totalQuantity = totalQuantity;
	this.productId = productId;
}


	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Userdata getUserId() {
		return userId;
	}

	public void setUserId(Userdata userId) {
		this.userId = userId;
	}

	public long getCartTotalPrice() {
		return cartTotalPrice;
	}

	public void setCartTotalPrice(long cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}

	public long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public ProductEntity getProductId() {
		return productId;
	}


	public void setProductId(ProductEntity productId) {
		this.productId = productId;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + (int) (cartTotalPrice ^ (cartTotalPrice >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + (int) (totalQuantity ^ (totalQuantity >>> 32));
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		CartItemEntity other = (CartItemEntity) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cartTotalPrice != other.cartTotalPrice)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (totalQuantity != other.totalQuantity)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.format("CartItemEntity [cartId=%s, userId=%s, cartTotalPrice=%s, totalQuantity=%s, productId=%s]",
				cartId, userId, cartTotalPrice, totalQuantity, productId);
	}


	
	/*
	 * toString() method overridden here
	 * 
	 */
	

}