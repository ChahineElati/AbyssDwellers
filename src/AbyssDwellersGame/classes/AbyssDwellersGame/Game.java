/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame;

import AbyssDwellersGame.model.Dweller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chahi
 */
public class Game extends Application {
    
    @Override
    public void start(Stage stage) {
        
        //initialiser l'environnement
        final int tilesize = 45;
        final int windowWidth = 15;
        final int windowHeight = 12;
        ImageView[][] imgList = new ImageView[windowHeight][windowWidth];
        
        //créer 1er caractère dweller
        Image[] sprites = {
            new Image("dweller1-down.png"),
            new Image("dweller1-up.png"),
            new Image("dweller1-right.png"),
            new Image("dweller1-left.png"),
        };
        Dweller dweller = new Dweller(0, 0, "Chahine", true, 10, 10, 30, 52, 5, sprites);
        Dweller dweller2 = new Dweller(0, 0, "Chahine", true, 150, 150, 30, 52, 5, sprites);
        
        //dessiner l'environnement
        Group root = new Group();
         for(int i=0; i<windowHeight; i++) {
            for(int j=0; j<windowWidth; j++) {
                ImageView imgV = new ImageView();
                imgV.setFitHeight(tilesize);
                imgV.setFitWidth(tilesize);
                imgV.setImage(new Image("ground1.png"));
                imgList[i][j] = imgV;
                imgV.setX(j * tilesize);
                imgV.setY(i* tilesize);
                root.getChildren().add(imgV);
            }
        }
        root.getChildren().add(dweller.getImage());
        root.getChildren().add(dweller2.getImage());
        
      
        //preparer scene de gameplay
        Scene scene = new Scene(root, tilesize* windowWidth, tilesize * windowHeight);    
      
        //ajouter les controls pour le joueur
        dweller.ajouterCollision(dweller2);
        dweller.ajouterControls(scene);
        
        //configurer le stage
        stage.setScene(scene);
        stage.setTitle("Abyss Dwellers");
        stage.show();
 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
