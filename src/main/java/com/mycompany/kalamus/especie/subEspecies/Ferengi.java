/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.especie.subEspecies;

import com.mycompany.kalamus.especie.Esser;

/**
 *
 * @author daniel
 */
public class Ferengi extends Esser{
    protected int oro;

    public Ferengi(String Nom, int oro) {
        super(Nom, 1);
        this.oro = oro;
    }

    public int getOr() {
        return oro;
    }

    public void setOr(int oro) {
        this.oro = oro;
    }
    
    
}
