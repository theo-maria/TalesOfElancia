package item;


import character.Hero;

public class Item {

    protected Hero relatedHero;
    public final String NAME;
    public final String DESCRIPTION;
    protected final int BONUS_HEALTH;
    protected final int BONUS_ARMOR;
    protected final int BONUS_FORCE;
    protected final int BONUS_AGILITY;
    
    public Item(String NAME, String DESCRIPTION, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY)
    {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.BONUS_HEALTH = BONUS_HEALTH;
        this.BONUS_ARMOR = BONUS_ARMOR;
        this.BONUS_FORCE = BONUS_FORCE;
        this.BONUS_AGILITY = BONUS_AGILITY;
    }
    
    public void take(Hero hero)
    {
        this.relatedHero = hero;
    }

    public Hero getRelatedHero() 
    {
        return this.relatedHero;
    }

    public int getBONUS_HEALTH() 
    {
        return BONUS_HEALTH;
    }

    public int getBONUS_ARMOR() 
    {
        return BONUS_ARMOR;
    }

    public int getBONUS_FORCE() 
    {
        return BONUS_FORCE;
    }

    public int getBONUS_AGILITY() 
    {
        return BONUS_AGILITY;
    }
}