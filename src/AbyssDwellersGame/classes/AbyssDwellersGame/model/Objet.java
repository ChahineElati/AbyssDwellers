/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public  sealed abstract class Objet extends GameObject permits ObjetStatique, ObjetInteractif {
    
    private String nom;

    
    public Objet(String nom, int posX, int posY, float width, float height, float rapidite) {
        super(posX, posY, width, height, rapidite);
        this.nom= nom;

    }
    
    public String getNom() {
        return nom;
    }
}
