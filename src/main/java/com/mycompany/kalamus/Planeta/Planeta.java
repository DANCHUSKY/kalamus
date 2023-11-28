/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.Planeta;

import com.mycompany.kalamus.Galaxia.Galaxia;
import com.mycompany.kalamus.Planeta.ExcepPlanetas.ExcepcionPlaneta;
import com.mycompany.kalamus.especie.Esser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Planeta {

    private String Nom;
    private String Galaxia;
    private Integer Capacitat;
    private Clima TipoClima;
    HashMap<String, Esser> ListaEssers = new HashMap<>();

    private enum Clima {
        fred,
        calid,
        temperat,

    }
    private Boolean FloraVermella;
    private Boolean EssersAquatics;

    public Planeta(String Nom, String Galaxia, Integer Capacitat, String TipoClima, Boolean FloraVermella, Boolean EssersAquatics) throws ExcepcionPlaneta {
        this.Nom = Nom;
        this.Galaxia = Galaxia;
        this.Capacitat = Capacitat;
        try {
            Clima X = Clima.valueOf(TipoClima.toLowerCase());
            this.TipoClima = X;
        } catch (IllegalArgumentException e) {
            throw new ExcepcionPlaneta("El valor del tipo de clima no es válido: ");
        }
        this.FloraVermella = FloraVermella;
        this.EssersAquatics = EssersAquatics;
    }

    public String getNom() {
        return Nom;
    }

    public String getGalaxia() {
        return Galaxia;
    }

    public Integer getCapacitat() {
        return Capacitat;
    }

    public Clima getTipoClima() {
        return TipoClima;
    }

    public Boolean getFloraVermella() {
        return FloraVermella;
    }

    public Boolean getEssersAquatics() {
        return EssersAquatics;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setGalaxia(String Galaxia) {
        this.Galaxia = Galaxia;
    }

    public void setCapacitat(Integer Capacitat) {
        this.Capacitat = Capacitat;
    }

    public void setTipoClima(Clima TipoClima) {
        this.TipoClima = TipoClima;
    }

    public void setListaEssers(HashMap<String, Esser> ListaEssers) {
        this.ListaEssers = ListaEssers;
    }

    public void setFloraVermella(Boolean FloraVermella) {
        this.FloraVermella = FloraVermella;
    }

    public void setEssersAquatics(Boolean EssersAquatics) {
        this.EssersAquatics = EssersAquatics;
    }

    public HashMap<String, Esser> getListaEssers() {

        return ListaEssers;
    }

    public HashMap<String, Esser> getListaPlanetas() {

        return ListaEssers;
    }


    public void addEsser(Esser esser) {
        if (ListaEssers.containsKey(esser.getNom())) {

            System.out.println("El Esser ya existe en el HashMap. No se agregó ninguno.");
        } else {

            ListaEssers.put(esser.getNom(), esser);

        }
    }

    public void ContentEsser() {
        for (HashMap.Entry<String, Esser> entry : ListaEssers.entrySet()) {
            String nombre = entry.getKey();
            Esser contentEsser = entry.getValue();
            System.out.println("Nombre: " + nombre);
            System.out.println(contentEsser.getNom());

        }
    }

}
