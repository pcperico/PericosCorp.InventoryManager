/*******************************************************************************
 * Role
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 *******************************************************************************/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;


/**
*
* @author Arturo E. Salinas
*/
public class Role implements Serializable {
	public Role(){};
	public Role(String name, String description)
	{
		Name = name;
		Description = description;
	}
	
	private static final long serialVersionUID = 1L;	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	private int Id;
	private String Name;
	private String Description;
	private Boolean Status;
	public Boolean isStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}

}
