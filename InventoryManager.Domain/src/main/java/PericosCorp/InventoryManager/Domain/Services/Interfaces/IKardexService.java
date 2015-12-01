/**
 * IKardexService.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Interfaces;

import java.util.Date;

import javax.swing.table.DefaultTableModel;

public interface IKardexService {
	/**
	 *
	 * @author Arturo E. Salinas
	 */
	
	public DefaultTableModel GenerateKardex(int productId, Date beginDate, Date endDate);
}
