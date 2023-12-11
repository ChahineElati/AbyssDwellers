/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.Objects;
import javafx.scene.image.Image;

/**
 *
 * @author rayen
 */
public final class Key extends ObjetInteractif {

    private String keyId;
    private float posX;
    private float posY;

    public Key(String nom, int posX, int posY, float width, float height, float rapidite, Image image, String message, String keyId) {
        super(nom, posX, posY, width, height, rapidite, image, message);
        this.keyId = keyId;
    }

    public void setPosition(float x, float y) {
        this.posX = x;
        this.posY = y;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Key key = (Key) obj;
        return keyId.equals(key.keyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId);
    }

}
