/**
 * SaleDetail.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;

public class SaleDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public SaleDetail(Sale sale,Product product, double quantity, double price)
	{
		Sale=sale;
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
	public Sale getSale() {
		return Sale;
	}
	public void setSale(Sale sale) {
		Sale = sale;
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
	private Sale Sale;
	private Product Product;
	private double Quantity;
	private double Price;
	
}
