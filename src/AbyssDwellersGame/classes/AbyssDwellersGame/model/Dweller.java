/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author chahi
 */
public final class Dweller extends Caractere {
    
      
    private int mana;
    private int manaMax;
    private ArrayList<Ability> abilities;

    public Dweller(int mana, int manaMax, String nom, boolean jouable, float posX, float posY, float width, float height, float rapidite, Image[] sprites) {
        super(nom, jouable, posX, posY, width, height, rapidite, sprites);
        this.mana = mana;
        this.manaMax = manaMax;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }
    
}
