/**
 * PriceSaleHistory.java
 * Created on 3/12/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;
import java.util.Date;

public class PriceSaleHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public PriceSaleHistory()
	{
		
	}
	
	public PriceSaleHistory(Product product, double priceSale,Date beginDate)
	{
		Product = product;
		PriceSale = priceSale;
		BeginDate = beginDate;
	}
	
	private int Id;
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public double getPriceSale() {
		return PriceSale;
	}

	public void setPriceSale(double priceSale) {
		PriceSale = priceSale;
	}

	public Date getBeginDate() {
		return BeginDate;
	}

	public void setBeginDate(Date beginDate) {
		BeginDate = beginDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	private Product Product;
	private double PriceSale;
	private Date BeginDate;
	private Date EndDate;
}
