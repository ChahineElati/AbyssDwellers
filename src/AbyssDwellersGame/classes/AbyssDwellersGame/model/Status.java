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
    
    private int dammage;
    private int defense;
    private int sante;
    private int santeMax;
    private int niveau;
    
    public Status(int dammage, int defense, int sante, int santeMax, int niveau) {
        this.dammage=dammage;
        this.defense=defense;
        this.sante=sante;
        this.santeMax=santeMax;
        this.niveau=niveau;
    }
    
    public int getDammage() {
        return dammage;
    }

    public int getDefense() {
        return defense;
    }

    public int getSante() {
        return sante;
    }

    public int getSanteMax() {
        return santeMax;
    }

    public int getNiveau() {
        return niveau;
    }
    
}
