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
import PericosCorp.InventoryManager.Domain.Entities.InitialInventory;
import PericosCorp.InventoryManager.Domain.Entities.Product;
import PericosCorp.InventoryManager.Domain.Repositories.Implementations.InitialInventoryRepository;
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
    	 InitialInventoryRepository ii = new InitialInventoryRepository();    	 
    	
    	System.out.println(ii.FindByProductAndYear(11, 2015).getStock());

    }
}
