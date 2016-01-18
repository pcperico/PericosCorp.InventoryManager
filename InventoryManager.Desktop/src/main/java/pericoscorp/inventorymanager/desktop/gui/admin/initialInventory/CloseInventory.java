/*
 * CloseInventory
 * Created on 18-01-2016
 * Copyright(c) 2016 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui.admin.initialInventory;

import PericosCorp.InventoryManager.Domain.Services.Implementations.InitialInventoryService;
import PericosCorp.InventoryManager.Domain.Services.Interfaces.IInitialInventoryService;
import pericoscorp.inventorymanager.desktop.gui.InternalCenterFrame;

/**
 *
 * @author Arturo E. Salinas
 */
public class CloseInventory extends InternalCenterFrame {
    private IInitialInventoryService initialInventoryService;
    /**
     * Creates new form CloseInventory
     */
    public CloseInventory() {
        initComponents();
        initialInventoryService= (InitialInventoryService)ctx.getBean("InitialInventoryService");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_year = new pericoscorp.swingcustomcontrolls.NumericTextBox();
        btn_closeYear = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cerrar Inventario");

        jLabel1.setText("Digite el año a cerrar:");

        btn_closeYear.setText("Cerrar Inventario");
        btn_closeYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btn_closeYear)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_closeYear)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeYearActionPerformed
        System.out.println("Closing year...");
        initialInventoryService.CloseYear(Integer.parseInt(this.txt_year.getText()));
        System.out.println("Year Closed...");
        
    }//GEN-LAST:event_btn_closeYearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_closeYear;
    private javax.swing.JLabel jLabel1;
    private pericoscorp.swingcustomcontrolls.NumericTextBox txt_year;
    // End of variables declaration//GEN-END:variables
}