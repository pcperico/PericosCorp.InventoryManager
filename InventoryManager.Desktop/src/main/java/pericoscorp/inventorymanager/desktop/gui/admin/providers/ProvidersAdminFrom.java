/* 
     * BranchesAdminFrom
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui.admin.providers;

import PericosCorp.InventoryManager.Domain.Entities.Provider;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IProviderRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pericoscorp.inventorymanager.desktop.gui.InternalCenterFrame;

/**
 *
 * @author Arturo E. Salinas
 */
public class ProvidersAdminFrom extends InternalCenterFrame {
    private IProviderRepository pr;
    DefaultTableModel dtm;
    private boolean  isEditing=false;
    /**
     * Creates new form AdminRolesForm
     */
    public ProvidersAdminFrom() {
        initComponents();
        pr= (IProviderRepository)ctx.getBean("IProviderRepository");
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Contacto");  
        dtm.addColumn("Teléfono");  
        dtm.addColumn("Dirección");
        dtm.addColumn("Nit");
        dtm.addColumn("País");
        dtm.addColumn("");        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Find = new javax.swing.JLabel();
        txt_find = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        panelRoles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_providers = new javax.swing.JTable();
        panelAddBranch = new javax.swing.JPanel();
        lb_newRole = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_description = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lb_description1 = new javax.swing.JLabel();
        txt_providerName = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        txt_providerAddress = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        txt_providerCountry = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        jLabel2 = new javax.swing.JLabel();
        txt_providerContactName = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        jLabel3 = new javax.swing.JLabel();
        txt_providerPhone = new pericoscorp.swingcustomcontrolls.NumericTextBox();
        jLabel4 = new javax.swing.JLabel();
        txt_providerNit = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        panelButtons = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();

        setClosable(true);
        setTitle("Admin Proveedores");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(600, 800));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        lb_Find.setText("Buscar proveedor:");
        lb_Find.setToolTipText("");

        btn_Search.setText("Buscar");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        panelRoles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tbl_providers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_providers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_providersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_providers);

        javax.swing.GroupLayout panelRolesLayout = new javax.swing.GroupLayout(panelRoles);
        panelRoles.setLayout(panelRolesLayout);
        panelRolesLayout.setHorizontalGroup(
            panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRolesLayout.setVerticalGroup(
            panelRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAddBranch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelAddBranch.setEnabled(false);

        lb_newRole.setText("Agegar/modificar Proveedores");

        lb_name.setText("* Nombre:");

        lb_description.setText("* Dirección:");

        btn_add.setText("Guardar");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_clear.setText("Limpiar");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        txt_id.setEditable(false);

        lb_description1.setText("* País:");

        txt_providerName.setIsRequired(true);
        txt_providerName.setLength(100);

        txt_providerAddress.setIsRequired(true);
        txt_providerAddress.setLength(200);

        txt_providerCountry.setIsRequired(true);
        txt_providerCountry.setLength(100);

        jLabel2.setText("* Contacto:");

        txt_providerContactName.setIsRequired(true);
        txt_providerContactName.setLength(200);

        jLabel3.setText("  Teléfono:");

        txt_providerPhone.setLength(25);

        jLabel4.setText("* Nit.:");

        txt_providerNit.setIsRequired(true);
        txt_providerNit.setLength(17);
        txt_providerNit.setRegex("\\b\\d{4}[-.]?\\d{6}[-.]?\\d{3}[-.]?\\d{1}\\b");

        javax.swing.GroupLayout panelAddBranchLayout = new javax.swing.GroupLayout(panelAddBranch);
        panelAddBranch.setLayout(panelAddBranchLayout);
        panelAddBranchLayout.setHorizontalGroup(
            panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddBranchLayout.createSequentialGroup()
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_newRole)
                    .addGroup(panelAddBranchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAddBranchLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAddBranchLayout.createSequentialGroup()
                                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_name)
                                    .addGroup(panelAddBranchLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(17, 17, 17)
                                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_providerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_providerContactName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txt_providerNit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelAddBranchLayout.createSequentialGroup()
                                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_description)
                                    .addComponent(lb_description1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_providerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_providerCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txt_providerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelAddBranchLayout.setVerticalGroup(
            panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddBranchLayout.createSequentialGroup()
                .addComponent(lb_newRole)
                .addGap(10, 10, 10)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_name)
                    .addComponent(txt_providerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_providerNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_providerContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_description)
                    .addComponent(txt_providerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_description1)
                    .addComponent(txt_providerCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_providerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_clear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelButtons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btn_edit.setText("Modificar");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_new.setText("Nuevo");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_new, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAddBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lb_Find)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Search))
                    .addComponent(panelRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Find)
                    .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Search))
                .addGap(18, 18, 18)
                .addComponent(panelRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelAddBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void fillTable(List<Provider> providers,DefaultTableModel model)    
    {        
        model.setRowCount(0);
        this.tbl_providers.setModel(model);             
        this.tbl_providers.getColumnModel().getColumn(6).setMinWidth(0);
        this.tbl_providers.getColumnModel().getColumn(6).setMaxWidth(0);        
        Object [] fila = new Object[7];
        for(Provider p:providers)
        {
           fila[0] = p.getName();           
           fila[1] = p.getContactName();           
           fila[2] = p.getPhone();           
           fila[3] = p.getAddress();           
           fila[4] = p.getNit();
           fila[5] = p.getCountry();
           fila[6] = p.getId();           
           model.addRow(fila);
           
           
        }            
    }
     
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        fillTable(pr.GetAll(), dtm);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if(!ValidRequiredFields(panelAddBranch))
            return;
        if(!isEditing)
        {
            int result= pr.CreateNewProvider(this.txt_providerName.getText().trim(),this.txt_providerContactName.getText().trim(),
                    this.txt_providerPhone.getText().trim(),this.txt_providerAddress.getText().trim(),this.txt_providerCountry.getText().trim(),this.txt_providerNit.getText());
            if(result==1) 
            {
               JOptionPane.showMessageDialog(this.getContentPane(), "Proveedor guardado satisfactoriamente");
               this.clearFields(btn_add.getParent());
               isEditing=false;
               fillTable(pr.GetAll(), dtm);
            }       
            else if(result==0)
                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
            else
                JOptionPane.showMessageDialog(this.getContentPane(), "Error al guardar el proveedor, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
        }
        else
        {
            int confirm=JOptionPane.showConfirmDialog(this.getContentPane(), "¿Seguro que desea modificar proveedor?");
            if(confirm!=0)
                return;
            int result= pr.UpdateProvider(Integer.parseInt(this.txt_id.getText()),this.txt_providerName.getText().trim(),
                    this.txt_providerContactName.getText().trim(),this.txt_providerPhone.getText().trim(),
                    this.txt_providerAddress.getText().trim(),this.txt_providerCountry.getText().trim(),this.txt_providerNit.getText());
            if(result==1) 
            {
               JOptionPane.showMessageDialog(this.getContentPane(), "Proveedor actualizado satisfactoriamente");
               this.clearFields(btn_add.getParent());
               isEditing=false;
               fillTable(pr.GetAll(), dtm);
            }       
            else if(result==0)
                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
            else
                JOptionPane.showMessageDialog(this.getContentPane(), "Error al actualizar el proveedor, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.clearFields(btn_clear.getParent());
        isEditing=false;
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        fillTable(pr.FilterByName(this.txt_find.getText()), dtm);
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       if(tbl_providers.getSelectedRow()!=-1)
       {
           fillProvidertoEdit(tbl_providers.getSelectedRow());
           isEditing=true;
           this.txt_providerName.requestFocus();
       }
       else
       {
           JOptionPane.showMessageDialog(this.getContentPane(), "Debe seleccionar el proveedor que desea modificar");
           isEditing=false;
       }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        isEditing=false;
        clearFields(panelAddBranch);
        this.txt_providerName.requestFocus();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tbl_providersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_providersMouseClicked
        clearFields(panelAddBranch);
    }//GEN-LAST:event_tbl_providersMouseClicked
 
    private void fillProvidertoEdit(int providerSelected)
    {        
        this.txt_providerName.setText(this.tbl_providers.getValueAt(providerSelected, 0).toString());
        this.txt_providerContactName.setText(this.tbl_providers.getValueAt(providerSelected, 1).toString());
        this.txt_providerPhone.setText(this.tbl_providers.getValueAt(providerSelected, 2).toString());
        this.txt_providerAddress.setText(this.tbl_providers.getValueAt(providerSelected, 3).toString());
        this.txt_providerNit.setText(this.tbl_providers.getValueAt(providerSelected, 4).toString());        
        this.txt_providerCountry.setText(this.tbl_providers.getValueAt(providerSelected, 5).toString());        
        this.txt_id.setText(this.tbl_providers.getValueAt(providerSelected, 6).toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Find;
    private javax.swing.JLabel lb_description;
    private javax.swing.JLabel lb_description1;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_newRole;
    private javax.swing.JPanel panelAddBranch;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelRoles;
    private javax.swing.JTable tbl_providers;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_id;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_providerAddress;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_providerContactName;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_providerCountry;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_providerName;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_providerNit;
    private pericoscorp.swingcustomcontrolls.NumericTextBox txt_providerPhone;
    // End of variables declaration//GEN-END:variables
}
