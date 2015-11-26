/* 
 * Principal
 * Created on 03-11-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui;

import javax.swing.UIManager;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel;
import pericoscorp.inventorymanager.desktop.gui.Admin.Products.CategoriesAdminFrom;
import pericoscorp.inventorymanager.desktop.gui.Registers.InMovementsForm;
import pericoscorp.inventorymanager.desktop.gui.Registers.OutsMovementsForm;
import pericoscorp.inventorymanager.desktop.gui.admin.branches.BranchesAdminFrom;
import pericoscorp.inventorymanager.desktop.gui.admin.employees.EmployeesAdminFrom;
import pericoscorp.inventorymanager.desktop.gui.admin.Products.MeasurementUnitAdminFrom;
import pericoscorp.inventorymanager.desktop.gui.admin.Products.ProductAdminFrom;
import pericoscorp.inventorymanager.desktop.gui.admin.providers.ProvidersAdminFrom;
import pericoscorp.inventorymanager.desktop.gui.admin.roles.AdminRolesForm;

/**
 *
 * @author Arturo E. Salinas
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {        
        initComponents();
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        AdminMenu = new javax.swing.JMenu();
        RolesMenu = new javax.swing.JMenuItem();
        BranchesMenu = new javax.swing.JMenuItem();
        employeesMenu = new javax.swing.JMenuItem();
        menu_Products = new javax.swing.JMenu();
        menu_Categories = new javax.swing.JMenuItem();
        menu_ProductsSubMenu = new javax.swing.JMenuItem();
        menu_units = new javax.swing.JMenuItem();
        menu_Providers = new javax.swing.JMenuItem();
        MovementsMenu = new javax.swing.JMenu();
        InMovementsMenu = new javax.swing.JMenuItem();
        OutMovementsMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 800));

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));

        AdminMenu.setMnemonic('f');
        AdminMenu.setText("Administración");

        RolesMenu.setMnemonic('o');
        RolesMenu.setText("Roles");
        RolesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolesMenuActionPerformed(evt);
            }
        });
        AdminMenu.add(RolesMenu);

        BranchesMenu.setText("Sucursales");
        BranchesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BranchesMenuActionPerformed(evt);
            }
        });
        AdminMenu.add(BranchesMenu);

        employeesMenu.setText("Empleados");
        employeesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesMenuActionPerformed(evt);
            }
        });
        AdminMenu.add(employeesMenu);

        menu_Products.setText("Productos");

        menu_Categories.setText("Categorias");
        menu_Categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CategoriesActionPerformed(evt);
            }
        });
        menu_Products.add(menu_Categories);

        menu_ProductsSubMenu.setText("Productos");
        menu_ProductsSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ProductsSubMenuActionPerformed(evt);
            }
        });
        menu_Products.add(menu_ProductsSubMenu);

        menu_units.setText("Unidades de Medida");
        menu_units.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_unitsActionPerformed(evt);
            }
        });
        menu_Products.add(menu_units);

        AdminMenu.add(menu_Products);

        menu_Providers.setText("Proveedores");
        menu_Providers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ProvidersActionPerformed(evt);
            }
        });
        AdminMenu.add(menu_Providers);

        menuBar.add(AdminMenu);

        MovementsMenu.setText("Registros");

        InMovementsMenu.setText("Entradas");
        InMovementsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InMovementsMenuActionPerformed(evt);
            }
        });
        MovementsMenu.add(InMovementsMenu);

        OutMovementsMenu.setText("Salidas");
        OutMovementsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutMovementsMenuActionPerformed(evt);
            }
        });
        MovementsMenu.add(OutMovementsMenu);

        menuBar.add(MovementsMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RolesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolesMenuActionPerformed
        AdminRolesForm arf = new AdminRolesForm();
        this.desktopPane.add(arf);
        arf.show();
    }//GEN-LAST:event_RolesMenuActionPerformed

    private void BranchesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BranchesMenuActionPerformed
        BranchesAdminFrom baf = new BranchesAdminFrom();
        this.desktopPane.add(baf);
        baf.show();
    }//GEN-LAST:event_BranchesMenuActionPerformed

    private void employeesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesMenuActionPerformed
        EmployeesAdminFrom eaf = new EmployeesAdminFrom();
        this.desktopPane.add(eaf);
        eaf.show();
    }//GEN-LAST:event_employeesMenuActionPerformed

    private void menu_CategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CategoriesActionPerformed
        CategoriesAdminFrom caf = new CategoriesAdminFrom();
        this.desktopPane.add(caf);
        caf.show();
    }//GEN-LAST:event_menu_CategoriesActionPerformed

    private void menu_ProvidersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ProvidersActionPerformed
       ProvidersAdminFrom paf=new ProvidersAdminFrom();
       this.desktopPane.add(paf);
       paf.show();
    }//GEN-LAST:event_menu_ProvidersActionPerformed

    private void menu_unitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_unitsActionPerformed
        MeasurementUnitAdminFrom muaf = new MeasurementUnitAdminFrom();
        this.desktopPane.add(muaf);
        muaf.show();
    }//GEN-LAST:event_menu_unitsActionPerformed

    private void menu_ProductsSubMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ProductsSubMenuActionPerformed
        ProductAdminFrom paf = new ProductAdminFrom();
        this.desktopPane.add(paf);
        paf.show();
    }//GEN-LAST:event_menu_ProductsSubMenuActionPerformed

    private void InMovementsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InMovementsMenuActionPerformed
        InMovementsForm imf = new InMovementsForm();
        this.desktopPane.add(imf);
        imf.show();
    }//GEN-LAST:event_InMovementsMenuActionPerformed

    private void OutMovementsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutMovementsMenuActionPerformed
        OutsMovementsForm omf=new OutsMovementsForm();
        this.desktopPane.add(omf);
        omf.show();
    }//GEN-LAST:event_OutMovementsMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceBusinessBlueSteelLookAndFeel());
                } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                }
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AdminMenu;
    private javax.swing.JMenuItem BranchesMenu;
    private javax.swing.JMenuItem InMovementsMenu;
    private javax.swing.JMenu MovementsMenu;
    private javax.swing.JMenuItem OutMovementsMenu;
    private javax.swing.JMenuItem RolesMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem employeesMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menu_Categories;
    private javax.swing.JMenu menu_Products;
    private javax.swing.JMenuItem menu_ProductsSubMenu;
    private javax.swing.JMenuItem menu_Providers;
    private javax.swing.JMenuItem menu_units;
    // End of variables declaration//GEN-END:variables

}
