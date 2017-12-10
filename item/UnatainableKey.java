/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import character.Hero;

/**
 *
 * @author Theo
 */
public class UnatainableKey extends Key {
    
    private Item neededItem;
    
    public UnatainableKey(String NAME, String DESCRIPTION, Item neededItem) {
        super(NAME, DESCRIPTION);
        this.neededItem = neededItem;
    }
    
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
