/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.especie.excepcionesEssers;

/**
 *
 * @author daniel
 */
public class EsserNotValid extends Exception{
    public EsserNotValid(String message){
        super(message +" no es un Esser Válido");
    }
}