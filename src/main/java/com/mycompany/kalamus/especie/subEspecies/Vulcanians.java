/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.especie.subEspecies;

import com.mycompany.kalamus.especie.Esser;

/**
 *
 * @author admin
 */
public class Vulcanians extends Esser {
    protected Integer Meditacio;

    public Vulcanians(String Nom,Integer Meditacio) {
        super(Nom, 3);
        this.Meditacio = Meditacio;
    }

    public Integer getMeditacio() {
        return Meditacio;
    }

    public void setMeditacio(Integer Meditacio) {
        this.Meditacio = Meditacio;
    }
    
}
