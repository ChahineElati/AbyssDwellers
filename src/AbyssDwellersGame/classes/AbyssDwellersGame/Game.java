/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame;

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
        
        Image img = new Image("player.png");
        ImageView iv = new ImageView(img);
           iv.setX(20);
        
        Group root = new Group();
        root.getChildren().add(iv);
 
        Scene scene = new Scene(root, 400, 400);       
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
