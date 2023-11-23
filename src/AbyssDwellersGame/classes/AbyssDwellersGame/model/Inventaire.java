/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.ArrayList;

/**
 *
 * @author chahi
 */
public class Inventaire {
    
    private ArrayList<Item> items;
    private int nombreItemsMax;

    public Inventaire(int nombreItemsMax) {
        this.nombreItemsMax = nombreItemsMax;
    }

    public int getNombreItemsMax() {
        return nombreItemsMax;
    }

    public void setNombreItemsMax(int nombreItemsMax) {
        this.nombreItemsMax = nombreItemsMax;
    }
    
}
