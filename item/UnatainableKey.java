/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import character.Hero;

/**
 * Une clé qui nécessite un objt particulier pour être atteinte
 */
public class UnatainableKey extends Key {
    
    private Item neededItem;
    
    /**
     * Permet d'instancier la clé
     * @param NAME nom
     * @param DESCRIPTION description
     * @param neededItem objet requis
     */
    public UnatainableKey(String NAME, String DESCRIPTION, Item neededItem) {
        super(NAME, DESCRIPTION);
        this.neededItem = neededItem;
    }
    
    /**
     * Permet au héros de ramasser la clé, si il possède l'objet requis
     * @param hero héros
     */
    @Override
    public void take(Hero hero)
    {
        if(hero.hasItem(neededItem)){
            System.out.println("Vous ramassez la clé à l'aide de '" + neededItem.NAME + "'");
            super.take(hero);
        }
            
        else
            System.out.println("Vous ne pouvez pas atteindre l'objet...");
    }
    
}
