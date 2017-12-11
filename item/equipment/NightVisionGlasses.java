package item.equipment;

/**
 * Lunettes de vision nocturne
 */
public class NightVisionGlasses extends Glasses {
    
    /**
     * Permt d'instancier des lunettes de vision nocturne
     * @param NAME nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH bonus de vie
     * @param BONUS_ARMOR bonus d'armure
     * @param BONUS_FORCE bonus de force
     * @param BONUS_AGILITY bonus d'agilité
     */
    public NightVisionGlasses(String NAME, String DESCRIPTION, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        
        super(NAME, DESCRIPTION, BONUS_HEALTH, 
            BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }  
}