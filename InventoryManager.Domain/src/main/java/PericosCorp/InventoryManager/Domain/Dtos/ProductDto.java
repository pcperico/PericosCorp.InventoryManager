/**
 * ProductDto.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Dtos;

import java.io.Serializable;

public class ProductDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public ProductDto()
	{		
	}
	
	public ProductDto(String name)
	{
		Name=name;
	}
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getProvider() {
		return Provider;
	}
	public void setProvider(String provider) {
		Provider = provider;
	}
	private String Name;
	private String Category;
	private String Provider;
	private double PriceCost;
	public double getPriceCost() {
		return PriceCost;
	}

	public void setPriceCost(double priceCost) {
		PriceCost = priceCost;
	}

	public double getStock() {
		return Stock;
	}

	public void setStock(double stock) {
		Stock = stock;
	}

	public double getPriceSale() {
		return PriceSale;
	}

	public void setPriceSale(double priceSale) {
		PriceSale = priceSale;
	}
	private double Stock;
	private double PriceSale;
	
	@Override
	public String toString()
	{
		return Name;		
	}
}
