/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame;

import AbyssDwellersGame.model.Caractere;
import AbyssDwellersGame.model.Dweller;
import AbyssDwellersGame.model.Ennemie;
import AbyssDwellersGame.model.GameObject;
import AbyssDwellersGame.model.ObjetStatique;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author chahi
 */
public class Game extends Application {

    @Override
    public void start(Stage stage) {

        //dessiner l'environnement
        final int tilesize = 45;
        final int windowWidth = 15;
        final int windowHeight = 12;
        ImageView[][] imgList = new ImageView[windowHeight][windowWidth];
        ObjetStatique wallLeftTop = new ObjetStatique("wall-left-top", 0, 0, 22, 65, 0, new Image("wall-left-top.png"), "wall left top");
        ArrayList<ObjetStatique> walls = new ArrayList<>();
        ArrayList<ObjetStatique> wallsLeftMiddle = new ArrayList<>();
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
        Ennemie ennemie1 = new Ennemie(true, "goblin", false, 150, 150, 29, 55, 5, new Image[]{
            new Image("goblin-down.png"),});

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
        for (ObjetStatique wall : wallsLeftMiddle) {
            root.getChildren().add(wall.getImage());
        }
        root.getChildren().add(dweller.getImage());
        root.getChildren().add(ennemie1.getImage());

        //preparer scene de gameplay
        Scene scene = new Scene(root, tilesize * windowWidth, tilesize * windowHeight);

        //ajouter les controls pour le joueur
        dweller.ajouterCollision(ennemie1);
        for (ObjetStatique wall : walls) {
            dweller.ajouterCollision(wall);
        }
        dweller.ajouterCollision(wallLeftTop);
        for (ObjetStatique wall : wallsLeftMiddle) {
            dweller.ajouterCollision(wall);
        }
        dweller.ajouterControls(scene);

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
