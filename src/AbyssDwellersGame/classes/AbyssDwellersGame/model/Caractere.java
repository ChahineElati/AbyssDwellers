/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
    private Status status;
    private String moving;

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
        moving = "";
    }

    public String getNom() {
        return nom;
    }

    public String getFacing() {
        return facing;
    }

    public Status getStatus() {
        return status;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void ajouterControls(Scene scene, Rectangle healthBarFill, Group root) {
        scene.setOnKeyPressed((e) -> {
            if (e.getCode().toString().equals("DOWN")) {
                facing = "down";
                if (!detecterCollision()) {
                    moving = "down";
                    posY += rapidite;
                    image.setImage(sprites[0]);
                    image.setY(posY);
                } else {
                    posY -= 3 * rapidite;
                }
            }
            if (e.getCode().toString().equals("UP")) {
                facing = "up";
                if (!detecterCollision()) {
                    moving = "up";
                    posY -= rapidite;
                    image.setImage(sprites[1]);
                    image.setY(posY);
                } else {
                    posY += 3 * rapidite;
                }
            }
            if (e.getCode().toString().equals("RIGHT")) {
                facing = "right";
                if (!detecterCollision()) {
                    moving = "right";
                    posX += rapidite;
                    image.setImage(sprites[2]);
                    image.setX(posX);
                } else {
                    posX -= 3 * rapidite;
                }
            }
            if (e.getCode().toString().equals("LEFT")) {
                facing = "left";
                if (!detecterCollision()) {
                    moving = "left";
                    posX -= rapidite;
                    image.setImage(sprites[3]);
                    image.setX(posX);
                } else {
                    posX += 3 * rapidite;
                }
            }
            if (e.getCode().toString().equals("W")) {
                ImageView weapon = new ImageView("knife.png");
                if (facing.equals("up")) {
                    weapon.setFitWidth(35);
                    weapon.setFitHeight(35);
                    weapon.setX(posX - 3);
                    weapon.setY(posY - 35);
                    root.getChildren().add(weapon);
                }
                if (facing.equals("down")) {
                    weapon.setFitWidth(35);
                    weapon.setFitHeight(35);
                    weapon.setX(posX - 3);
                    weapon.setY(posY + height);
                    weapon.setImage(new Image("knife-down.png"));
                    root.getChildren().add(weapon);
                }
                if (facing.equals("left")) {
                    weapon.setFitWidth(35);
                    weapon.setFitHeight(35);
                    weapon.setX(posX - 30);
                    weapon.setY(posY + 10);
                    weapon.setImage(new Image("knife-left.png"));
                    root.getChildren().add(weapon);
                }
                if (facing.equals("right")) {
                    weapon.setFitWidth(35);
                    weapon.setFitHeight(35);
                    weapon.setX(posX + 26);
                    weapon.setY(posY + 10);
                    weapon.setImage(new Image("knife-right.png"));
                    root.getChildren().add(weapon);
                }

                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), ev -> {
                    root.getChildren().remove(weapon);
                }));
                timeline.play();
                for (GameObject go : collisions) {
                    if (detecterHitbox(go) && go instanceof Ennemie) {
                        Caractere c = (Caractere) go;
                        System.out.println(c.getNom() + " life points:");
                        attacker(c, root);
                    }
                }
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
            if (facing.equals("right") && moving.equals("right")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide left");
                }
            }
            if (facing.equals("down") && moving.equals("down")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide top");
                }
            }
            if (facing.equals("left") && moving.equals("left")) {
                if (posX + width >= collision.posX
                        && posY + height >= collision.posY
                        && posY <= collision.posY + height
                        && posX <= collision.posX + collision.width) {
                    collide = true;
                    System.out.println("collide right");
                }
            }
            if (facing.equals("up") && moving.equals("up")) {
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

    public boolean detecterHitbox(GameObject go) {
        float hitRange = 20.0f;
        if (posX + width + hitRange >= go.posX
                && posY + height + hitRange >= go.posY
                && posY <= go.posY + height + hitRange
                && posX <= go.posX + go.width + hitRange) {
            return true;
        } else {
            return false;
        }
    }

    public void attacker(Caractere caractere, Group root) {
        if (caractere.getStatus().getSante() > 0) {
            caractere.getImage().setBlendMode(BlendMode.RED);
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), ev -> {
                caractere.getImage().setBlendMode(null);
            }));
            timeline.play();
            float nouvelleSante = caractere.getStatus().getSante() - status.getDammage();
            if (nouvelleSante < 0) {
                caractere.getStatus().setSante(0);
                root.getChildren().remove(caractere.image);
                if (this instanceof Dweller) {
                    collisions.remove(caractere);
                }
            } else {
                caractere.getStatus().setSante(nouvelleSante);
            }
        }
    }
}
