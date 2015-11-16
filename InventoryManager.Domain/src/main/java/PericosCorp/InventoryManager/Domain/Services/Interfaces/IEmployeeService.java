/**
 * IEmployeeService.java
 * Created on 16/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Interfaces;

import java.util.Date;

public interface IEmployeeService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public void CreateNewEmployee(String firstName, String lastName, Date birthDate,
			String phone, String email, String position, Date beginDate,
			Date endDate, String address, String userName, String password,
			int[] roleIds, int branchId);
	
	public void Test();
}
