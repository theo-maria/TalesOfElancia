/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import character.GameCharacter;
import character.npc.Guard;

/**
 *
 * @author Theo
 */
public class ThrowableItem extends Item {
    
    private GameCharacter throwableOn;

    public ThrowableItem(String NAME, String DESCRIPTION, GameCharacter throwableOn) {
        super(NAME, DESCRIPTION, 0, 0, 0, 0);
        this.throwableOn = throwableOn;
    }
    public void throwItem(){
        if(throwableOn instanceof Guard){
            System.out.println("Voulez lancez l'objet sur '" + throwableOn.NAME + "'");
            ((Guard)throwableOn).knockOut();
        }
    }
    
    public Object getThrowableOn() {
        return throwableOn;
    }
}
