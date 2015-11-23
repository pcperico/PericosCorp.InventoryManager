/**
 * MeasurementUnit.java
 * Created on 23/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;

public class MeasurementUnit implements Serializable{
	/**
	 * 
	 */
	
	public MeasurementUnit(){};
	public MeasurementUnit(String name,String abbreviation)
	{
		Name = name;
		Abbreviation=abbreviation;
	}
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	private int Id;
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
	public String getAbbreviation() {
		return Abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		Abbreviation = abbreviation;
	}
	private String Name;
	private String Abbreviation;
	
	@Override
	public String toString()
	{
		return Name;
	}
}
