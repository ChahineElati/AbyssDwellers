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
public final class Dweller extends Caractere {
    
      
    private int mana;
    private int manaMax;
    private ArrayList<Ability> abilities;

    public Dweller(int mana, int manaMax, String nom, boolean jouable, int posX, int posY, float rapidité) {
        super(nom, jouable, posX, posY, rapidité);
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
