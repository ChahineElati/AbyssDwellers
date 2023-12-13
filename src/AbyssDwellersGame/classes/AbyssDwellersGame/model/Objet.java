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
public  sealed abstract class Objet extends GameObject permits ObjetStatique, ObjetInteractif {
    
    private String nom;
    private ImageView image;

    
    public Objet(String nom, int posX, int posY, float width, float height, float rapidite, Image image) {
        super(posX, posY, width, height, rapidite);
        this.nom= nom;
        this.image = new ImageView();
        this.image.setImage(image);
        this.image.setX(posX);
        this.image.setY(posY);
        this.image.setFitWidth(width);
        this.image.setFitHeight(height);
    }
    
    public String getNom() {
        return nom;
    }

    public ImageView getImage() {
        return image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
    
}
