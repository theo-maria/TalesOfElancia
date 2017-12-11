package item;

import character.Hero;
import java.util.*;

/**
 * Un coffre contenant des objets
 */
public class Chest extends Item {

    private Collection<Item> containedItems;

    /**
     * Permet d'instancier un coffre
     * @param name nom du coffre
     */
    public Chest(String name) {
        super(name, "Contient des objets", 0, 0, 0, 0);
        containedItems = new ArrayList<>();
    }
    
    /**
     * Permet de donner le contenu du coffre au héros
     * @param hero héros
     */
    @Override
    public void take(Hero hero)
    {
        System.out.println("Voici le contenu que vous récupérez: ");
        for( Item item : this.containedItems )
        {
            hero.takeItem(item);
            System.out.print(item.NAME + " ");
        }
        System.out.println("");
        this.containedItems.clear();
        hero.getCurrentPlace().removeItemFromPlace(this);
    }
    
    /**
     * Permet d'ajouter un objet au coffre
     * @param i objet
     */
    public void addItem(Item i){
        containedItems.add(i);
    }
}