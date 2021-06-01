package com.cg.goa.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.goa.entity.CartItemEntity;
import com.cg.goa.entity.OrderEntity;

public class ProductModel {
	/*
	 * Private Members Validation
	 * */
	@NotNull(message="product Id cannot be null")
	@NotBlank(message="product Id cannot be blank")
	private Long productId;
	
	@NotNull(message="product Name cannot be null")
	@NotBlank(message="product Name cannot be blank")
	private String productName;
	
	@NotNull(message="price cannot be null")
	@NotBlank(message="price cannot be blank")
	@Min(value=0,message=("Price cannot be negative"))
	private Long price;
	
	@NotNull(message="image cannot be null")
	@NotBlank(message="image cannot be blank")
	private String image;
	
	@NotNull(message="color cannot be null")
	@NotBlank(message="color cannot be blank")
	private String color;
	
	@NotNull(message="category cannot be null")
	@NotBlank(message="category cannot be blank")
	private String category;
	
	@NotNull(message="quantity cannot be null")
	@NotBlank(message="quantity cannot be blank")
	@Min(value=0,message=("Quntity cannot be negative"))
	private Long quantity;
	
	@NotNull(message="manufacturer cannot be null")
	@NotBlank(message="manufacturer cannot be blank")
	private String manufacturer;
	
	@NotNull(message="specification cannot be null")
	@NotBlank(message="specification cannot be blank")
	private String specification;
	
//	 private OrderModel orderId;
//	 
//	 
//	 private CartItemModel cart;
	 
	/*
	 * A default Constructor with no implementation
	 */

	public ProductModel() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public ProductModel(Long productId, String productName, Long price, String image, String color, String category,
			Long quantity, String manufacturer, String specification) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.image = image;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.manufacturer = manufacturer;
		this.specification = specification;
	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	
//	public OrderModel getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(OrderModel orderId) {
//		this.orderId = orderId;
//	}
//	public CartItemModel getCart() {
//		return cart;
//	}
//	public void setCart(CartItemModel cart) {
//		this.cart = cart;
//	}
	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		//result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((specification == null) ? 0 : specification.hashCode());
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
		ProductModel other = (ProductModel) obj;
//		if (cart == null) {
//			if (other.cart != null)
//				return false;
//		} else if (!cart.equals(other.cart))
//			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
//		if (orderId == null) {
//			if (other.orderId != null)
//				return false;
//		} else if (!orderId.equals(other.orderId))
//			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (specification == null) {
			if (other.specification != null)
				return false;
		} else if (!specification.equals(other.specification))
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return String.format(
				"ProductModel [productId=%s, productName=%s, price=%s, image=%s, color=%s, category=%s, quantity=%s, manufacturer=%s, specification=%s]",
				productId, productName, price, image, color, category, quantity, manufacturer, specification);
	}

	

	/* 
	 *toString() method overridden here
	 * 
	 * */
	
}
