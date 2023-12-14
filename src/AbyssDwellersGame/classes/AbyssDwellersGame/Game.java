/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame;

import AbyssDwellersGame.exceptions.ValeurInacceptableException;
import AbyssDwellersGame.model.Coffre;
import AbyssDwellersGame.model.Dweller;
import AbyssDwellersGame.model.Ennemie;
import AbyssDwellersGame.model.Inventaire;
import AbyssDwellersGame.model.Key;
import AbyssDwellersGame.model.Objet;
import AbyssDwellersGame.model.ObjetStatique;
import AbyssDwellersGame.model.PotionMana;
import AbyssDwellersGame.model.PotionSante;
import AbyssDwellersGame.model.Status;
import java.awt.HeadlessException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author chahi
 */
public class Game extends Application {

    MediaPlayer mediaPlayer;

    public void music() {
        String s = "ingame.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setVolume(0.7);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
        });
        mediaPlayer.play();

    }

    @Override
    public void start(Stage stage) throws InterruptedException, ValeurInacceptableException {

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
//        wallsLeftMiddle.add(new ObjetStatique("ruin1", 100, 100, 29, 22, 0, new Image("White_ruins5.png"), "ruin"));
        wallsLeftMiddle.add(new ObjetStatique("ruin2", 150, 310, 64, 64, 0, new Image("White_ruins3.png"), "ruin"));
        wallsLeftMiddle.add(new ObjetStatique("hajra1", 350, 50, 30, 30, 0, new Image("Icons_33.png"), "hajra"));
        wallsLeftMiddle.add(new ObjetStatique("hajra2", 400, 300, 32, 32, 0, new Image("Icons_28.png"), "7outa"));
        walls.add(new ObjetStatique("wall", 0, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        walls.add(new ObjetStatique("wall", 204, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        walls.add(new ObjetStatique("wall", 204 * 2, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        walls.add(new ObjetStatique("wall", 204 * 3, 0, 204, 78, 0, new Image("wall1.png"), "wall"));
        ObjetStatique ob1 = new ObjetStatique("ruin1", 100, 100, 29, 22, 0, new Image("White_ruins5.png"), "ruin");
        Coffre coffre = new Coffre("coffre", 450, 80, 32, 27, 0, new Image("sondouk.png"), "un coffre mysterieux!", 10, true, "123");
        coffre.setLockedC(new Image("sondouk.png"));
        coffre.setUnlockedC(new Image("sondouk_open.png"));
        wallsLeftMiddle.add(coffre);
        Key key = new Key("cle", 333, 333, 32, 27, 0, new Image("Icons_09.png"), "le cle", "123");
        wallsLeftMiddle.add(key);
//créer 1er caractère dweller
        Image[] sprites = {
            new Image("dweller1-down.png"),
            new Image("dweller1-up.png"),
            new Image("dweller1-right.png"),
            new Image("dweller1-left.png"),};
        Dweller dweller = new Dweller(0, 0, "Chahine", true, 300, 200, 30, 52, 5, sprites);
        dweller.setStatus(new Status(4, 3, 20, 20, 1));
        Inventaire inventaire = new Inventaire();
        inventaire.getItems().add(new PotionSante("potion sante", "augmenter points sante", 3, 10, new Image("health-potion.png")));
        inventaire.getItems().add(new PotionMana("potion mana", "augmenter points mana", 5, 5, new Image("mana-potion.png")));
        dweller.setInventaire(inventaire);
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
        root.getChildren().add(ob1.getImage());

        //dessiner HUD
        Rectangle healthBarFill = new Rectangle(41, 21, 118 * (dweller.getStatus().getSante() / dweller.getStatus().getSanteMax()), 18);
        healthBarFill.setFill(Color.RED);
        Rectangle healthBar = new Rectangle(40, 20, 120, 20);
        healthBar.setFill(Color.BLACK);
        healthBar.setStrokeWidth(3);
        healthBar.setStroke(Color.GRAY);
        root.getChildren().add(healthBar);
        root.getChildren().add(healthBarFill);
        Label levell = new Label();
        levell.setFont(Font.font("", FontWeight.BOLD, 18));
        levell.setTextFill(Paint.valueOf("white"));
        levell.setLayoutX(45);
        levell.setLayoutY(50);

        StringProperty levelprop = new SimpleStringProperty();

        levelprop.set("Level: " + 1);
        levell.textProperty().bind(levelprop);

        dweller.levelProperty().addListener((observable, oldValue, newValue) -> {
            levelprop.set("Level: " + newValue.intValue());
        });

        root.getChildren().add(levell);

        //preparer scene de gameplay
        Scene gameplay = new Scene(root, tilesize * windowWidth, tilesize * windowHeight);

        //ajouter les controls pour le joueur
        dweller.ajouterCollision(ennemie1);
        for (ObjetStatique wall : walls) {
            dweller.ajouterCollision(wall);
        }
        dweller.ajouterCollision(wallLeftTop);
        dweller.ajouterCollision(ob1);
        for (Objet wall : wallsLeftMiddle) {
            dweller.ajouterCollision(wall);
        }
        dweller.ajouterControls(gameplay, healthBarFill, root, coffre);
        AnimationTimer timer = new AnimationTimer() {
            long lastTimeUpdated = 0;

            @Override
            public void handle(long now) {
                if (now - lastTimeUpdated >= 1000000000) {
                    if (ennemie1.detecterHitbox(dweller) && ennemie1.getStatus().getSante() > 0) {
                        ennemie1.attacker(dweller, root);
                        healthBarFill.setWidth(118 * (dweller.getStatus().getSante() / dweller.getStatus().getSanteMax()));
                    }
                    lastTimeUpdated = now;
                }

            }
        };
        timer.start();

        //menu principale
        music();
        VBox menuPrincipaleInterface = new VBox(30);
        Button btnJouer = new Button("JOUER");
        Button btnQuitter = new Button("QUITTER");
        btnJouer.setPrefWidth(150);
        btnQuitter.setPrefWidth(150);
        menuPrincipaleInterface.setAlignment(Pos.TOP_CENTER);
        menuPrincipaleInterface.setPadding(new Insets(75, 0, 0, 0));
//        ImageView logo = new ImageView(new Image("abyss_dwellers_logo.png"));
        StackPane sp = new StackPane();
        sp.getStyleClass().add("image-layout");
        menuPrincipaleInterface.getChildren().add(sp);
        menuPrincipaleInterface.getChildren().addAll(btnJouer, btnQuitter);
        Scene menuPrincipale = new Scene(menuPrincipaleInterface, tilesize * windowWidth, tilesize * windowHeight);
        menuPrincipale.getStylesheets().add(getClass().getResource("gamestyle.css").toString());
        btnJouer.setOnAction(event -> {
            stage.setScene(gameplay);
        });
        btnQuitter.setOnAction(event -> {
            stage.close();
        });

        //configurer le stage
        stage.setScene(menuPrincipale);
        stage.setTitle("Abyss Dwellers");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
