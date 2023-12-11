/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public final class PotionMana extends Item {

    private float effetMana;
    public static int nombre;

    public PotionMana(String label, String description, int effetMana) {
        super(label, description);
        this.effetMana = effetMana;
    }

    public float getEffetMana() {
        return effetMana;
    }

    public static int getNombre() {
        return nombre;
    }

    @Override
    public void activerEffet(Status status) {
        status.setSante(status.getSante() + effetMana);
        if (status.getSante() > status.getSanteMax()) {
            status.setSante(status.getSanteMax());
        }
    }

}
