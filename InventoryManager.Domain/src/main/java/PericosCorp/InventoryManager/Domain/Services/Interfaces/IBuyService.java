/**
 * IBuyService.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Interfaces;

import java.util.Date;
import java.util.List;

import PericosCorp.InventoryManager.Domain.Dtos.BuyDetailDto;

public interface IBuyService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	
	/**
	 * Method to create a new buy included buy details
	 * @param date buy date
	 * @param numRef number of reference of the buy (number of receipt)
	 * @param providerId provider id 
	 * @param details List of detail of the buy
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int SaveBuy(Date date,String numRef, int providerId,List<BuyDetailDto>details);
}
