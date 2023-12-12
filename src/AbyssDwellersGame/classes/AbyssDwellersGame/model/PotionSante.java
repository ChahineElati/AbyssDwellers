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
public final class PotionSante extends Item {

    private float effetSante;

    public PotionSante(String label, String description, int nombre, float effetSante, Image icon) {
        super(label, description, nombre, icon);
        this.effetSante = effetSante;
    }

    public float getEffetSante() {
        return effetSante;
    }

    @Override
    public void activerEffet(Status status) {
        status.setSante(status.getSante() + effetSante);
        if (status.getSante() > status.getSanteMax()) {
            status.setSante(status.getSanteMax());
        }
    }

}
