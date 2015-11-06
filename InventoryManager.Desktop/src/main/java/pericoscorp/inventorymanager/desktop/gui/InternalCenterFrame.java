/* 
     * InternalCenterFrame
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Arturo E. Salinas
 */
public class InternalCenterFrame extends javax.swing.JInternalFrame  {
    protected ApplicationContext ctx;
    public InternalCenterFrame()
    {
        if(ctx==null)
            ctx = new ClassPathXmlApplicationContext("repositories.xml");
        
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
        }
    }
    
//    private void fillTableUnits(List<T> categories,DefaultTableModel model)    
//    {        
//        model.setRowCount(0);
//        this.tbl_categories.setModel(model);             
//        this.tbl_categories.getColumnModel().getColumn(2).setMinWidth(0);
//        this.tbl_categories.getColumnModel().getColumn(2).setMaxWidth(0);
//        Object [] fila = new Object[3];
//        for(CategoryDto c:categories)
//        {
//           fila[0] = c.getDescription();
//           fila[1] = c.getTotalProducts(); 
//           fila[2] = c.getId();
//           model.addRow(fila);
//        }    
//        this.lb_counter.setText("Total de Categorias: "+String.valueOf(categories.size()));
//    }
}
