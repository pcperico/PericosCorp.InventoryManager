/*******************************************************************************
 * AdminRolesForm
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import PericosCorp.InventoryManager.Domain.Dtos.MovementDetailDto;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Repositories.Implementations.MovementRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Implementations.ProductRepository;
import PericosCorp.InventoryManager.Domain.Services.Implementations.MovementService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 List<MovementDetailDto>details = new ArrayList<MovementDetailDto>();
    	 MovementDetailDto detail = new MovementDetailDto();
         detail.setPrice(23);
         detail.setProductId(11);
         detail.setQuantity(10);
         details.add(detail);    	 
    	MovementService movementService = new MovementService();
    	ProductRepository productRepository = new ProductRepository();
    	int res = movementService.SaveMovement(new Date(), "1323456",6,0, details);
    	Product p = productRepository.Get(11);
    	System.out.println(p.getStock());

    }
}
