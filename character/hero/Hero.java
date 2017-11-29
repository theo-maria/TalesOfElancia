package character.hero;

import character.GameCharacter;
import item.equipment.Equipment;
import item.Item;
import java.util.*;

public abstract class Hero extends GameCharacter {

    private Collection<Item> inventory;
    private final String CLASS_NAME;

    public Hero(String NAME, String CLASS_NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_INTELLIGENCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_INTELLIGENCE, BASE_AGILITY);
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
        this.inventory.add(item);
        item.take(this);
    }

    @Override
    public int getTotalHealth() {

        int healthBonus = 0;
        for(Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    healthBonus += ((Equipment) item).getBONUS_HEALTH();
                }
            }
        }

        return super.getTotalHealth() + healthBonus;   
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
                    armorBonus += ((Equipment) item).getBONUS_ARMOR();
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
                    forceBonus += ((Equipment) item).getBONUS_FORCE();
                }
            }
        }

        return super.getTotalForce() + forceBonus;
    }

    @Override
    public int getTotalIntelligence() 
    {
        int intelligenceBonus = 0;
        for( Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    intelligenceBonus += ((Equipment) item).getBONUS_INTELLIGENCE();
                }
            }
        }

        return super.getTotalIntelligence() + intelligenceBonus;
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
                    agilityBonus += ((Equipment) item).getBONUS_AGILITY();
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
            else
            {
                //gérer le cas où l'équipement n'est pas dans l'inventaire
            }
        }
    }

    //Méthode facilitant l'utilisation des potions

    // Méthode permettant de heal le héro (utilisé dans les potions)
    public void healHero(int valHeal)
    {
        currentHealth += valHeal;
    }

    // Méthode permettant de donner des dégats au héro (utilisé dans les potions)
    public void giveDamage(int valForce)
    {
        currentForce += valForce;
    }

    // Méthode permettant de d'augmenter grandement la force du héro au prix de son armure
    public void giveArmor(int valArmor)
    {
        currentArmor += valArmor;
    }  
}
