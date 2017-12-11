package item.equipment;

import item.Equipment;

/**
 * Lunettes
 */
public class Glasses extends Equipment {

    /**
     * Permt d'instancier des lunettes
     * @param NAME nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH bonus de vie
     * @param BONUS_ARMOR bonus d'armure
     * @param BONUS_FORCE bonus de force
     * @param BONUS_AGILITY bonus d'agilité
     */
    public Glasses(String NAME, String DESCRIPTION, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        
        super(NAME, DESCRIPTION, BONUS_HEALTH, 
            BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }
}