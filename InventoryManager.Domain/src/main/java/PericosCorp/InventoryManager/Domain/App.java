/*******************************************************************************
 * AdminRolesForm
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain;



import PericosCorp.InventoryManager.Domain.Repositories.Implementations.InitialInventoryRepository;

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
