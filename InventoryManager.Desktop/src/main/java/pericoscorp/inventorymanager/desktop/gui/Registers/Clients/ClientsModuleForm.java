/* 
     * BranchesAdminFrom
     * Created on 03-11-2015
     * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
     * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui.Registers.Clients;


import PericosCorp.InventoryManager.Domain.Entities.Client;
import PericosCorp.InventoryManager.Domain.Repositories.Interfaces.IClientRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pericoscorp.inventorymanager.desktop.gui.InternalCenterFrame;

/**
 *
 * @author Arturo E. Salinas
 */
public class ClientsModuleForm extends InternalCenterFrame {
    private IClientRepository clientRepository;
    DefaultTableModel dtm;
    private boolean  isEditing=false;
    /**
     * Creates new form AdminRolesForm
     */
    public ClientsModuleForm() {
        initComponents();
        clientRepository= (IClientRepository)ctx.getBean("IClientRepository");
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Dirección");  
        dtm.addColumn("Teléfono");          
        dtm.addColumn("");   
        DefaultComboBoxModel genders = new DefaultComboBoxModel();
        genders.addElement("Seleccione el genero");
        genders.addElement("M");
        genders.addElement("F");
        this.cmb_gender.setModel(genders);
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
        tbl_clients = new javax.swing.JTable();
        panelAddBranch = new javax.swing.JPanel();
        lb_newRole = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_description = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lb_description1 = new javax.swing.JLabel();
        txt_clientFirstName = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        txt_address = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        jLabel2 = new javax.swing.JLabel();
        txt_clientLastName = new pericoscorp.swingcustomcontrolls.BaseTextBoxValidated();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_clientBirthDate = new pericoscorp.swingcustomcontrolls.DateTextBox();
        cmb_gender = new pericoscorp.swingcustomcontrolls.BaseComboBoxValidated();
        txt_clientPhone = new pericoscorp.swingcustomcontrolls.NumericTextBox();
        panelButtons = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();

        setClosable(true);
        setTitle("Clientes");
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

        lb_Find.setText("Buscar cliente:");
        lb_Find.setToolTipText("");

        btn_Search.setText("Buscar");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        panelRoles.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tbl_clients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_clients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_clients);

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

        lb_newRole.setText("Agegar/modificar Clientes");

        lb_name.setText("* Nombres:");

        lb_description.setText("   Teléfono:");

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

        lb_description1.setText("   Direccion:");

        txt_clientFirstName.setIsRequired(true);
        txt_clientFirstName.setLength(200);

        txt_address.setLength(200);

        jLabel2.setText("* Apellidos:");

        txt_clientLastName.setIsRequired(true);
        txt_clientLastName.setLength(200);

        jLabel3.setText("* Genero:");

        jLabel4.setText("* Fecha de Nac.:");

        txt_clientBirthDate.setIsRequired(true);

        cmb_gender.setIsRequired(true);

        javax.swing.GroupLayout panelAddBranchLayout = new javax.swing.GroupLayout(panelAddBranch);
        panelAddBranch.setLayout(panelAddBranchLayout);
        panelAddBranchLayout.setHorizontalGroup(
            panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddBranchLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
            .addGroup(panelAddBranchLayout.createSequentialGroup()
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddBranchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_name)
                            .addGroup(panelAddBranchLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(lb_description)
                            .addComponent(lb_description1))
                        .addGap(30, 30, 30)
                        .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_clientFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_clientLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_clientBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_gender, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_clientPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lb_newRole))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAddBranchLayout.setVerticalGroup(
            panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddBranchLayout.createSequentialGroup()
                .addComponent(lb_newRole)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddBranchLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_name)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(panelAddBranchLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_clientFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txt_clientLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_clientBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_description)
                    .addComponent(txt_clientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_description1)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddBranchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_clear))
                .addContainerGap(21, Short.MAX_VALUE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelAddBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelAddBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void fillTable(List<Client> clients,DefaultTableModel model)    
    {        
        model.setRowCount(0);
        this.tbl_clients.setModel(model);             
        this.tbl_clients.getColumnModel().getColumn(3).setMinWidth(0);
        this.tbl_clients.getColumnModel().getColumn(3).setMaxWidth(0);        
        Object [] fila = new Object[4];
        for(Client c:clients)
        {
           fila[0]=c.getFullName();
           fila[1]=c.getAddress();
           fila[2]=c.getPhone();
           fila[3]=c.getId();
           model.addRow(fila);
        }            
    }
     
    private void fillProvidertoEdit(int clientSelected)
    {   
        this.txt_id.setText(this.tbl_clients.getValueAt(clientSelected, 3).toString());
        Client client = clientRepository.Get(Integer.parseInt(this.txt_id.getText()));
        this.txt_clientFirstName.setText(client.getFirstName());
        this.txt_clientLastName.setText(client.getLastName());
        this.txt_clientBirthDate.setText(client.getDateString());
        this.txt_address.setText(client.getAddress());
        this.txt_clientPhone.setText(client.getPhone());
        this.cmb_gender.setSelectedItem(client.getGender());
    }
     
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        fillTable(clientRepository.GetAll(), dtm);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if(!ValidRequiredFields(panelAddBranch))
            return;
        if(!isEditing)
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate=null;
            try {
                birthDate = formatter.parse(this.txt_clientBirthDate.getText());
            } catch (ParseException ex) {
                Logger.getLogger(ClientsModuleForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            int result= clientRepository.CreateNewClient(this.txt_clientFirstName.getText().trim(), this.txt_clientLastName.getText().trim(),
                    birthDate, this.cmb_gender.getSelectedItem().toString(), this.txt_clientPhone.getText().trim(),this.txt_address.getText().trim());
            if(result==1) 
            {
               JOptionPane.showMessageDialog(this.getContentPane(), "Cliente guardado satisfactoriamente");
               this.clearFields(btn_add.getParent());
               isEditing=false;
               fillTable(clientRepository.GetAll(), dtm);
            }       
            else if(result==0)
                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
            else
                JOptionPane.showMessageDialog(this.getContentPane(), "Error al guardar el cliente, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
        }
        else
        {
             SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate=null;
            try {
                birthDate = formatter.parse(this.txt_clientBirthDate.getText());
            } catch (ParseException ex) {
                Logger.getLogger(ClientsModuleForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            int confirm=JOptionPane.showConfirmDialog(this.getContentPane(), "¿Seguro que desea modificar este cliente?");
            if(confirm!=0)
                return;
            int result= clientRepository.UpdateClient(Integer.parseInt(this.txt_id.getText()),this.txt_clientFirstName.getText().trim(), this.txt_clientLastName.getText().trim(),
                    birthDate, this.cmb_gender.getSelectedItem().toString(), this.txt_clientPhone.getText().trim(),this.txt_address.getText().trim());
            if(result==1) 
            {
               JOptionPane.showMessageDialog(this.getContentPane(), "Cliente actualizado satisfactoriamente");
               this.clearFields(btn_add.getParent());
               isEditing=false;
               fillTable(clientRepository.GetAll(), dtm);
            }       
            else if(result==0)
                JOptionPane.showMessageDialog(this.getContentPane(), "Debe completar los campos obligatorios (*)");
            else
                JOptionPane.showMessageDialog(this.getContentPane(), "Error al actualizar el cliente, porfavor intente de nuevo, si el problema persiste contactor al administrador del sistema");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        this.clearFields(btn_clear.getParent());
        isEditing=false;
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
//        fillTable(clientRepository.FilterByName(this.txt_find.getText()), dtm);
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       if(tbl_clients.getSelectedRow()!=-1)
       {
           fillProvidertoEdit(tbl_clients.getSelectedRow());
           isEditing=true;
           this.txt_clientFirstName.requestFocus();
       }
       else
       {
           JOptionPane.showMessageDialog(this.getContentPane(), "Debe seleccionar el cliente que desea modificar");
           isEditing=false;
       }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        isEditing=false;
        clearFields(panelAddBranch);
        this.txt_clientFirstName.requestFocus();
    }//GEN-LAST:event_btn_newActionPerformed

    private void tbl_clientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientsMouseClicked
        clearFields(panelAddBranch);
    }//GEN-LAST:event_tbl_clientsMouseClicked
 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private pericoscorp.swingcustomcontrolls.BaseComboBoxValidated cmb_gender;
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
    private javax.swing.JTable tbl_clients;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_address;
    private pericoscorp.swingcustomcontrolls.DateTextBox txt_clientBirthDate;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_clientFirstName;
    private pericoscorp.swingcustomcontrolls.BaseTextBoxValidated txt_clientLastName;
    private pericoscorp.swingcustomcontrolls.NumericTextBox txt_clientPhone;
    private javax.swing.JTextField txt_find;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
