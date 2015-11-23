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
	
	
	/**
	 * Method to create a new instance of entity and childs entities and persists it on database
	 * @param firstName firstname of employee to be created
	 * @param lastName lastname of employee to be created
	 * @param birthDate birtdate of employee to be created
	 * @param phone phone of employee to be created
	 * @param email of employee to be created
	 * @param position position of employee to be created
	 * @param beginDate date of join to the company of employee to be created
	 * @param endDate date of employee left the company
	 * @param address address of employee to be created
	 * @param userName username of the employee to use the system
	 * @param password password to login on the system
	 * @param roleIds ids of roles that the employee will have on the system		
	 * @param branchId id of the branch on the employee will work
	 * @param statusId id of status of the employee
	 * @return
	 * 1 if created and inserted successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	
	public int CreateNewEmployee(String firstName, String lastName, Date birthDate,
			String phone, String email, String position, Date beginDate,
			Date endDate, String address, String userName, String password,
			int[] roleIds, int branchId,int statusId);
	
	/**
	 * Method to create a new instance of entity and childs entities and persists it on database
	 * @param employeeId id of the employee to be edited
	 * @param firstName firstname of employee to be edited
	 * @param lastName lastname of employee to be edited
	 * @param birthDate birtdate of employee to be edited
	 * @param phone phone of employee to be edited
	 * @param email of employee to be edited
	 * @param position position of employee to be edited
	 * @param beginDate date of join to the company of employee to be edited
	 * @param endDate date of employee left the company
	 * @param address address of employee to be edited
	 * @param userName username of the employee to use the system
	 * @param password password to login on the system
	 * @param roleIds ids of roles that the employee will have on the system		
	 * @param branchId id of the branch on the employee will work
	 * @param statusId id of status of the employee
	 * @return
	 * 1 if updated successfully
	 * 0 if instances is incomplete therefore isn't saved,  
	 * -1 if an error happens
	 */
	public int  EditEmployee(int employeeId,String firstName, String lastName, Date birthDate,
			String phone, String email, String position, Date beginDate,
			Date endDate, String address, String userName, String password,
			int[] roleIds, int branchId,int statusId);
}
