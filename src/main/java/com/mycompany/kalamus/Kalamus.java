/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.kalamus;

import com.mycompany.kalamus.InterfazGrafica.Menu;
import com.mycompany.kalamus.PersistenciaFichero.LeerFichero;
import com.mycompany.kalamus.Planeta.ExcepPlanetas.ExcepcionPlaneta;
import com.mycompany.kalamus.especie.excepcionesEssers.EsserNotValid;
import com.mycompany.kalamus.especie.excepcionesEssers.ExcepcionesEssers;
import com.mycompany.kalamus.persistenciaBaseDatos.dao;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class Kalamus {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExcepcionPlaneta, ExcepcionesEssers, EsserNotValid {

        /*
        
        // Ruta del archivo .properties
        String filePath = "/kalamus/target/classes/properties.txt";

        // Cargar el archivo .properties
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        String saveOption = properties.getProperty("save.options");

        
        if ("file".equals(saveOption)) {
            
            LeerFichero a = new LeerFichero(filePath);
            
        } else if ("bbdd".equals(saveOption)) {
            
            dao bbdd = new dao();
            bbdd.conectar();
            System.out.println("Conectado a la BBDD");
        }
         */
        if (args.length == 1 && args[0].equalsIgnoreCase("kalamus")) {
            Menu m = new Menu();
            m.setVisible(true);
            
        } else {

            (new Vista()).run(args);

        }
    }

}
