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
public sealed class ObjetInteractif extends Objet permits Coffre, Key {

    private String message;
    private ImageView indicator;

    public ObjetInteractif(String nom, int posX, int posY, float width, float height, float rapidite, Image image, String message) {
        super(nom, posX, posY, width, height, rapidite, image);
        this.message = message;
        indicator = new ImageView("message.png");
        indicator.setX(posX);
        indicator.setY(posY - 22);
    }

    public String getMessage() {
        return message;
    }

    public ImageView getIndicator() {
        return indicator;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIndicator(ImageView indicator) {
        this.indicator = indicator;
    }

}
