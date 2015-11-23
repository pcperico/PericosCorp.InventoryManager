/* 
     * InternalCenterFrame
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui;

import PericosCorp.Framework.Core.Services.Interfaces.ILoggerService;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pericoscorp.swingcustomcontrolls.BaseTextBoxValidated;

/**
 *
 * @author Arturo E. Salinas
 */
public class InternalCenterFrame extends javax.swing.JInternalFrame  {
    protected ApplicationContext ctx;
    protected ILoggerService loggerService;
    protected Date ConvertToDate(String date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateRes = formatter.parse(date);            
            return dateRes;
        } catch (ParseException ex) {
            loggerService.LogSever(ex);
        }
        return null;
    }
    public InternalCenterFrame()
    {
        if(ctx==null)
            ctx = new ClassPathXmlApplicationContext("repositories.xml");
        if(loggerService==null)
            loggerService=(ILoggerService)ctx.getBean("ILoggerServiceDesktop");
        
    }
    @Override
    public void show()
    {
        Dimension dim = this.getParent().getSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        super.show();
    }
    
    protected void clearFields(Container container)
    {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) { 
               ((JTextField)c).setText("");
            }
            if(c instanceof JComboBox)
            {
                ((JComboBox)c).setSelectedIndex(0);
            }
        }
    }
    
    protected boolean ValidRequiredFields(Container container)
    {
        boolean isValid=true;
        for (Component c : container.getComponents()) {
            if (c instanceof BaseTextBoxValidated) { 
               if(((BaseTextBoxValidated)c).IsRequired&&((BaseTextBoxValidated)c).getText().isEmpty())
               {
                 JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");                 
                 isValid=false;
                 break;                 
               }                  
            }
        }
        return isValid;
    }
}
