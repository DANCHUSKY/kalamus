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
public class Klingon extends Esser {
    protected int Forca;

    public Klingon(String Nom, int Forca) {
        super(Nom, 3);
        this.Forca = Forca;
    }

    public int getForca() {
        return Forca;
    }

    public void setForca(int Forca) {
        this.Forca = Forca;
    }
    
    
}
