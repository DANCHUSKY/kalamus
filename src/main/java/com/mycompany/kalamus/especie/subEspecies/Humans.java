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
public class Humans extends Esser {
    protected Integer edat;
    protected Boolean genere;

    public Humans(String Nom,Integer Edat, Boolean Genere) {
        super(Nom,2);
        this.edat = Edat;
        this.genere = Genere;
    }

    public Integer getEdat() {
        return edat;
    }

    public Boolean getGenere() {
        return genere;
    }

    public void setEdat(Integer Edat) {
        this.edat = Edat;
    }

    public void setGenere(Boolean Genere) {
        this.genere = Genere;
    }
    

}