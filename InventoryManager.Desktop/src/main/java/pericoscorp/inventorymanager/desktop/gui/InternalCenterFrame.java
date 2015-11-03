/* 
     * InternalCenterFrame
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui;

import java.awt.Dimension;

/**
 *
 * @author Arturo E. Salinas
 */
public class InternalCenterFrame extends javax.swing.JInternalFrame  {
    
    public InternalCenterFrame()
    {
        
    }
    @Override
    public void show()
    {
        Dimension dim = this.getParent().getSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        super.show();
    }
}
