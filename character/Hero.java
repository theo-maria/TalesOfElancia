package character;

import game.Fight;
import item.Consumable;
import item.Equipment;
import item.Item;
import java.util.*;

public abstract class Hero extends GameCharacter {

    private List<Item> inventory;
    private List<Consumable> activatedItems ;
    private final String CLASS_NAME;

    public Hero(String NAME, String CLASS_NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_AGILITY);
        this.CLASS_NAME = CLASS_NAME;
    }

    public String getCLASS_NAME() {
        return CLASS_NAME;
    }
    /**
     * 
     * @param item
     */
    public void takeItem(Item item)
    {
        super.getCurrentPlace().removeItemFromPlace(item);
        this.inventory.add(item);
        item.setRelatedHero(this);
        item.take(this);
    }

    @Override
    public int getMaxHealth() {

        int healthBonus = 0;
        for(Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    healthBonus += item.getBONUS_HEALTH();
                }
            }
        }

        return super.getMaxHealth() + healthBonus;   
    }


    @Override
    public int getTotalArmor() 
    {
        int armorBonus = 0;
        for(Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    armorBonus += item.getBONUS_ARMOR();
                }
            }
        }

        return super.getTotalArmor() + armorBonus;
    }

    @Override
    public int getTotalForce() 
    {
        int forceBonus = 0;
        for( Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    forceBonus += item.getBONUS_FORCE();
                }
            }
        }

        return super.getTotalForce() + forceBonus;
    }

    @Override
    public int getTotalAgility() 
    {
        int agilityBonus = 0;
        for( Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    agilityBonus += item.getBONUS_AGILITY();
                }
            }
        }
        return super.getTotalAgility() + agilityBonus;
    }

    /**
     * 
     * @param e
     */
    public void equipItem(Equipment e)
    {
        for(Item item : this.inventory)
        {
            if(item.equals(e))
            {
                e.setWorn(true);
            }
        }
    }
    
    public void useItem(Item item){
        if (item instanceof Equipment)
            equipItem((Equipment)item);
        else if(item instanceof Consumable)
            ((Consumable) item).use();
    }
    
    public void useItem(Item item1, Item item2){
        
    }

    public void buffHero(Consumable c)
    {
        activatedItems.add(c);
        inventory.remove(c);
    }

    /**
     * 
     * @param c
     */
    public void fight(Enemy e) {
        Fight fight = new Fight(this, e);
    }

    public List<Item> getInventory() {
        return inventory;
    }
    
    
}
