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

    private int nombreItemsMax;
    private ArrayList<Item> items;

    public Inventaire() {
        items = new ArrayList<>();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    
    
}
