/**
 * Buy.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Sale implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Sale()
	{
		
	}
	public Sale(Date date, String numRef, Client client)
	{
		Date=date;
		NumRef = numRef;
		Client = client;
	}
	
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

	public String getNumRef() {
		return NumRef;
	}
	public void setNumRef(String numRef) {
		NumRef = numRef;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	private Client Client;
	public Client getClient() {
		return Client;
	}
	public void setClient(Client client) {
		Client = client;
	}

	private String NumRef;
	private Date Date;
	private Set<SaleDetail> SaleDetails = new HashSet<SaleDetail>();
	public Set<SaleDetail> getSaleDetails() {
		return SaleDetails;
	}
	public void setSaleDetails(Set<SaleDetail> saleDetails) {
		SaleDetails = saleDetails;
	}
	
}
