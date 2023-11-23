/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbyssDwellersGame.model;

import AbyssDwellersGame.service.Switchable;
import java.util.ArrayList;

/**
 *
 * @author chahi
 */
public  final class Party implements Switchable {
    
    private int caractereSelectionne;
    private ArrayList<Dweller> dwellers;

    public Party(int caractereSelectionne) {
        this.caractereSelectionne = caractereSelectionne;
    }

    public int getCaractereSelectionne() {
        return caractereSelectionne;
    }

    public void setCaractereSelectionne(int caractereSelectionne) {
        this.caractereSelectionne = caractereSelectionne;
    }
    
    @Override
    public void change(int pos) {
        
    }
    
}
