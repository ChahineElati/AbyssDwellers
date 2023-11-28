/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public abstract sealed class GameObject permits Caractere, Objet{
    
    protected float posX;
    protected float posY;
    protected float width;
    protected float height;
    protected float rapidite;
    

    public GameObject(float posX, float posY, float width, float height, float rapidite) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.rapidite = rapidite;
    }

    
    
    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRapidite() {
        return rapidite;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setRapidite(float rapidite) {
        this.rapidite = rapidite;
    }
    
}
