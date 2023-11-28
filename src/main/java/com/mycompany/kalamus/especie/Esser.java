/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.especie;

/**
 *
 * @author admin
 */
public abstract class Esser {

    private String nom;
    private Integer Nivellcivilitzacio;

    public Esser(String Nom, Integer NivellCivilitzacio) {
        this.nom = Nom;
        this.Nivellcivilitzacio = NivellCivilitzacio;
    }

    public String getNom() {
        return nom;
    }

    public Integer getNivellCivilitzacio() {
        return Nivellcivilitzacio;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public void setNivellCivilitzacio(Integer NivellCivilitzacio) {
        this.Nivellcivilitzacio = NivellCivilitzacio;
    }

    
    
    
}
