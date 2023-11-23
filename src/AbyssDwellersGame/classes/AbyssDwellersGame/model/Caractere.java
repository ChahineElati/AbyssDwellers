/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public sealed abstract class Caractere permits Dweller, Ennemie {
    private String nom;
    private boolean jouable;
    private int posX;
    private int posY;
    private float rapidité;
    private boolean enCombat;
    private Inventaire inventaire;

    public Caractere(String nom, boolean jouable, int posX, int posY, float rapidité) {
        
        this.nom = nom;
        this.jouable = jouable;
        this.posX = posX;
        this.posY = posY;
        this.rapidité = rapidité;
        enCombat = false;
    }

    public String getNom() {
        return nom;
    }

    public boolean isJouable() {
        return jouable;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public float getRapidité() {
        return rapidité;
    }

    public boolean isEnCombat() {
        return enCombat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setRapidité(float rapidité) {
        this.rapidité = rapidité;
    }

    public void setEnCombat(boolean enCombat) {
        this.enCombat = enCombat;
    }
    
    
}
