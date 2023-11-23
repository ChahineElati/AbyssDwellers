/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public  sealed abstract class Objet permits ObjetStatique, ObjetInteractif {
    
    private String nom;
    private int  posX;
    private int posY;
    
    public Objet(String nom, int posX, int posY) {
        this.nom= nom;
        this.posX= posX;
        this.posY= posY;
    }
    
    public String getNom() {
        return nom;
    }
     
    public int getPosX() {
        return posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
}
