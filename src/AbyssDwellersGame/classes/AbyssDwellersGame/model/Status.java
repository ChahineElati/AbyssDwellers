package AbyssDwellersGame.model;

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
    private int niveau;
    
    public Status(int dammage, int defense, int sante, int santeMax, int niveau) {
        this.dammage=dammage;
        this.defense=defense;
        this.sante=sante;
        this.santeMax=santeMax;
        this.niveau=niveau;
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
