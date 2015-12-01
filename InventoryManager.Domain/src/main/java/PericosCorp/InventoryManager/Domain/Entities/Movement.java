/**
 * Movement.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Movement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public Movement(){}
	
	public Movement(Date date,String numRef,Provider provider)
	{
		Date=date;
		NumRef = numRef;
		Provider = provider;
	}
	public Movement(Date date,String numRef,Client client)
	{
		Date=date;
		NumRef = numRef;
		Client = client;
	}
	
	private int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getNumRef() {
		return NumRef;
	}
	public void setNumRef(String numRef) {
		NumRef = numRef;
	}
	public Provider getProvider() {
		return Provider;
	}
	public void setProvider(Provider provider) {
		this.Provider = provider;
	}
	public Client getClient() {
		return Client;
	}
	public void setClient(Client client) {
		Client = client;
	}
	private Date Date;
	private String NumRef;
	private Provider Provider;
	private Client Client;
	public Set<MovementDetail> getMovementDetails() {
		return MovementDetails;
	}
	public void setMovementDetails(Set<MovementDetail> movements) {
		MovementDetails = movements;
	}
	private Set<MovementDetail> MovementDetails = new HashSet<MovementDetail>();
}
