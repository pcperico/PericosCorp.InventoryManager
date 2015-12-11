/*
 * Test
 * Created on 10-12-2015
 * Copyright(c) 2015 PericosCorp Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of PericosCorp Company.
 */
package pericoscorp.inventorymanager.desktop.gui;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.TextFlow;
import pericoscorp.inventorymanager.desktop.gui.reports.ReportsFormBase;

/**
 *
 * @author Arturo E. Salinas
 */
public class Test {
    public static void main(String args[])
    {
        ClassLoader classLoader = Test.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("Reports/ProvidersReport.jasper");

        if(inputStream == null)
        {
           System.out.println("not found");
        }
        else
            System.out.println("found!!!");
    }
}
