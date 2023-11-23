/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

/**
 *
 * @author chahi
 */
public  final class Coffre extends ObjetInteractif {
    
     private int capacite;
    private boolean verrouille;
    private String cle;
    
    public Coffre(String nom, int posX, int posY, String message, int capacite, boolean verrouille) {
        super(nom, posX, posY, message);
        this.capacite= capacite;
        this.verrouille= verrouille;
        this.cle= "";
    }
    
    public void afficher_etat() {
        if (verrouille) {
            System.out.println("Coffre verrouille. Il faut une cle");
        }
    }
    
}
