/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public final class ObjetStatique extends Objet {
    
    private String description;
    
    public ObjetStatique(String nom, int posX, int posY, String description) {
        super(nom, posX, posY);
        this.description= description;
    }
    
    public String getDescription() {
        return description;
    }
    
}
