package item.consumable;

import item.Consumable;

/**
 * Une potion
 */
public abstract class Potion extends Consumable {

    /**
     * Permet d'instancier une potion
     * @param NAME nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH vie bonus
     * @param BONUS_ARMOR armure bonus
     * @param BONUS_FORCE force bonus
     * @param BONUS_AGILITY agilité bonus
     */
    public Potion(String NAME, String DESCRIPTION,int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(NAME, DESCRIPTION, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

    /**
     * Permet d'utiliser la potion
     */
    @Override
    public abstract void use();

}