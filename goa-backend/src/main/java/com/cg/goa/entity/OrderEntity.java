package com.cg.goa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "order_entity")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private Userdata userId;

//	@OneToMany(mappedBy = "orderId",cascade = CascadeType.ALL)// ,orphanRemoval = true, targetEntity = ProductEntity.class, cascade = { CascadeType.ALL })
//	private List<ProductEntity> products = new ArrayList<>();

	@OneToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productId;
	
	
	@Column(name = "total_price")
	private Long totalPrice;

	@Column(name = "total_quantity")
	private Long totalQuantity;

	@Column(name = "dispatch_date")
	private LocalDateTime dispatchDate;

	@Column(name = "delivery_date")
	private LocalDateTime deliveryDate;
	
	
	/*
	 * A default Constructor with no implementation
	 */

	public OrderEntity() {
		// no implementation
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	
	public OrderEntity(Long orderId, Userdata userId, ProductEntity productId, Long totalPrice,
			Long totalQuantity, LocalDateTime dispatchDate, LocalDateTime deliveryDate) {
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

	public Userdata getUserId() {
		return userId;
	}

	public void setUserId(Userdata userId) {
		this.userId = userId;
	}

	
	public ProductEntity getProductId() {
		return productId;
	}

	public void setProductId(ProductEntity productId) {
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
		OrderEntity other = (OrderEntity) obj;
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
				"OrderEntity [orderId=%s, userId=%s, productId=%s, totalPrice=%s, totalQuantity=%s, dispatchDate=%s, deliveryDate=%s]",
				orderId, userId, productId, totalPrice, totalQuantity, dispatchDate, deliveryDate);
	}

	/*
	 * toString() method overridden here
	 * 
	 */
	
}
