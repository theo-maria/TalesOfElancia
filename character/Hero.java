package character;

import game.Fight;
import item.Consumable;
import item.Equipment;
import item.Item;
import item.Key;
import item.ThrowableItem;
import java.util.*;
import world.Exit;
import world.Place;

public abstract class Hero extends GameCharacter {

    private List<Item> inventory;
    private List<Consumable> activatedItems ;
    private final String CLASS_NAME;

    public Hero(String NAME, String CLASS_NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_AGILITY);
        this.CLASS_NAME = CLASS_NAME;
        inventory = new ArrayList<>();
        activatedItems = new ArrayList<>();
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
        else if(item instanceof ThrowableItem){
            if(currentPlace.hasCharacter((GameCharacter) ((ThrowableItem)item).getThrowableOn())){
                ((ThrowableItem)item).throwItem();
                inventory.remove(item);
            }
        }
        else
            System.out.println("Rien ne se passe");
    }
    
    public void useItem(Item item1, Item item2){
        
    }

    public void buffHero(Consumable c)
    {
        activatedItems.add(c);
        inventory.remove(c);
    }
    
    public void talkTo(GameCharacter c) {
        if(c.isTalkable()){
            c.talk(this);
        }
        else{
            System.out.println("Pas de réponse...");
        }
    }

    public void fight(Enemy e) {
        Fight fight = new Fight(this, e);
        fight.startFight();
    }
    
    public void accessExit(Exit exit){
        Place p = exit.accessExit();
        if(p != null)
            currentPlace = p;
    }
    
    public void accessExit(Exit exit, Key key){
        Place p = exit.accessExit(key);
        if(p != null)
            currentPlace = p;
    }

    public List<Item> getInventory() {
        return inventory;
    }
    
    public List<Consumable> getConsumableItems(){
        List<Consumable> liste = new ArrayList<>();
        for(Item i : getInventory()){
            if(i instanceof Consumable)
                liste.add((Consumable)i);
        }
        return liste;
    }
    
    public void addItem(Item i){
        inventory.add(i);
    }
    
    public Boolean hasItem(Item i){
        return inventory.contains(i);
    }
    
    public void clearBuffs(){
        activatedItems.clear();
    }
}
