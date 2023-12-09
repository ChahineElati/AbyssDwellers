/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame;

import AbyssDwellersGame.model.Coffre;
import AbyssDwellersGame.model.Dweller;
import AbyssDwellersGame.model.Ennemie;
import AbyssDwellersGame.model.Objet;
import AbyssDwellersGame.model.ObjetStatique;
import AbyssDwellersGame.model.Status;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author chahi
 */
public class Game extends Application {

    @Override
    public void start(Stage stage) throws InterruptedException {

        //dessiner l'environnement
        final int tilesize = 45;
        final int windowWidth = 15;
        final int windowHeight = 12;
        ImageView[][] imgList = new ImageView[windowHeight][windowWidth];
        ObjetStatique wallLeftTop = new ObjetStatique("wall-left-top", 0, 0, 22, 65, 0, new Image("/wall-left-top.png"), "wall left top");
        ArrayList<ObjetStatique> walls = new ArrayList<>();
        ArrayList<Objet> wallsLeftMiddle = new ArrayList<>();
        wallsLeftMiddle.add(new ObjetStatique("wall-right-top", windowWidth * tilesize - 22, 0, 22, 64, 0, new Image("wall-right-top.png"), "wall right top"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 2, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 3, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 4, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 5, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 6, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 7, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-middle", windowWidth * tilesize - 22, 64 + 48 * 8, 22, 48, 0, new Image("wall-right-middle.png"), "wall right middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-bottom", 0, windowHeight * tilesize - 47, 192, 47, 0, new Image("wall-bottom.png"), "wall bottom"));
        wallsLeftMiddle.add(new ObjetStatique("wall-bottom", 192, windowHeight * tilesize - 47, 192, 47, 0, new Image("wall-bottom.png"), "wall bottom"));
        wallsLeftMiddle.add(new ObjetStatique("wall-bottom", 192 * 2, windowHeight * tilesize - 47, 192, 47, 0, new Image("wall-bottom.png"), "wall bottom"));
        wallsLeftMiddle.add(new ObjetStatique("wall-bottom", 192 * 3, windowHeight * tilesize - 47, 192, 47, 0, new Image("wall-bottom.png"), "wall bottom"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 2, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 3, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 4, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 5, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 6, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 7, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-middle", 0, 65 + 49 * 8, 22, 49, 0, new Image("wall-left-middle.png"), "wall left middle"));
        wallsLeftMiddle.add(new ObjetStatique("wall-left-bottom", 0, windowHeight * tilesize - 57, 22, 57, 0, new Image("wall-left-bottom.png"), "wall left bottom"));
        wallsLeftMiddle.add(new ObjetStatique("wall-right-bottom", windowWidth * tilesize - 22, windowHeight * tilesize - 57, 22, 57, 0, new Image("wall-right-bottom.png"), "wall right bottom"));
        wallsLeftMiddle.add(new ObjetStatique("ruin1", 100, 100, 30, 30, 0, new Image("White_ruins5.png"), "ruin"));
        wallsLeftMiddle.add(new ObjetStatique("ruin2", 150, 310, 64, 64, 0, new Image("White_ruins3.png"), "ruin"));
        wallsLeftMiddle.add(new ObjetStatique("hajra1", 350, 50, 30, 30, 0, new Image("Icons_33.png"), "hajra"));
        wallsLeftMiddle.add(new ObjetStatique("hajra2", 400, 300, 32, 32, 0, new Image("Icons_28.png"), "7outa"));
        wallsLeftMiddle.add(new Coffre("coffre", 450, 80, 32, 27, 0, new Image("sondouk.png"), "un coffre mysterieux!", 10, true));
        walls.add(new ObjetStatique("wall", 0, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        walls.add(new ObjetStatique("wall", 204, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        walls.add(new ObjetStatique("wall", 204 * 2, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        walls.add(new ObjetStatique("wall", 204 * 3, 0, 204, 78, 0, new Image("wall1.png"), "wall"));

        //créer 1er caractère dweller
        Image[] sprites = {
            new Image("dweller1-down.png"),
            new Image("dweller1-up.png"),
            new Image("dweller1-right.png"),
            new Image("dweller1-left.png"),};
        Dweller dweller = new Dweller(0, 0, "Chahine", true, 300, 300, 30, 52, 5, sprites);
        dweller.setStatus(new Status(4, 3, 20, 20, 1));
        Ennemie ennemie1 = new Ennemie(true, "goblin", false, 150, 150, 29, 55, 5, new Image[]{
            new Image("goblin-down.png"),}, dweller);
        ennemie1.setStatus(new Status(4, 3, 15, 15, 1));
//        Thread ennemie1AI = new Thread(ennemie1);

        //dessiner l'environnement
        Group root = new Group();
        for (int i = 0; i < windowHeight; i++) {
            for (int j = 0; j < windowWidth; j++) {
                ImageView imgV = new ImageView();
                imgV.setFitHeight(tilesize);
                imgV.setFitWidth(tilesize);
                imgV.setImage(new Image("ground1.png"));
                imgList[i][j] = imgV;
                imgV.setX(j * tilesize);
                imgV.setY(i * tilesize);
                root.getChildren().add(imgV);
            }
        }
        for (ObjetStatique wall : walls) {
            root.getChildren().add(wall.getImage());
        }
        root.getChildren().add(wallLeftTop.getImage());
        for (Objet wall : wallsLeftMiddle) {
            root.getChildren().add(wall.getImage());
        }
        root.getChildren().add(dweller.getImage());
        root.getChildren().add(ennemie1.getImage());

        //dessiner HUD
        Rectangle healthBarFill = new Rectangle(41, 21, 118 * (dweller.getStatus().getSante() / dweller.getStatus().getSanteMax()), 18);
        healthBarFill.setFill(Color.RED);
        Rectangle healthBar = new Rectangle(40, 20, 120, 20);
        healthBar.setFill(Color.BLACK);
        healthBar.setStrokeWidth(3);
        healthBar.setStroke(Color.GRAY);
        root.getChildren().add(healthBar);
        root.getChildren().add(healthBarFill);

        //preparer scene de gameplay
        Scene scene = new Scene(root, tilesize * windowWidth, tilesize * windowHeight);

        //ajouter les controls pour le joueur
        dweller.ajouterCollision(ennemie1);
        for (ObjetStatique wall : walls) {
            dweller.ajouterCollision(wall);
        }
        dweller.ajouterCollision(wallLeftTop);
        for (Objet wall : wallsLeftMiddle) {
            dweller.ajouterCollision(wall);
        }
        dweller.ajouterControls(scene, healthBarFill, root);
        AnimationTimer timer = new AnimationTimer() {
            long lastTimeUpdated = 0;

            @Override
            public void handle(long now) {
                if (now - lastTimeUpdated >= 1000000000) {
                    if (ennemie1.detecterHitbox(dweller) && ennemie1.getStatus().getSante()>0) {
                        ennemie1.attacker(dweller, root);
                        healthBarFill.setWidth(118 * (dweller.getStatus().getSante() / dweller.getStatus().getSanteMax()));
                    }
                    lastTimeUpdated = now;
                }

            }
        };
        timer.start();

        //configurer le stage
        stage.setScene(scene);
        stage.setTitle("Abyss Dwellers");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
