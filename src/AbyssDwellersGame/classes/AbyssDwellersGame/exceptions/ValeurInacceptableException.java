/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.exceptions;

/**
 *
 * @author chahi
 */
public class ValeurInacceptableException extends Exception {
    
    public  ValeurInacceptableException() {
        super("La valeur doit etre inferieure a la valeur max et superieur a 0");
    }
}
