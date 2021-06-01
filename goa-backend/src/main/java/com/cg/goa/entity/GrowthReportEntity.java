package com.cg.goa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity
@Table(name = "growth_report_entity")
public class GrowthReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	@Column(name = "growth_Report_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long growthReportId;

	@Column(name = "currentdate")
	private LocalDateTime currentdate;

	@Column(name = "revenue")
	private BigDecimal revenue;

	@Column(name = "amount_change")
	private BigDecimal amountChange;

	@Column(name = "percentage_growth")
	private BigDecimal percentageGrowth;

	@Column(name = "color_code")
	private String colorCode;
	/*
	 * A default Constructor with no implementation
	 */

	public GrowthReportEntity() {
		// no implementation
	}
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public GrowthReportEntity(long growthReportId, LocalDateTime currentdate, BigDecimal revenue, BigDecimal amountChange,
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
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return String.format(
				"GrowthReportEntity [growthReportId=%s, currentdate=%s, revenue=%s, amountChange=%s, percentageGrowth=%s, colorCode=%s]",
				growthReportId, currentdate, revenue, amountChange, percentageGrowth, colorCode);
	}

}
