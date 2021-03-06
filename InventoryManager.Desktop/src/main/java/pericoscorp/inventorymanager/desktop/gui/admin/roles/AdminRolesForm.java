/* 
     * AdminRolesForm
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui.admin.roles;

import PericosCorp.InventoryManager.Domain.Entities.Role;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IRoleRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pericoscorp.inventorymanager.desktop.gui.InternalCenterFrame;

/**
 *
 * @author Arturo E. Salinas
 */
public class AdminRolesForm extends InternalCenterFrame {
    private IRoleRepository rr;
    DefaultTableModel dtm;
    private boolean  isEditing=false;
    /**
     * Creates new form AdminRolesForm
     */
    public AdminRolesForm() {
        initComponents();
        rr= (IRoleRepository)ctx.getBean("IRoleRepository");
        dtm = new DefaultTableModel();
        dtm.addColumn("Name");
        dtm.addColumn("Description");  
        dtm.addColumn("Estado");  
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
        tbl_roles = new javax.swing.JTable();
        panelAddRole = new javax.swing.JPanel();
        lb_newRole = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_description = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_roleName = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        txt_roleDescription = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        panelButtons = new javax.swing.JPanel();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();

        setClosable(true);
        setTitle("Admin Roles");
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

        lb_Find.setText("Buscar rol:");
        lb_Find.setToolTipText("");

        btn_Search.setText("Buscar");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        panelRoles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tbl_roles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_roles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_rolesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_roles);

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

        panelAddRole.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelAddRole.setEnabled(false);

        lb_newRole.setText("Agegar/modificar rol");

        lb_name.setText("* Nombre:");

        lb_description.setText("* Descripción:");

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

        txt_roleName.setIsRequired(true);
        txt_roleName.setLength(50);

        txt_roleDescription.setIsRequired(true);
        txt_roleDescription.setLength(250);

        javax.swing.GroupLayout panelAddRoleLayout = new javax.swing.GroupLayout(panelAddRole);
        panelAddRole.setLayout(panelAddRoleLayout);
        panelAddRoleLayout.setHorizontalGroup(
            panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddRoleLayout.createSequentialGroup()
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_description)
                    .addComponent(lb_name)
                    .addComponent(lb_newRole)
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_roleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_roleDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAddRoleLayout.setVerticalGroup(
            panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddRoleLayout.createSequentialGroup()
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addComponent(lb_newRole)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_name)
                    .addComponent(txt_roleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_description)
                    .addComponent(txt_roleDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_clear))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        panelButtons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btn_delete.setText("Activar / Desactivar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

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
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_Find)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_find, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Search))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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
                    .addComponent(panelAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void fillTable(List<Role> roles,DefaultTableModel model)    
    {        
        model.setRowCount(0);
        this.tbl_roles.setModel(model);             
        this.tbl_roles.getColumnModel().getColumn(3).setMinWidth(0);
        this.tbl_roles.getColumnModel().getColumn(3).setMaxWidth(0);        
        Object [] fila = new Object[4];
        for(Role r:roles)
        {
           fila[0] = r.getName();
           fila[1] = r.getDescription();
           fila[2] = (r.isStatus()?"Activo":"Inactivo");
           fila[3] = r.getId();           
           model.addRow(fila);
        }            
    }
     
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        fillTable(rr.GetAll(), dtm);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if(!ValidRequiredFields(this.panelAddRole))
            return;
        if(!isEditing)
        {
            int result= rr.CreateNewRole(this.txt_roleName.getText().trim(),this.txt_roleDescription.getText().trim());
            if(result==1) 
            {
               JOptionPane.showMessageDialog(this.getContentPane(), "Rol guardado satisfactoriamente");
               this.clearFields(btn_add.getParent());
               isEditing=false;
               fillTable(rr.GetAll(), dtm);
            }       
            else if(result==0)
                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
            else
                JOptionPane.showMessageDialog(this.getContentPane(), "Error al guardar el rol, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
        }
        else
        {
            int confirm=JOptionPane.showConfirmDialog(this.getContentPane(), "¿Seguro que desea modificar este rol?");
            if(confirm!=0)
                return;
            int result= rr.UpdateRole(Integer.parseInt(this.txt_id.getText()),this.txt_roleName.getText().trim(),this.txt_roleDescription.getText().trim());
            if(result==1) 
            {
               JOptionPane.showMessageDialog(this.getContentPane(), "Rol actualizado satisfactoriamente");
               this.clearFields(btn_add.getParent());
               isEditing=false;
               fillTable(rr.GetAll(), dtm);
            }       
            else if(result==0)
                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
            else
                JOptionPane.showMessageDialog(this.getContentPane(), "Error al actualizar el rol, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.clearFields(btn_clear.getParent());
        isEditing=false;
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        fillTable(rr.FilterByName(this.txt_find.getText()), dtm);
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       if(tbl_roles.getSelectedRow()!=-1)
       {
           fillRoletoEdit(tbl_roles.getSelectedRow());
           isEditing=true;
           this.txt_roleName.requestFocus();
       }
       else
       {
           JOptionPane.showMessageDialog(this.getContentPane(), "Debe seleccionar el rol que desea modificar");
           isEditing=false;
       }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        isEditing=false;
        clearFields(panelAddRole);
        this.txt_roleName.requestFocus();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(isSelectedRow())
        {
            int confirm = JOptionPane.showConfirmDialog(this.getContentPane(), "¿Está seguro que desea modificar este rol?");
            if(confirm==0)
            {
               if(rr.TouchRoleStatus(Integer.parseInt(tbl_roles.getValueAt(getSelectedRow(), 3).toString()))==1)
               {
                   JOptionPane.showMessageDialog(this.getContentPane(), "Rol actualizado correctamente");
                   fillTable(rr.GetAll(), dtm);
               }
               else
                   JOptionPane.showMessageDialog(this.getContentPane(), "Ocurrio un error mientras se actualizaba el rol seleccionado, por favor reintente o ponganse en contacto con el administrador del sistema");
            }            
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_rolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rolesMouseClicked
        clearFields(panelAddRole);
    }//GEN-LAST:event_tbl_rolesMouseClicked

    private boolean isSelectedRow()
    {
        return tbl_roles.getSelectedRow()!=-1;
    }
    
    private int getSelectedRow()
    {
        return tbl_roles.getSelectedRow();
    }
    
    private void fillRoletoEdit(int roleSelected)
    {        
        this.txt_roleName.setText(this.tbl_roles.getValueAt(roleSelected, 0).toString());
        this.txt_roleDescription.setText(this.tbl_roles.getValueAt(roleSelected, 1).toString());
        this.txt_id.setText(this.tbl_roles.getValueAt(roleSelected, 3).toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Find;
    private javax.swing.JLabel lb_description;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_newRole;
    private javax.swing.JPanel panelAddRole;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelRoles;
    private javax.swing.JTable tbl_roles;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_id;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_roleDescription;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_roleName;
    // End of variables declaration//GEN-END:variables
}
