/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.especie.subEspecies;

import com.mycompany.kalamus.Planeta.ExcepPlanetas.ExcepcionPlaneta;
import com.mycompany.kalamus.Planeta.Planeta;
import com.mycompany.kalamus.especie.Esser;
import com.mycompany.kalamus.especie.excepcionesEssers.ExcepcionesEssers;

/**
 *
 * @author admin
 */
public class Andorians extends Esser {
    protected rol TipoRol;
    protected enum rol {
        entrenador, 
        defensor, 
        lluitador ,
        cavaller,

    }

    public Andorians(String nom, String TipoRol) throws ExcepcionesEssers {
        super(nom, 2);
        try {
            rol X = rol.valueOf(TipoRol.toLowerCase());
            this.TipoRol = X;
        } catch (IllegalArgumentException e) {
            throw new ExcepcionesEssers("El valor del tipo ROL no es válido: ");
        }
        
        
        
    }

    public rol getTipoRol() {
        return TipoRol;
    }

    public void setTipoRol(rol TipoRol) {
        this.TipoRol = TipoRol;
    }
    
}
