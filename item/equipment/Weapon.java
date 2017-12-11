package item.equipment;

import item.Equipment;

/**
 * Arme
 */
public class Weapon extends Equipment {
    
    /**
     * Permet d'instancier une arme
     * @param name nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH bonus de vie
     * @param BONUS_ARMOR bonus d'armure
     * @param BONUS_FORCE bonus de force
     * @param BONUS_AGILITY bonus d'agilité
     */
    public Weapon(String name, String DESCRIPTION, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        
        super(name, DESCRIPTION, BONUS_HEALTH, 
            BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }
}