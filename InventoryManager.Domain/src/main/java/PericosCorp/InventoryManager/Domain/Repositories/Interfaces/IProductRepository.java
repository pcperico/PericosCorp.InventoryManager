/**
 * IProductRepository.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import java.util.List;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Dtos.ProductDto;
import PericosCorp.InventoryManager.Domain.Entities.Product;

public interface IProductRepository extends IRepository<Product>{
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	/**
	 * Method to search products by name matches
	 * @param name param to search on db 
	 * @return
	 * List of productDto filtered by name
	 */
	public List<ProductDto> FilterByName(String name);
	
	
	/**
	 * Method to search products filter by provider
	 * @param providerId id of provider owner of products to search 
	 * @return
	 * List of productDto filtered by provider
	 */
	public List<ProductDto> FilterByProvider(int providerId);
}
