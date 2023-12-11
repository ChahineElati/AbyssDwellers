package AbyssDwellersGame.model;

import AbyssDwellersGame.exceptions.ValeurInacceptableException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author chahi
 */
public class Status {

    private float dammage;
    private float defense;
    private float sante;
    private float santeMax;
    private float mana;
    private float maxMana;
    private int niveau;

    public Status(int dammage, int defense, int sante, int santeMax, int niveau) throws ValeurInacceptableException {
        if(sante<=0 || sante>santeMax) {
            throw new ValeurInacceptableException();
        }
        this.dammage = dammage;
        this.defense = defense;
        this.sante = sante;
        this.santeMax = santeMax;
        this.niveau = niveau;
        
    }

    public float getDammage() {
        return dammage;
    }

    public float getDefense() {
        return defense;
    }

    public float getSante() {
        return sante;
    }

    public float getSanteMax() {
        return santeMax;
    }

    public int getNiveau() {
        return niveau;
    }

    
    
    public void setDammage(float dammage) {
        this.dammage = dammage;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setSante(float sante) {
        this.sante = sante;
    }

    public void setSanteMax(float santeMax) {
        this.santeMax = santeMax;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

}
