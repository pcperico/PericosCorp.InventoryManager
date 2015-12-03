/**
 * Provider.java
 * Created on 20/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;

public class Provider implements Serializable{
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public Provider(){};
	public Provider(String name, String contactName,String phone, String address,String country)
	{
		Name=name;
		ContactName=contactName;
		Phone=phone;
		Address=address;
		Country = country;
	}
	private static final long serialVersionUID = 1L;
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
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	private String Name;
	private String ContactName;
	private String Phone;
	private String Address;
	private String Country;
	private String Nit;
	
	public String getNit() {
		return Nit;
	}
	public void setNit(String nit) {
		Nit = nit;
	}
	@Override
	public String toString()
	{
		return Name;
	}
	
	
}
