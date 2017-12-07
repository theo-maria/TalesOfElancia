package item;

import character.Hero;
import java.util.*;

public class Chest extends Item {

    private Collection<Item> containedItems;

    public Chest(String name, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
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