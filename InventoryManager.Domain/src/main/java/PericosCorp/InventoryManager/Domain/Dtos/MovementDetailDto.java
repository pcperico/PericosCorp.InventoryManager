/**
 * BuyDetailDto.java
 * Created on 24/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Dtos;

import java.io.Serializable;
import java.util.Date;

public class MovementDetailDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	public MovementDetailDto()
	{}
	
	public MovementDetailDto(int productId, double quantity, double price, int movementType,Date operationDate)
	{
		ProductId = productId;
		Quantity = quantity;
		Price=price;
		MovementType = movementType;
		OperationDate = operationDate;
	}
	private int ProductId;	
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public double getQuantity() {
		return Quantity;
	}
	public void setQuantity(double quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	private double Quantity;
	private double Price;
	private int MovementType;
	private Date OperationDate;
	public Date getOperationDate() {
		return OperationDate;
	}

	public void setOperationDate(Date operationDate) {
		OperationDate = operationDate;
	}

	public int getMovementType() {
		return MovementType;
	}
	public void setMovementType(int movementType) {
		MovementType = movementType;
	}
}
