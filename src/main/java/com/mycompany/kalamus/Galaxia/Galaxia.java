/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.Galaxia;

import com.mycompany.kalamus.Planeta.Planeta;
import com.mycompany.kalamus.especie.Esser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author daniel
 */
public class Galaxia {

    HashMap<String, Planeta> ListaPlanetas = new HashMap<>();

    public HashMap<String, Planeta> getListaPlanetas() {
        
        return ListaPlanetas;
    }

    public HashMap<String, Planeta> getListaPlanetasHash() {

        return ListaPlanetas;
    }

    public void setListaPlanetas(HashMap<String, Planeta> ListaPlanetas) {
        this.ListaPlanetas = ListaPlanetas;
    }

    public void addPlaneta(Planeta planeta) {
        if (ListaPlanetas.containsKey(planeta.getNom())) {

            System.out.println("El planeta ya existe en el HashMap. No se agregó ninguno.");
        } else {

            ListaPlanetas.put(planeta.getNom(), planeta);

            for (HashMap.Entry<String, Planeta> entry : ListaPlanetas.entrySet()) {
                String nombre = entry.getKey();
                Planeta contentPlaneta = entry.getValue();
                System.out.println("Nombre: " + nombre);

            }
        }
    }

    public Planeta obtenerPlaneta(String nombrePlaneta) {

        return ListaPlanetas.get(nombrePlaneta);
    }

    public void ContentPlanets() {
        for (HashMap.Entry<String, Planeta> entry : ListaPlanetas.entrySet()) {
            String nombre = entry.getKey();
            Planeta contentPlaneta = entry.getValue();
            System.out.println("Nombre: " + nombre);
            System.out.println(contentPlaneta.getNom());
            System.out.println(contentPlaneta.getGalaxia());
            System.out.println(contentPlaneta.getCapacitat());
            System.out.println(contentPlaneta.getTipoClima());
            System.out.println(contentPlaneta.getEssersAquatics());
            System.out.println(contentPlaneta.getFloraVermella());

        }
    }
}
