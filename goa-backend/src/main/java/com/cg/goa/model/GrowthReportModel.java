package com.cg.goa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public class GrowthReportModel {
	/*
	 * Private Members Validation
	 * */

	@NotNull(message="growthReportId cannot be null")
	@NotBlank(message="growthReportId cannot be blank")
	private long growthReportId;
	
	@NotNull(message="current date cannot be null")
	@PastOrPresent(message="current date cannot be past or present")
	private LocalDateTime currentdate;
	
	@NotNull(message="revenue cannot be null")
	private BigDecimal revenue;
	
	@NotNull(message="amount Change cannot be null")
	private BigDecimal amountChange;
	
	@NotNull(message="percentage Growth cannot be null")
	@NotBlank(message="percentage Growth cannot be blank")
	@Min(value=0,message=("Percentage Growth cannot be negative"))
	private BigDecimal percentageGrowth;
	
	@NotNull(message="color Code cannot be null")
	@NotBlank(message="color Code cannot be blank")
	@Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
	private String colorCode;
	/*
	 * A default Constructor with no implementation
	 */

	public GrowthReportModel() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public GrowthReportModel(long growthReportId, LocalDateTime currentdate, BigDecimal revenue, BigDecimal amountChange,
			BigDecimal percentageGrowth, String colorCode) {
		super();
		this.growthReportId = growthReportId;
		this.currentdate = currentdate;
		this.revenue = revenue;
		this.amountChange = amountChange;
		this.percentageGrowth = percentageGrowth;
		this.colorCode = colorCode;
	}
	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public long getGrowthReportId() {
		return growthReportId;
	}

	public void setGrowthReportId(long growthReportId) {
		this.growthReportId = growthReportId;
	}

	public LocalDateTime getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(LocalDateTime currentdate) {
		this.currentdate = currentdate;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public BigDecimal getAmountChange() {
		return amountChange;
	}

	public void setAmountChange(BigDecimal amountChange) {
		this.amountChange = amountChange;
	}

	public BigDecimal getPercentageGrowth() {
		return percentageGrowth;
	}

	public void setPercentageGrowth(BigDecimal percentageGrowth) {
		this.percentageGrowth = percentageGrowth;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountChange == null) ? 0 : amountChange.hashCode());
		result = prime * result + ((colorCode == null) ? 0 : colorCode.hashCode());
		result = prime * result + ((currentdate == null) ? 0 : currentdate.hashCode());
		result = prime * result + (int) (growthReportId ^ (growthReportId >>> 32));
		result = prime * result + ((percentageGrowth == null) ? 0 : percentageGrowth.hashCode());
		result = prime * result + ((revenue == null) ? 0 : revenue.hashCode());
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
		GrowthReportModel other = (GrowthReportModel) obj;
		if (amountChange == null) {
			if (other.amountChange != null)
				return false;
		} else if (!amountChange.equals(other.amountChange))
			return false;
		if (colorCode == null) {
			if (other.colorCode != null)
				return false;
		} else if (!colorCode.equals(other.colorCode))
			return false;
		if (currentdate == null) {
			if (other.currentdate != null)
				return false;
		} else if (!currentdate.equals(other.currentdate))
			return false;
		if (growthReportId != other.growthReportId)
			return false;
		if (percentageGrowth == null) {
			if (other.percentageGrowth != null)
				return false;
		} else if (!percentageGrowth.equals(other.percentageGrowth))
			return false;
		if (revenue == null) {
			if (other.revenue != null)
				return false;
		} else if (!revenue.equals(other.revenue))
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
				"GrowthReportEntity [growthReportId=%s, currentdate=%s, revenue=%s, amountChange=%s, percentageGrowth=%s, colorCode=%s]",
				growthReportId, currentdate, revenue, amountChange, percentageGrowth, colorCode);
	}
	

}
