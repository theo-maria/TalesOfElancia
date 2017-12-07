package item;


import character.Hero;

public class Item {

    protected Hero relatedHero;
    private String name;
    protected final int BONUS_DAMAGE;
    protected final int BONUS_INTELLIGENCE;
    protected final int BONUS_HEALTH;
    protected final int BONUS_ARMOR;
    protected final int BONUS_FORCE;
    protected final int BONUS_AGILITY;
    
    public Item(String name, int BONUS_DAMAGE, int BONUS_INTELLIGENCE, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY)
    {
        this.name = name;
        this.BONUS_DAMAGE = BONUS_DAMAGE;
        this.BONUS_INTELLIGENCE = BONUS_INTELLIGENCE;
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getBONUS_DAMAGE() 
    {
        return BONUS_DAMAGE;
    }

    public int getBONUS_INTELLIGENCE() 
    {
        return BONUS_INTELLIGENCE;
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