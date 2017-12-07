package item;

public class Equipment extends Item {

    private Boolean worn;
    
    public Equipment(String name, int BONUS_DAMAGE, int BONUS_INTELLIGENCE, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY)
    {
        super(name, BONUS_DAMAGE, BONUS_INTELLIGENCE, BONUS_HEALTH, 
            BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
        this.worn = false;
    }
        
    public Boolean isWorned()
    {
        return this.worn;
    }

    public void setWorn(boolean worn) {
        this.worn = worn;
    }
}