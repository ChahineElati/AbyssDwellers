/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public sealed class ObjetInteractif extends Objet permits Coffre {
    
     private String message;
    
    public ObjetInteractif(String nom, int posX, int posY, String message) {
        super(nom, posX, posY);
        this.message= message;
    }
    
    public void interact(){
        
    }
}
