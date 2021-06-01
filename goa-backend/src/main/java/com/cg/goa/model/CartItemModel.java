package com.cg.goa.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.goa.entity.ProductEntity;

public class CartItemModel {

	/*
	 * Private Members Validation
	 */
	@NotNull(message = "cart Id cannot be null")
	private Long cartId;

	@NotNull(message = "user Id cannot be null")
	private Long userId;

	@NotNull(message = "products cannot be null")
	@NotBlank(message = "products cannot be blank")
	private Long productId ;//=  new ArrayList<>();// product 

	@NotNull(message = "cartTotalPrice cannot be null")
	@Min(value = 0, message = ("Cart Total Price cannot be negative"))
	private long cartTotalPrice;

	@NotNull(message = "totalQuantity cannot be null")
	@Min(value = 0, message = ("Total Quantity cannot be negative"))
	private long totalQuantity;

	/*
	 * A default Constructor with no implementation
	 */

	public CartItemModel() {
		// no implementation
	}

	
	public CartItemModel(@NotNull(message = "cart Id cannot be null") Long cartId,
			@NotNull(message = "user Id cannot be null") Long userId,
			@NotNull(message = "products cannot be null") @NotBlank(message = "products cannot be blank") Long productId,
			@NotNull(message = "cartTotalPrice cannot be null") @Min(value = 0, message = "Cart Total Price cannot be negative") long cartTotalPrice,
			@NotNull(message = "totalQuantity cannot be null") @Min(value = 0, message = "Total Quantity cannot be negative") long totalQuantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
	}


	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
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

	/*
	 * Corresponding HashCode and Equals methods
	 * 
	 */

	
	
	
	
	
	/*
	 * toString() method overridden here
	 * 
	 */
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
		CartItemModel other = (CartItemModel) obj;
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
		return String.format("CartItemModel [cartId=%s, userId=%s, productId=%s, cartTotalPrice=%s, totalQuantity=%s]",
				cartId, userId, productId, cartTotalPrice, totalQuantity);
	}


	

}
