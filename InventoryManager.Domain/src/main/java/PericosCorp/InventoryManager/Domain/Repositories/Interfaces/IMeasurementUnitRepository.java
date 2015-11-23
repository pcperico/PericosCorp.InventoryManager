/**
 * IMeasurementUnitRepository.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Repositories.Interfaces;

import PericosCorp.Framework.Data.IRepository;
import PericosCorp.InventoryManager.Domain.Entities.MeasurementUnit;

public interface IMeasurementUnitRepository extends IRepository<MeasurementUnit> {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	/**
	 * Method to create a new instance of entity and persists it on database
	 * @param name name of the MeasurementUnit
	 * @param abbreviation abbreviation of the MeasurementUnit
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int CreateNewMeasurementUnit(String name,String abbreviation);
	
	/**
	 * Update existing MeasurementUnit on bd.
	 * @param id id of MeasurementUnit to be updated
	 * @param name MeasurementUnit
	 * @param abbreviation abbreviation of the MeasurementUnit
	 * @return 
	 * 1 if instance was updated successfully, 
	 * 0 if instances is incomplete therefore isn't updated,  
	 * -1 if an error happens
	 */
	public int UpdateMeasurementUnit(int id,String name,String abreviation);	
		
}
