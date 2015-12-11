/*
 * ReportsConnection
 * Created on 10-12-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui.reports;

import com.mysql.jdbc.Connection;
import java.io.InputStream;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import net.sf.jasperreports.swing.JRViewer;



/**
 *
 * @author Arturo E. Salinas
 */
public class ReportsFormBase extends javax.swing.JInternalFrame {
    protected void GenerateReport(String name)
    {
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagerdb", "root", "admin");                        
            //JasperReport report = (JasperReport)JRLoader.loadObjectFromFile("src/main/resources/Reports/ProvidersReport.jasper");
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("Reports/ProvidersReport.jasper");
            JasperReport report = (JasperReport)JRLoader.loadObject(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, conexion);
            JFrame frame = new JFrame("Report");
            frame.getContentPane().add(new JRViewer(jasperPrint));
            frame.pack();
            frame.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportsFormBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportsFormBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ReportsFormBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
