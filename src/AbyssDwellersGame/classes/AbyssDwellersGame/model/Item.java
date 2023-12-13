/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import javafx.scene.image.Image;

/**
 *
 * @author chahi
 */
public sealed abstract class Item permits PotionSante, PotionMana {

    private String label;
    private String description;
    private int nombre;
    private  Image icon;

    public Item(String label, String description, int nombre, Image icon) {
        this.label = label;
        this.description = description;
        this.nombre = nombre;
        this.icon = icon;

    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public int getNombre() {
        return nombre;
    }

    public Image getIcon() {
        return icon;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }
    

    abstract public void activerEffet(Status status);

}
