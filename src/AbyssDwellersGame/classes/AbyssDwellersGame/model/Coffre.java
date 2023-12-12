/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author chahi
 */
public final class Coffre extends ObjetInteractif {

    private int capacite;
    private boolean verrouille;
    private Key cle;
    private Image lockedc;
    private Image unlockedC;
    private ArrayList<Item> items;

    public Coffre(String nom, int posX, int posY, float width, float height, float rapidite, Image image, String message, int capacite, boolean verrouille, String keyId) {
        super(nom, posX, posY, width, height, rapidite, image, message);
        this.capacite = capacite;
        this.verrouille = verrouille;
        items = new ArrayList<>();
        items.add(
                new PotionSante("potion sante", "augmenter points sante", 2, 10, new Image("health-potion.png"))
                );
    }

    public void setLockedC(Image lockedC) {
        this.lockedc = lockedC;
        this.getImage().setImage(lockedC);
    }

    public void setUnlockedC(Image unlockedC) {
        this.unlockedC = unlockedC;
    }

    public void deverrouiller() {
        verrouille = false;
        this.getImage().setImage(unlockedC);
    }

    public boolean isVerrouille() {
        return verrouille;
    }

    public Key getCle() {
        return cle;
    }

    public int getCapacite() {
        return capacite;
    }

    public Image getLockedc() {
        return lockedc;
    }

    public Image getUnlockedC() {
        return unlockedC;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void ouvrirCoffre(Dweller dweller) {
        if (verrouille && dweller.hashKey()) {
            deverrouiller();
            System.out.println("Coffre is unlocked! ");
        } else {
            System.out.println("You don't have the key to unlock the chest.");
        }
    }

}
