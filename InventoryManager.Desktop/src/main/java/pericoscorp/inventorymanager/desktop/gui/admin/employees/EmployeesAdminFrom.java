/* 
     * BranchesAdminFrom
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui.admin.employees;
import pericoscorp.inventorymanager.desktop.gui.admin.branches.*;
import PericosCorp.InventoryManager.Domain.Entities.Branch;
import PericosCorp.InventoryManager.Domain.Entities.Employee;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IBranchRepository;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IEmployeeRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pericoscorp.inventorymanager.desktop.gui.InternalCenterFrame;

/**
 *
 * @author Arturo E. Salinas
 */
public class EmployeesAdminFrom extends InternalCenterFrame {
    private IEmployeeRepository er;
    DefaultTableModel dtm;
    private boolean  isEditing=false;
    /**
     * Creates new form AdminRolesForm
     */
    public EmployeesAdminFrom() {
        initComponents();
        er= (IEmployeeRepository)ctx.getBean("IEmployeeRepository");
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Usuario");  
        dtm.addColumn("Fecha I");  
        dtm.addColumn("Fecha F");
        dtm.addColumn("Id");
        
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
        tbl_employees = new javax.swing.JTable();
        panelAddRole = new javax.swing.JPanel();
        lb_newRole = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_description = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_branchName = new pericoscorp.swingcustomcontrolls.TextBoxLength();
        txt_branchAddress = new pericoscorp.swingcustomcontrolls.TextBoxLength();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lb_description1 = new javax.swing.JLabel();
        txt_branchPhone = new pericoscorp.swingcustomcontrolls.NumericTextBox();
        panelButtons = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();

        setClosable(true);
        setTitle("Admin Empleados");
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

        lb_Find.setText("Buscar Empleado:");
        lb_Find.setToolTipText("");

        btn_Search.setText("Buscar");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        panelRoles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tbl_employees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_employees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_employeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_employees);

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

        lb_newRole.setText("Agegar/modificar Empleado");

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

        txt_branchName.setLength(100);

        txt_branchAddress.setLength(200);

        jLabel1.setText("Id:");

        txt_id.setEditable(false);

        lb_description1.setText("   Teléfono:");

        txt_branchPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####-####"))));
        txt_branchPhone.setLength(20);

        javax.swing.GroupLayout panelAddRoleLayout = new javax.swing.GroupLayout(panelAddRole);
        panelAddRole.setLayout(panelAddRoleLayout);
        panelAddRoleLayout.setHorizontalGroup(
            panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddRoleLayout.createSequentialGroup()
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_description)
                            .addComponent(lb_name)
                            .addGroup(panelAddRoleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addComponent(lb_description1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_branchName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_branchAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_branchPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addComponent(lb_newRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panelAddRoleLayout.setVerticalGroup(
            panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddRoleLayout.createSequentialGroup()
                .addComponent(lb_newRole)
                .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(lb_name)
                        .addGap(15, 15, 15)
                        .addComponent(lb_description)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_description1)
                            .addComponent(txt_branchPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_clear)))
                    .addGroup(panelAddRoleLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_branchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txt_branchAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

     private void fillTable(List<Employee> employees,DefaultTableModel model)    
    {        
        model.setRowCount(0);
        this.tbl_employees.setModel(model);             
        this.tbl_employees.getColumnModel().getColumn(3).setMinWidth(0);
        this.tbl_employees.getColumnModel().getColumn(3).setMaxWidth(0);        
        Object [] fila = new Object[4];
        for(Employee e:employees)
        {
           fila[0] = e.getFullName();
           fila[1] = e.getUserName();
           fila[2] =e.getBeginDate().toString();
           fila[3] = e.getEndDate();
           fila[3] = e.getId();
           model.addRow(fila);
        }            
    }
     
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        fillTable(er.GetAll(), dtm);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
//        if(!isEditing)
//        {
//            int result= br.CreateNewBranch(this.txt_branchName.getText(),this.txt_branchAddress.getText(),this.txt_branchPhone.getText());
//            if(result==1) 
//            {
//               JOptionPane.showMessageDialog(this.getContentPane(), "Sucursal guardada satisfactoriamente");
//               this.clearFields(btn_add.getParent());
//               isEditing=false;
//               fillTable(br.GetAll(), dtm);
//            }       
//            else if(result==0)
//                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
//            else
//                JOptionPane.showMessageDialog(this.getContentPane(), "Error al guardar la sucursal, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
//        }
//        else
//        {
//            int confirm=JOptionPane.showConfirmDialog(this.getContentPane(), "¿Seguro que desea modificar esta sucursal?");
//            if(confirm!=0)
//                return;
//            int result= br.UpdateBranch(Integer.parseInt(this.txt_id.getText()),this.txt_branchName.getText().trim(),this.txt_branchAddress.getText().trim(),this.txt_branchPhone.getText());
//            if(result==1) 
//            {
//               JOptionPane.showMessageDialog(this.getContentPane(), "Sucursal actualizada satisfactoriamente");
//               this.clearFields(btn_add.getParent());
//               isEditing=false;
//               fillTable(br.GetAll(), dtm);
//            }       
//            else if(result==0)
//                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
//            else
//                JOptionPane.showMessageDialog(this.getContentPane(), "Error al actualizar la sucursal, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
//        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.clearFields(btn_clear.getParent());
        isEditing=false;
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
//        fillTable(br.FilterByName(this.txt_find.getText()), dtm);
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       if(tbl_employees.getSelectedRow()!=-1)
       {
           fillRoletoEdit(tbl_employees.getSelectedRow());
           isEditing=true;
       }
       else
       {
           JOptionPane.showMessageDialog(this.getContentPane(), "Debe seleccionar la sucursal que desea modificar");
           isEditing=false;
       }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        isEditing=false;
        clearFields(panelAddRole);
        this.txt_branchName.requestFocus();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tbl_employeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_employeesMouseClicked
        clearFields(panelAddRole);
    }//GEN-LAST:event_tbl_employeesMouseClicked

    private boolean isSelectedRow()
    {
        return tbl_employees.getSelectedRow()!=-1;
    }
    
    private int getSelectedRow()
    {
        return tbl_employees.getSelectedRow();
    }
    
    private void fillRoletoEdit(int branchSelected)
    {        
        this.txt_branchName.setText(this.tbl_employees.getValueAt(branchSelected, 0).toString());
        this.txt_branchAddress.setText(this.tbl_employees.getValueAt(branchSelected, 1).toString());
        this.txt_branchPhone.setText(this.tbl_employees.getValueAt(branchSelected, 2).toString());
        this.txt_id.setText(this.tbl_employees.getValueAt(branchSelected, 3).toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Find;
    private javax.swing.JLabel lb_description;
    private javax.swing.JLabel lb_description1;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_newRole;
    private javax.swing.JPanel panelAddRole;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelRoles;
    private javax.swing.JTable tbl_employees;
    private pericoscorp.swingcustomcontrolls.TextBoxLength txt_branchAddress;
    private pericoscorp.swingcustomcontrolls.TextBoxLength txt_branchName;
    private pericoscorp.swingcustomcontrolls.NumericTextBox txt_branchPhone;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
