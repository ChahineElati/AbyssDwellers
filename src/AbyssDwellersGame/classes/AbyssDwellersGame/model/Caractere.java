/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
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
    private boolean hashKey;

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

    public Inventaire getInventaire() {
        return inventaire;
    }

    public ImageView getImage() {
        return image;
    }

    public Image[] getSprites() {
        return sprites;
    }

    public boolean hashKey() {
        return hashKey;
    }

    public void setHashKey(boolean hashKey) {
        this.hashKey = hashKey;
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

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public void visualiserInventaire(Stage inventaire) {
        final ObservableList<Item> data = FXCollections.observableArrayList(this.inventaire.getItems());
        HBox windowButtons = new HBox();
        windowButtons.setAlignment(Pos.TOP_RIGHT);
        Button closeBtn = new Button("X");
        closeBtn.setOnAction(e -> {
            inventaire.close();
        });
        windowButtons.getChildren().add(closeBtn);
        TableView<Item> itemsTableView = new TableView<>();
        TableColumn icon = new TableColumn();
        TableColumn item = new TableColumn("Item");
        TableColumn description = new TableColumn("Description");
        TableColumn effet = new TableColumn("Effet");
        TableColumn nombre = new TableColumn("Nombre");
        item.setCellValueFactory(new PropertyValueFactory<>("label"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        effet.setCellValueFactory(new Callback<CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Item, String> p) {
                if (p.getValue() instanceof PotionMana mana) {
                    return new ReadOnlyStringWrapper(String.valueOf(mana.getEffetMana()));
                } else if (p.getValue() instanceof PotionSante sante) {
                    return new ReadOnlyStringWrapper(String.valueOf(sante.getEffetSante()));
                } else {
                    return null;
                }
            }
        });
        icon.setCellFactory(param -> {
            //Set up the ImageView
            final ImageView imageview = new ImageView();
            imageview.setFitHeight(50);
            imageview.setFitWidth(50);

            //Set up the Table
            TableCell<Item, Image> cell = new TableCell<Item, Image>() {
                @Override
                public void updateItem(Image item, boolean empty) {
                    if (item != null) {
                        imageview.setImage(item);
                    }
                }
            };
            // Attach the imageview to the cell
            cell.setGraphic(imageview);
            return cell;
        });
        icon.setCellValueFactory(new PropertyValueFactory<Item, Image>("icon"));
        icon.setPrefWidth(50);
        icon.setResizable(false);
        icon.setReorderable(false);
        icon.setSortable(false);
        item.setPrefWidth(100);
        item.setResizable(false);
        item.setReorderable(false);
        item.setSortable(false);
        description.setPrefWidth(150);
        description.setResizable(false);
        description.setReorderable(false);
        description.setSortable(false);
        effet.setPrefWidth(50);
        effet.setResizable(false);
        effet.setReorderable(false);
        effet.setSortable(false);
        nombre.setPrefWidth(55);
        nombre.setResizable(false);
        nombre.setReorderable(false);
        nombre.setSortable(false);
        itemsTableView.getColumns().addAll(icon, item, description, effet, nombre);
        itemsTableView.setItems(data);
        VBox holder = new VBox();
        holder.getChildren().add(windowButtons);
        holder.getChildren().add(itemsTableView);
        Scene sc = new Scene(holder, 407, 300);
        inventaire.setScene(sc);
        inventaire.initStyle(StageStyle.UNDECORATED);
        sc.getStylesheets().add(getClass().getResource("/AbyssDwellersGame/ingamestyle.css").toString());

        inventaire.show();
    }

    public void ajouterControls(Scene scene, Rectangle healthBarFill, Group root, Coffre coffre) {
        scene.setOnKeyPressed((e) -> {
            for (GameObject objet : collisions) {
                if (objet instanceof ObjetInteractif) {

                    if (detecterHitbox(objet)) {

                        if (!root.getChildren().contains(((ObjetInteractif) objet).getIndicator())) {
                            root.getChildren().add(((ObjetInteractif) objet).getIndicator());
                        } else if (objet instanceof Coffre) {
                            if (!root.getChildren().contains(((ObjetInteractif) objet).getIndicator())) {
                                root.getChildren().add(((ObjetInteractif) objet).getIndicator());
                            }
                        }
                    } else {
                        root.getChildren().remove(((ObjetInteractif) objet).getIndicator());
                    }
                }
            }
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
            if (e.getCode().toString().equals("X")) {

                Iterator<GameObject> iterator = collisions.iterator();
                while (iterator.hasNext()) {
                    GameObject objet = iterator.next();
                    if (objet instanceof Key && detecterHitbox(objet)) {

                        iterator.remove();
                        // Dweller has the key
                        Key key = (Key) objet;
                        collisions.remove(key);
                        root.getChildren().remove(key.getImage());
                        root.getChildren().remove(key.getIndicator());
                        hashKey = true;
                        System.out.println("Key found!");
                    }
                }
            }
            if (e.getCode().toString().equals("C")) {
                if (coffre.isVerrouille() && hashKey()) {
                    coffre.deverrouiller();
                    root.getChildren().remove(coffre.getIndicator());
                    System.out.println("Chest is unlocked!");
                    
                } else {
                    System.out.println("You don't have the key to unlock the chest.");
                }
            }
            if (e.getCode().equals(KeyCode.M)) {
                Stage inventaire = new Stage();
                visualiserInventaire(inventaire);
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
            if (nouvelleSante <= 0) {
                if (caractere instanceof Dweller) {
                    Button btnQuitter = new Button("QUITTER");
                    btnQuitter.setPrefWidth(150);
                    VBox gameOverInterface = new VBox(30);
                    Label message = new Label("Tu es mort");
                    message.setFont(Font.font(21));
                    Label gameOverLabel = new Label("Game Over");
                    gameOverLabel.setFont(Font.font("", FontWeight.BOLD, 35));
                    gameOverInterface.setAlignment(Pos.CENTER);
                    gameOverInterface.getStylesheets().add(getClass().getResource("/AbyssDwellersGame/gamestyle.css").toString());
                    gameOverInterface.getChildren().addAll(gameOverLabel, message, btnQuitter);
                    gameOverInterface.setSpacing(30);

                    Scene scene = new Scene(gameOverInterface, root.getScene().getWidth(), root.getScene().getHeight());
                    Stage stage = (Stage) root.getScene().getWindow();
                    stage.setScene(scene);

                    btnQuitter.setOnAction(event -> {
                        stage.close();
                    });
                }
                caractere.getStatus().setSante(0);

                if (this instanceof Dweller) {
                    collisions.remove(caractere);
                }
                root.getChildren().remove(caractere.image);
            } else {
                caractere.getStatus().setSante(nouvelleSante);
            }
        }
    }
}
