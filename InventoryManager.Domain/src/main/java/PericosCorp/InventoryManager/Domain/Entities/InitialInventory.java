/**
 * InitialInventory.java
 * Created on 4/12/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;
import java.util.Date;

public class InitialInventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public InitialInventory()
	{}
	
	public InitialInventory (Product product, int year, Date creationDate, double stock,double priceCost,int movementId)
	{
		Product = product;
		Year= year;
		CreationDate = creationDate;
		Stock = stock;
		PriceCost = priceCost;
		Movement_Id = movementId;
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
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public double getStock() {
		return Stock;
	}
	public void setStock(double stock) {
		Stock = stock;
	}
	public double getPriceCost() {
		return PriceCost;
	}
	public void setPriceCost(double priceCost) {
		PriceCost = priceCost;
	}
	private Product Product;
	private int Year;
	private Date CreationDate;
	private double Stock;
	private double PriceCost;
	private int Movement_Id;
	public int getMovement_Id() {
		return Movement_Id;
	}

	public void setMovement_Id(int movement_Id) {
		Movement_Id = movement_Id;
	}
}
