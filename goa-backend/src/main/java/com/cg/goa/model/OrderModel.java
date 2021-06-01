package com.cg.goa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderModel {
	/*
	 * Private Members Validation
	 */

	private Long orderId;

	@NotNull(message = "user Id cannot be null")
	@NotBlank(message = "user Id cannot be blank")
	private Long userId;

	//@NotNull(message = "products cannot be null")

//	@NotBlank(message = "products cannot be blank")
//	private List<ProductModel> products = new ArrayList<>(); // product and quantity

	@NotNull(message = "products cannot be null")
	@NotBlank(message = "products cannot be blank")
	private Long productId ;
	
	@NotNull(message = "totalPrice cannot be null")
	@NotBlank(message = "totalPrice cannot be blank")
	@Min(value = 0, message = ("Total Price cannot be negative"))
	private Long totalPrice;

	@NotNull(message = "total Quantity cannot be null")
	@NotBlank(message = "total Quantity cannot be blank")
	@Min(value = 0, message = ("Total Quantity cannot be negative"))
	private Long totalQuantity;

	@NotNull(message = "dispatch Date cannot be null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dispatchDate;

	@NotNull(message = "deliveryDate cannot be null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime deliveryDate;

	/*
	 * A default Constructor with no implementation
	 */

	public OrderModel() {
		// no implementation
	}

	public OrderModel(Long orderId,
			@NotNull(message = "user Id cannot be null") @NotBlank(message = "user Id cannot be blank") Long userId,
			@NotNull(message = "products cannot be null") @NotNull(message = "products cannot be null") @NotBlank(message = "products cannot be blank") Long productId,
			@NotNull(message = "totalPrice cannot be null") @NotBlank(message = "totalPrice cannot be blank") @Min(value = 0, message = "Total Price cannot be negative") Long totalPrice,
			@NotNull(message = "total Quantity cannot be null") @NotBlank(message = "total Quantity cannot be blank") @Min(value = 0, message = "Total Quantity cannot be negative") Long totalQuantity,
			@NotNull(message = "dispatch Date cannot be null") LocalDateTime dispatchDate,
			@NotNull(message = "deliveryDate cannot be null") LocalDateTime deliveryDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.productId = productId;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((dispatchDate == null) ? 0 : dispatchDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((totalQuantity == null) ? 0 : totalQuantity.hashCode());
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
		OrderModel other = (OrderModel) obj;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (dispatchDate == null) {
			if (other.dispatchDate != null)
				return false;
		} else if (!dispatchDate.equals(other.dispatchDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (totalQuantity == null) {
			if (other.totalQuantity != null)
				return false;
		} else if (!totalQuantity.equals(other.totalQuantity))
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
		return String.format(
				"OrderModel [orderId=%s, userId=%s, productId=%s, totalPrice=%s, totalQuantity=%s, dispatchDate=%s, deliveryDate=%s]",
				orderId, userId, productId, totalPrice, totalQuantity, dispatchDate, deliveryDate);
	}

	
	

}
