/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import character.GameCharacter;
import character.npc.Guard;

/**
 * Un objet lancable
 */
public class ThrowableItem extends Item {
    
    /**
     * Personnage sur qui on peut lancer l'objet
     */
    private GameCharacter throwableOn;

    /**
     * Permet d'instancier un objet lancable
     * @param NAME nom
     * @param DESCRIPTION description
     * @param throwableOn personnage
     */
    public ThrowableItem(String NAME, String DESCRIPTION, GameCharacter throwableOn) {
        super(NAME, DESCRIPTION, 0, 0, 0, 0);
        this.throwableOn = throwableOn;
    }

    /**
     * Permet de lancer l'objet sur le personnage
     */
    public void throwItem(){
        if(throwableOn instanceof Guard){
            System.out.println("Voulez lancez l'objet sur '" + throwableOn.NAME + "'");
            ((Guard)throwableOn).knockOut();
        }
    }
    
    /**
     * Permet de savoir sur qui on peut lancer l'objet
     * @return personnage
     */
    public Object getThrowableOn() {
        return throwableOn;
    }
}
