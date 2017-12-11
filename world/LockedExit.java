/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import item.Key;

/**
 * Une sortie vérouillée
 */
public class LockedExit extends Exit {
    /**
     * Fermé
     */
    private Boolean locked;
    /**
     * Clé correspondante
     */
    private final Key MATCHING_KEY;

    /**
     * Permet d'instancier une sortie vérouillée
     * @param ledPlace lieu
     * @param doorDescription description
     * @param MATCHING_KEY clé correspondante
     */
    public LockedExit(Place ledPlace, String doorDescription, Key MATCHING_KEY) {
        super(ledPlace,doorDescription);
        locked = true;
        this.MATCHING_KEY = MATCHING_KEY;
    }
    
    /**
     * Tenter d'ouvrir la sortie dans clé
     * @return le lieu si sortie dévérouillée
     */
    @Override
    public Place accessExit(){
        if(locked){
            System.out.println("La porte semble vérouillée");
            return null;
        }
        else
            return ledPlace;
    }
    
    /**
     * Tenter d'ouvrir une porte avec une clé
     * @param key clé
     * @return lieu
     */
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
