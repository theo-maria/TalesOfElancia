package item.equipment;


import item.Item;

public class Equipment extends Item {

    private Boolean worn;
    private final int BONUS_DAMAGE;
    private final int BONUS_INTELLIGENCE;
    private final int BONUS_HEALTH;
    private final int BONUS_ARMOR;
    private final int BONUS_FORCE;
    private final int BONUS_AGILITY;
    
    public Equipment(int bonusDamage, int bonusIntelligence, int bonusHealth, 
            int bonusArmor, int bonusForce, int bonusAgility)
    {
        this.worn = false;
        this.BONUS_DAMAGE = bonusDamage;
        this.BONUS_INTELLIGENCE = bonusIntelligence;
        this.BONUS_HEALTH = bonusHealth;
        this.BONUS_ARMOR = bonusArmor;
        this.BONUS_FORCE = bonusForce;
        this.BONUS_AGILITY = bonusAgility;
    }
        
    public Boolean isWorned()
    {
        return this.worn;
    }

    public void setWorn(boolean worn) {
        this.worn = worn;
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