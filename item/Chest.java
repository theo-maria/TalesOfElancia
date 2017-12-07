package item;

import character.Hero;
import java.util.*;

public class Chest extends Item {

    private Collection<Item> containedItems;

    public Chest() {
        super("Coffre", "Contient des objets", 0, 0, 0, 0);
    }
    
    @Override
    public void take(Hero hero)
    {
        super.take(hero);
        for( Item item : this.containedItems )
        {
            hero.takeItem(item);
        }
        this.containedItems.clear();
    }
}