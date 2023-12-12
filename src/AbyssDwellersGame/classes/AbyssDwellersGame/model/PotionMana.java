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
public final class PotionMana extends Item {

    private float effetMana;

    public PotionMana(String label, String description, int nombre, int effetMana, Image icon) {
        super(label, description, nombre, icon);
        this.effetMana = effetMana;
    }

    public float getEffetMana() {
        return effetMana;
    }

    @Override
    public void activerEffet(Status status) {
        status.setSante(status.getSante() + effetMana);
        if (status.getSante() > status.getSanteMax()) {
            status.setSante(status.getSanteMax());
        }
    }

}
