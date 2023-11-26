/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author chahi
 */
public final class Ennemie extends Caractere {
    
     private boolean agressive;

    public Ennemie(boolean agressive, String nom, boolean jouable, float posX, float posY, float width, float height, float rapidite, Image[] sprites) {
        super(nom, jouable, posX, posY, width, height, rapidite, sprites);
        this.agressive = agressive;
    }

    public boolean isAgressive() {
        return agressive;
    }

    public void setAgressive(boolean agressive) {
        this.agressive = agressive;
    }
    
    
}
