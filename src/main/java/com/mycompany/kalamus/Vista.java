/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus;

import com.mycompany.kalamus.Galaxia.Galaxia;
import com.mycompany.kalamus.PersistenciaFichero.LeerFichero;
import static com.mycompany.kalamus.PersistenciaFichero.LeerFichero.leerValorXDesdeArchivo;
import com.mycompany.kalamus.Planeta.ExcepPlanetas.ExcepcionPlaneta;
import com.mycompany.kalamus.Planeta.Planeta;
import com.mycompany.kalamus.especie.Esser;
import com.mycompany.kalamus.especie.excepcionesEssers.EsserNotValid;
import com.mycompany.kalamus.especie.excepcionesEssers.ExcepcionesEssers;

import com.mycompany.kalamus.especie.subEspecies.Andorians;
import com.mycompany.kalamus.especie.subEspecies.Ferengi;
import com.mycompany.kalamus.especie.subEspecies.Humans;
import com.mycompany.kalamus.especie.subEspecies.Klingon;
import com.mycompany.kalamus.especie.subEspecies.Nibirians;
import com.mycompany.kalamus.especie.subEspecies.Vulcanians;
import com.mycompany.kalamus.persistenciaBaseDatos.dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class Vista {

    //hago una instancia de la clase galaxia
    Galaxia galaxia = new Galaxia();
    String LeerFichero = "planets.csv";
    String LeerFicheros = "beings.csv";
    LeerFichero FicheroNuevo = new LeerFichero(LeerFichero);
    LeerFichero FicheroNuevos = new LeerFichero(LeerFicheros);

    public void run(String[] args) throws ClassNotFoundException, SQLException, ExcepcionPlaneta, ExcepcionesEssers, EsserNotValid {

        if (args.length > 1 && args[0].equalsIgnoreCase("kalamus")) {

            switch (args[1].toLowerCase()) {
                case "planet":

                    if (args[2].toLowerCase().equals("add")) {
                        if (args.length == 9) {

                            int intCapacitat = Integer.parseInt(args[5]);

                            try {

                                Planeta objetoPlaneta = new Planeta(args[3], args[4], intCapacitat, args[6], true, true);

                                //llamo al metodo addplaneta en la clase galaxia
                                galaxia.addPlaneta(objetoPlaneta);

                                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                //metodo BBDD
                                dao bbdd = new dao();
                                bbdd.conectar();
                                System.out.println("Conectado a la BBDD");

                                bbdd.insertPlaneta(galaxia.getListaPlanetas());
                                //desconecta
                                bbdd.desconectar();
                                System.out.println("Conexion con la BBDD cerrada");

                                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                //metodo FICHEROS
                                LeerFichero FicheroNuevo = new LeerFichero(LeerFichero);

                                HashMap<String, Planeta> content = galaxia.getListaPlanetasHash();
                                for (String x : content.keySet()) {

                                    FicheroNuevo.addContent(x);

                                }

                            } catch (SQLException | ClassNotFoundException  ex) {
                                System.out.println(ex.getMessage());

                            } catch (ExcepcionPlaneta ex) {
                                System.out.println(ex.getMessage());
                            }
                        } else {
                            System.out.println("Numero de parámetros incorrecto");
                        }

                    } else if (args[2].toLowerCase().equals("list")) {
                        if (args.length == 3) {

                            dao bbdd = new dao();
                            bbdd.conectar();
                            System.out.println("Conectado a la BBDD");

                            System.out.println(bbdd.selectAllPlaneta(galaxia.getListaPlanetas()));
                            //desconecta
                            bbdd.desconectar();
                            System.out.println("Conexion con la BBDD cerrada");

                            //////////////////////////////////////////////////////////////////////////////////////////////////////
                            //metodo FICHEROS
                            System.out.println("");
                            System.out.println("Listado Planetas por fichero:");
                            FicheroNuevo.readContent();

                            //meto el contenido del fichero en un arraylist
                            ArrayList<String> contenido = FicheroNuevo.readContent();
                            System.out.println(contenido);
                        } else {
                            System.out.println("Numero de parametros incorrecto");
                        }

                    } else {
                        System.out.println("comando incorrecto");
                    }
                    break;

                case "being":

                    if (args[2].toLowerCase().equals("add")) {

                        try {

                            createEsser(args);
                            //metodo FICHEROS

                        } catch (ArithmeticException | EsserNotValid e) {
                            System.out.println("Error: formato incorrecto");
                        }

                    } else if (args[2].toLowerCase().equals("list")) {

                        dao bbdd = new dao();
                        bbdd.conectar();
                        System.out.println("");
                        System.out.println("Conectado a la BBDD");
                        bbdd.selectAllPlaneta(galaxia.getListaPlanetasHash());
                        System.out.println(bbdd.selectAllPlaneta(galaxia.getListaPlanetas()));
                        //desconecta
                        bbdd.desconectar();
                        System.out.println("Conexion con la BBDD cerrada");

                        //metodo FICHEROS
                        System.out.println("");
                        System.out.println("Listado Planetas por fichero:");
                        FicheroNuevos.readContent();

                        //meto el contenido del fichero en un arraylist
                        ArrayList<String> contenido = FicheroNuevos.readContent();
                        System.out.println(contenido);

                    } else {
                        System.out.println("comando incorrecto");
                    }
                    break;

                default:
                    // Mensaje de error si se introduce un comando desconocido
                    System.out.println("ERROR:  Comando desconocido. Introduce un comando válido.");
                    break;

            }
        }

    }

    //Metodo el cual crea un planeta
    public Planeta creaPlaneta(String Nom, String Galaxia, Integer Capacitat, String TipoClima, boolean FloraVermella, boolean EssersAquatics) {
        // Método que crea un objeto "Persona" utilizando los argumentos recibidos
        //nom-galaxia-capacitat-clima-floravermella-aquatics5

        Planeta objetoplaneta = null;
        try {
            objetoplaneta = new Planeta(Nom, Galaxia, Capacitat, TipoClima, FloraVermella, EssersAquatics);
        } catch (ExcepcionPlaneta exa) {
            System.out.println(exa.getMessage());

        }

        return objetoplaneta;
    }

    //Metodo el cual crea un Esser
    public void createEsser(String[] argumentos) throws SQLException, ClassNotFoundException, ExcepcionesEssers, EsserNotValid {
        dao bbdd = new dao();
        bbdd.conectar();
        System.out.println("Conectado a la BBDD");
        LeerFichero FicheroNuevo = new LeerFichero(LeerFicheros);
        switch (argumentos[4].toLowerCase()) {
            case "huma":
                if (argumentos.length == 8) {
                    int intEdat = Integer.parseInt(argumentos[6]);
                    if (intEdat < 130 || intEdat > 0) {

                        Boolean BoolGenero = Boolean.parseBoolean(argumentos[7]);
                        Humans objetoHuma = new Humans(argumentos[3], intEdat, BoolGenero);

                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        //metodo BBDD
                        bbdd.insertEsser(objetoHuma);
                        bbdd.insertSubEsser(objetoHuma);
                        //metodo FICHEROS

                        FicheroNuevo.addContent(objetoHuma.getNom());

                    } else {
                        System.out.println("Edad incorrecta");
                    }
                } else {
                    System.out.println("numero de parametros incorrecto");
                }
                break;

            case "vulcania":
                if (argumentos.length == 7) {
                    int intMeditacio = Integer.parseInt(argumentos[5]);
                    if (intMeditacio < 10 || intMeditacio > 0) {

                        Vulcanians objetoVulcania = new Vulcanians(argumentos[3], intMeditacio);
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        //metodo BBDD

                        bbdd.insertEsser(objetoVulcania);
                        bbdd.insertSubEsser(objetoVulcania);
                        //metodo FICHEROS

                        FicheroNuevo.addContent(objetoVulcania.getNom());
                    } else {
                        System.out.println("Nivel de meditacion incorrecto");
                    }
                } else {
                    System.out.println("Numero de parametros incorrecto");
                }
                break;
            case "andoria":
                if (argumentos.length == 7) {

                    Andorians objetoAndoria = new Andorians(argumentos[3], argumentos[6]);

                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //metodo BBDD
                    bbdd.insertEsser(objetoAndoria);
                    bbdd.insertSubEsser(objetoAndoria);
                    //metodo FICHEROS
                    FicheroNuevo.addContent(objetoAndoria.getNom());
                } else {
                    System.out.println("Numero de parametros incorrecto");
                }
                break;

            case "nibiria":
                if (argumentos.length == 6) {
                    System.out.println(argumentos.length);
                    Nibirians objetoNibiria = new Nibirians(argumentos[3]);
                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //metodo BBDD
                    bbdd.insertEsser(objetoNibiria);
                    bbdd.insertSubEsser(objetoNibiria);
                    //metodo FICHEROS
                    FicheroNuevo.addContent(objetoNibiria.getNom());
                } else {
                    System.out.println("Numero de parametros incorrecto");
                }

                break;

            case "klingon":
                if (argumentos.length == 7) {
                    System.out.println(argumentos.length);
                    int intForca = Integer.parseInt(argumentos[6]);
                    Klingon objetoKlingon = new Klingon(argumentos[3], intForca);
                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //metodo BBDD
                    bbdd.insertEsser(objetoKlingon);
                    bbdd.insertSubEsser(objetoKlingon);
                    //metodo FICHEROS
                    FicheroNuevo.addContent(objetoKlingon.getNom());
                } else {
                    System.out.println("Numero de parametros incorrecto");
                }
                break;

            case "ferengi":
                if (argumentos.length == 7) {
                    System.out.println(argumentos.length);
                    int intOr = Integer.parseInt(argumentos[6]);
                    Ferengi objetoFarengi = new Ferengi(argumentos[3], intOr);
                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //metodo BBDD
                    bbdd.insertEsser(objetoFarengi);
                    bbdd.insertSubEsser(objetoFarengi);
                    //metodo FICHEROS
                    FicheroNuevo.addContent(objetoFarengi.getNom());
                } else {
                    System.out.println("Numero de parametros incorrecto");
                }
                break;
            default:
                throw new EsserNotValid(argumentos[4]);

               
        }
        //desconecta
        bbdd.desconectar();
        System.out.println("Conexion con la BBDD cerrada");
    }

}
