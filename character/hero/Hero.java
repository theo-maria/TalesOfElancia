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
	public void takeItem(Item item) {
		// TODO - implement Hero.takeItem
		throw new UnsupportedOperationException();
	}
        
        @Override
        public int getTotalHealth() {
            
            int healthBonus = 0;
            for( Item item : this.inventory)
            {
                if(item instanceof Equipment)
                {
                    if(((Equipment) item).isWorned())
                    {
                        healthBonus += ((Equipment) item).getBonusHealth();
                    }
                }
            }
            
            return super.getTotalHealth() + healthBonus;   
	}
        
        
        @Override
        public int getTotalArmor() 
        {
            int armorBonus = 0;
            for( Item item : this.inventory)
            {
                if(item instanceof Equipment)
                {
                    if(((Equipment) item).isWorned())
                    {
                        armorBonus += ((Equipment) item).getBonusArmor();
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
                        forceBonus += ((Equipment) item).getBonusForce();
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
                        intelligenceBonus += ((Equipment) item).getBonusIntelligence();
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
                        agilityBonus += ((Equipment) item).getBonusAgility();
                    }
                }
            }
            
            return super.getTotalAgility() + agilityBonus;
	}

	/**
	 * 
	 * @param e
	 */
	public void equipItem(Equipment e) {
		// TODO - implement Hero.equipItem
		throw new UnsupportedOperationException();
	}

}