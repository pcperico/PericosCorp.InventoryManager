/**
 * Product.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public Product()
	{}
	
	public Product(ProductCategory productCategory,Provider provider, MeasurementUnit measurementUnit, String name, String description,String brand,String model)
	{
		this.ProductCategory=productCategory;
		this.Provider=provider;
		this.MeasurementUnit=measurementUnit;
		this.Name=name;
		this.Description = description;
		this.Brand=brand;
		this.Model=model;		
	}
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public ProductCategory getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.ProductCategory = productCategory;
	}
	public Provider getProvider() {
		return Provider;
	}
	public void setProvider(Provider provider) {
		this.Provider = provider;
	}
	public MeasurementUnit getMeasurementUnit() {
		return MeasurementUnit;
	}
	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.MeasurementUnit = measurementUnit;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	private ProductCategory ProductCategory;
	private Provider Provider;
	private MeasurementUnit MeasurementUnit;
	private String Name;
	private String Description;
	private String Brand;
	private String Model;
	
	private double PriceCost;
	private double Stock;
	
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

	@Override
	public String toString()
	{
		return Name;
	}
}
