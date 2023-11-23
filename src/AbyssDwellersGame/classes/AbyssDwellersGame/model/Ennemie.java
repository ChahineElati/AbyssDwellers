/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public final class Ennemie extends Caractere {
    
     private boolean agressive;

    public Ennemie(boolean agressive, String nom, boolean jouable, int posX, int posY, float rapidité) {
        super(nom, jouable, posX, posY, rapidité);
        this.agressive = agressive;
    }

    public boolean isAgressive() {
        return agressive;
    }

    public void setAgressive(boolean agressive) {
        this.agressive = agressive;
    }
    
    
}
