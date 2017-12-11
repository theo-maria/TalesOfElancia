package item;

/**
 * Un equipement
 */
public class Equipment extends Item {

    /**
     * Indique si l'équipement est porté
     */
    private Boolean worn;
    
    /**
     * Permt d'instancier un équipement
     * @param NAME nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH bonus de vie
     * @param BONUS_ARMOR bonus d'armure
     * @param BONUS_FORCE bonus de force
     * @param BONUS_AGILITY bonus d'agilité
     */
    public Equipment(String NAME, String DESCRIPTION, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY)
    {
        super(NAME, DESCRIPTION, BONUS_HEALTH, 
            BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
        this.worn = false;
    }
        
    /**
     * Permet de savoir si l'objet est porté par le héros
     * @return true si porté, false sinons
     */
    public Boolean isWorned()
    {
        return this.worn;
    }

    /**
     * Permet de définir si l'équipement est porté ou non
     * @param worn porté
     */
    public void setWorn(boolean worn) {
        this.worn = worn;
    }
}