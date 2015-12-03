/**
 * IProductService.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Interfaces;

public interface IProductService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	/**
	 * Method to create a new product
	 * @param productCategoryId product category on product belongs
	 * @param providerId id of provider owner of product
	 * @param measurementId id of measurement unit of product
	 * @param name product name
	 * @param description product description
	 * @param brand product brand
	 * @param model model product
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int CreateNewProduct(int productCategoryId, int providerId,int measurementId,String name,String description, String brand,String model,double salePrice);
	
	/**
	 * Method to update a  product
	 * @param productId product id
	 * @param productCategoryId product category on product belongs
	 * @param providerId id of provider owner of product
	 * @param measurementId id of measurement unit of product
	 * @param name product name
	 * @param description product description
	 * @param brand product brand
	 * @param model model product
	 * @return
	 * 1 if modified successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int UpdateProduct(int productId,int productCategoryId, int providerId,int measurementId,String name,String description, String brand,String model,double salePrice);
	
	public void UpdatePriceCost(int productId,double quantity, double newPriceCost);
}
