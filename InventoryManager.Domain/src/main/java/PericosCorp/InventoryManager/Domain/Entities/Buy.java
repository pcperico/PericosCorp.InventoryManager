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

public class Buy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Buy()
	{
		
	}
	public Buy(Date date, String numRef, Provider provider)
	{
		Date=date;
		NumRef = numRef;
		Provider = provider;
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
	public Provider getProvider() {
		return Provider;
	}
	public void setProvider(Provider provider) {
		Provider = provider;
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
	private Provider Provider;
	private String NumRef;
	private Date Date;
	private Set<BuyDetail> BuyDetails = new HashSet<BuyDetail>();
	public Set<BuyDetail> getBuyDetails() {
		return BuyDetails;
	}
	public void setBuyDetails(Set<BuyDetail> buyDetails) {
		BuyDetails = buyDetails;
	}
}
