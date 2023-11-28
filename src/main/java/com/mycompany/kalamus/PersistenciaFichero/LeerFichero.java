package com.mycompany.kalamus.PersistenciaFichero;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.kalamus.Planeta.Planeta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class LeerFichero {

    private String NombreFichero;

    public LeerFichero(String Id) {
        this.NombreFichero = Id;
    }

    public String getId() {
        return NombreFichero;
    }

    public ArrayList<String> readContent() {
        ArrayList<String> lista = new ArrayList<String>();
        File archivo = new File(NombreFichero);
        try {
            if (!archivo.exists()) {

                CreateFile();
                System.out.println("Archivo creado exitosamente.");
            } else {

                Scanner scanner = new Scanner(archivo);

                while (scanner.hasNextLine()) {
                    lista.add(scanner.nextLine());

                }

                scanner.close();

            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: ");
        }
        return lista;
    }

    public void addContent(String x) {
        Boolean existe = true;
        while (existe) {
            try (FileWriter escribe = new FileWriter(NombreFichero, true)) {
                escribe.write(x + "\n");
                escribe.close();
                existe = false;

            } catch (IOException ex) {
                try {
                    CreateFile();
                } catch (IOException ex2) {
                    System.out.println("");
                }

            }
        }
    }

    //creo un metodo que crea un fichero
    public void CreateFile() throws IOException {
        File archivoTexto = new File(NombreFichero);
        FileWriter escribe = new FileWriter(archivoTexto);
        escribe.close();
    }

    public static String leerValorXDesdeArchivo(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            String[] values = line.split(" "); // Si los valores están separados por comas

            if (values.length > 0) {
                return values[0];
               
            } else {
                System.out.println("El archivo no contiene suficientes valores.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
