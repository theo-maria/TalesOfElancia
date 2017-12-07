package item.equipment;

import item.Equipment;

public class Armor extends Equipment {
    
    public Armor(String name, int BONUS_INTELLIGENCE, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        
        super(name, BONUS_INTELLIGENCE, BONUS_HEALTH, 
            BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }
}