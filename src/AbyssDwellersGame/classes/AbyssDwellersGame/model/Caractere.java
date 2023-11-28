/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author chahi
 */
public sealed abstract class Caractere extends GameObject permits Dweller, Ennemie {

    private String nom;
    private boolean jouable;

    private boolean enCombat;
    private ArrayList<GameObject> collisions;
    private Inventaire inventaire;
    private ImageView image;
    private Image[] sprites;
    private String facing = "down";

    public Inventaire getInventaire() {
        return inventaire;
    }

    public ImageView getImage() {
        return image;
    }

    public Image[] getSprites() {
        return sprites;
    }

    public Caractere(String nom, boolean jouable, float posX, float posY, float width, float height, float rapidite, Image[] sprites) {
        super(posX, posY, width, height, rapidite);
        this.nom = nom;
        this.jouable = jouable;
        enCombat = false;
        image = new ImageView();
        image.setImage(sprites[0]);
        image.setX(posX);
        image.setY(posY);
        this.sprites = sprites;
        collisions = new ArrayList<>();

    }

    public String getNom() {
        return nom;
    }

    public boolean isJouable() {
        return jouable;
    }

    public ArrayList<GameObject> getCollisions() {
        return collisions;
    }

    public boolean isEnCombat() {
        return enCombat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEnCombat(boolean enCombat) {
        this.enCombat = enCombat;
    }

    public void ajouterControls(Scene scene) {
        scene.setOnKeyPressed((e) -> {
            if (e.getCode().toString().equals("DOWN")) {
                facing = "down";
                if (!detecterCollision()) {
                    posY += rapidite;
                    image.setImage(sprites[0]);
                    image.setY(posY);
                } else {
                    posY -= 3 * rapidite;
                }
                System.out.println(facing);
            }
            if (e.getCode().toString().equals("UP")) {
                facing = "up";
                if (!detecterCollision()) {
                    posY -= rapidite;
                    image.setImage(sprites[1]);
                    image.setY(posY);
                } else {
                    posY += 3 * rapidite;
                }
                System.out.println(facing);
            }
            if (e.getCode().toString().equals("RIGHT")) {
                facing = "right";
                if (!detecterCollision()) {
                    posX += rapidite;
                    image.setImage(sprites[2]);
                    image.setX(posX);
                } else {
                    posX -= 3 * rapidite;
                }
                System.out.println(facing);
            }
            if (e.getCode().toString().equals("LEFT")) {
                facing = "left";
                if (!detecterCollision()) {
                    posX -= rapidite;
                    image.setImage(sprites[3]);
                    image.setX(posX);
                } else {
                    posX += 3 * rapidite;
                }
                System.out.println(facing);
            }
        }
        );
    }

    public void ajouterCollision(GameObject caractere) {
        collisions.add(caractere);
    }

    public boolean detecterCollision() {
        boolean collide = false;
        for (GameObject collision : collisions) {

            if (facing.equals("right")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide left");
                }
            }
            if (facing.equals("down")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide top");
                }
            }
            if (facing.equals("left")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide right");
                }
            }
            if (facing.equals("up")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide down");
                }
            }
        }

        return collide;
    }

    public void detecterHitbox() {
        for (GameObject go : collisions) {
            if (go instanceof Caractere) {
                Caractere c = (Caractere) go;
                System.out.println(c.nom);
            }
        }
    }

}
