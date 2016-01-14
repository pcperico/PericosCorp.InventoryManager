/**
 * MovementDetail.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;

public class MovementDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public MovementDetail()
	{}
	
	public MovementDetail(Movement movement,Product product, double quantity, double price,double priceSale)
	{
		Movement = movement;
		Product = product;
		Quantity=quantity;
		PriceCost=price;
		PriceSale = priceSale;
	}
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Movement getMovement() {
		return Movement;
	}
	public void setMovement(Movement movement) {
		Movement = movement;
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
	public double getPriceCost() {
		return PriceCost;
	}
	public void setPriceCost(double price) {
		PriceCost = price;
	}
	private Movement Movement;
	private Product Product;
	private double Quantity;
	private double PriceCost;
	private double PriceSale;
	public double getPriceSale() {
		return PriceSale;
	}

	public void setPriceSale(double priceSale) {
		PriceSale = priceSale;
	}
}
