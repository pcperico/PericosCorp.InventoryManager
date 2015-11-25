/**
 * BuyDetail.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;

public class BuyDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public BuyDetail()
	{}
	
	public BuyDetail(Buy buy,Product product, double quantity, double price)
	{
		Buy=buy;
		Product = product;
		Quantity=quantity;
		Price=price;
	}
	
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Buy getBuy() {
		return Buy;
	}
	public void setBuy(Buy buy) {
		Buy = buy;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	private Buy Buy;
	private Product Product;
	private double Quantity;
	private double Price;
}
