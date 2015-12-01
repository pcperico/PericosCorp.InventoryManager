/**
 * KardexService.java
 * Created on 26/11/2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
*/
package PericosCorp.InventoryManager.Domain.Services.Implementations;

import java.util.Date;

import javax.swing.table.DefaultTableModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IMovementRepository;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IKardexService;

public class KardexService implements IKardexService {	
	private IMovementRepository movementRepository;
	
	public KardexService()
	{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("DomainServicesContext.xml");	
		movementRepository =(IMovementRepository)ctx.getBean("IMovementRepository");
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public DefaultTableModel GenerateKardex(int productId, Date beginDate,
			Date endDate) {
		movementRepository.GetByProduct(productId);
		return null;
	}
	/**
	 *
	 * @author Arturo E. Salinas
	 */
}
