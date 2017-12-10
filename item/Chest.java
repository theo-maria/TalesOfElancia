package item;

import character.Hero;
import java.util.*;

public class Chest extends Item {

    private Collection<Item> containedItems;

    public Chest(String name) {
        super(name, "Contient des objets", 0, 0, 0, 0);
        containedItems = new ArrayList<>();
    }
    
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
    
    public void addItem(Item i){
        containedItems.add(i);
    }
}