/**
 * IProductCategoryRepository.java
 * Created on 19/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Dtos.CategoryProductDto;
import PericosCorp.InventoryManager.Domain.Entities.ProductCategory;

public interface IProductCategoryRepository extends IRepository<ProductCategory>{
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	/**
	 * Method to create a new instance of entity and persists it on database
	 * @param name name of the Product Category
	 * @param description description of the Product Category	 
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int CreateNewProductCategory(String name,String description);
	
	/**
	 * Update existing branch on bd.
	 * @param id id of product category to be updated
	 * @param name product category name
	 * @param description product category description	 
	 * @return 
	 * 1 if instance was updated successfully, 
	 * 0 if instances is incomplete therefore isn't updated,  
	 * -1 if an error happens
	 */
	public int UpdateProductCategory(int id,String name,String description);
	
	

	/**
	 * Method to find product category by name matches
	 * @param name name to be search on bd 
	 * @return a list of product category entites that name contains match with name param
	 */
	
	public List<CategoryProductDto>FilterByName(String name);
	
	/**
	 * Method to find product category with total of products associated with this category
	 * @return a list of product category with total of products
	 */
	public List<CategoryProductDto>GetAllWithProductsCount();
}
