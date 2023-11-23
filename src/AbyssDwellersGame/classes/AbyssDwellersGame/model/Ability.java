/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;


import AbyssDwellersGame.service.Switchable;

/**
 *
 * @author chahi
 */
public class Ability implements Switchable {
     private String nom;
    private int dammage;
    private int coutMana;
    private String description;

    public Ability(String nom, int dammage, int coutMana, String description) {
        this.nom = nom;
        this.dammage = dammage;
        this.coutMana = coutMana;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public int getDammage() {
        return dammage;
    }

    public int getCoutMana() {
        return coutMana;
    }

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDammage(int dammage) {
        this.dammage = dammage;
    }

    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void change(int pos) {
        
    }
}
