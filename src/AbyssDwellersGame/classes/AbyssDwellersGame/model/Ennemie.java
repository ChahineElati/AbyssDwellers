/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.time.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author chahi
 */
public final class Ennemie extends Caractere implements Runnable {

    private boolean agressive;
    private Dweller dweller;
    private String[] moving = {"right", "left", "down", ""};

    public Ennemie(boolean agressive, String nom, boolean jouable, float posX, float posY, float width, float height, float rapidite, Image[] sprites, Dweller dweller) {
        super(nom, jouable, posX, posY, width, height, rapidite, sprites);
        this.agressive = agressive;
        this.dweller = dweller;
    }

    public boolean isAgressive() {
        return agressive;
    }

    public void setAgressive(boolean agressive) {
        this.agressive = agressive;
    }

    @Override
    public void run() {
        while (true) {
            if (this.detecterHitbox(dweller)) {

                try {
                    Thread.sleep(Duration.ofMillis(500));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println(dweller.getStatus().getSante());
            }
        }
    }
}
