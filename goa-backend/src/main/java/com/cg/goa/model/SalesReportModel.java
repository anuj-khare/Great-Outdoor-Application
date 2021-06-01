package com.cg.goa.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SalesReportModel {
	/*
	 * Private Members Validation
	 * */
	@NotNull(message="salesReportId cannot be null")
	private long salesReportId;
	
	@NotNull(message="product Id cannot be null")
	@NotBlank(message="product Id cannot be blank")
	private Long productId;
	
	@NotNull(message="product Name cannot be null")
	@NotBlank(message="product Name cannot be blank")
	private String productName;
	
	@NotNull(message="quantitySold cannot be null")
	@NotBlank(message="quantitySold cannot be blank")
	@Min(value=0,message=("Quantity Sold cannot be negative"))
	private Integer quantitySold;
	
	@NotNull(message="totalSale cannot be null")
	@Min(value=0,message=("Total Sale cannot be negative"))
	private BigDecimal totalSale;
	/*
	 * A default Constructor with no implementation
	 */

	public SalesReportModel() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public SalesReportModel(long salesReportId, Long productId, String productName, Integer quantitySold,
			BigDecimal totalSale) {
		super();
		this.salesReportId = salesReportId;
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSale = totalSale;
	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public long getSalesReportId() {
		return salesReportId;
	}

	public void setSalesReportId(Long salesReportId) {
		this.salesReportId = salesReportId;
	}

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

	public Integer getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}

	public BigDecimal getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}
	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((quantitySold == null) ? 0 : quantitySold.hashCode());
		result = prime * result + (int) (salesReportId ^ (salesReportId >>> 32));
		result = prime * result + ((totalSale == null) ? 0 : totalSale.hashCode());
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
		SalesReportModel other = (SalesReportModel) obj;
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
		if (quantitySold == null) {
			if (other.quantitySold != null)
				return false;
		} else if (!quantitySold.equals(other.quantitySold))
			return false;
		if (salesReportId != other.salesReportId)
			return false;
		if (totalSale == null) {
			if (other.totalSale != null)
				return false;
		} else if (!totalSale.equals(other.totalSale))
			return false;
		return true;
	}

	/* 
	 *toString() method overridden here
	 * 
	 * */
	@Override
	public String toString() {
		return String.format(
				"SalesReportEntity [salesReportId=%s, productId=%s, productName=%s, quantitySold=%s, totalSale=%s]",
				salesReportId, productId, productName, quantitySold, totalSale);
	}
	
}
