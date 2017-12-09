/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import item.Key;

/**
 *
 * @author Theo
 */
public class LockedExit extends Exit {
    private Boolean locked;
    private final Key MATCHING_KEY;

    public LockedExit(Place ledPlace, String doorDescription, Key MATCHING_KEY) {
        super(ledPlace,doorDescription);
        locked = true;
        this.MATCHING_KEY = MATCHING_KEY;
    }
    
    @Override
    public Place accessExit(){
        if(locked){
            System.out.println("La porte semble vérouillée");
            return null;
        }
        else
            return ledPlace;
    }
    
    @Override
    public Place accessExit(Key key){
        if(key == MATCHING_KEY){
            locked = false;
            return super.ledPlace;
        }
        System.out.println("La clé ne semble pas correspondre à la serrure");
        return null;
    }
}
