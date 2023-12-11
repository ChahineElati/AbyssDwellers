/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public final class PotionSante extends Item {

    private float effetSante;
    public static int nombre;

    public PotionSante(String label, String description, float effetSante) {
        super(label, description);
        this.effetSante = effetSante;
    }

    public float getEffetSante() {
        return effetSante;
    }

    public static int getNombre() {
        return nombre;
    }

    @Override
    public void activerEffet(Status status) {
        status.setSante(status.getSante() + effetSante);
        if (status.getSante() > status.getSanteMax()) {
            status.setSante(status.getSanteMax());
        }
    }

}
