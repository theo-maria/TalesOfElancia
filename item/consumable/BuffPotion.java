package item.consumable;

/**
 * Une potion apportant divers bonus
 */
public abstract class BuffPotion extends Potion {

    /**
     * Permet d'instancier une potion de buff
     * @param NAME nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH vie bonus
     * @param BONUS_ARMOR armure bonus
     * @param BONUS_FORCE force bonus
     * @param BONUS_AGILITY agilité bonus
     */
    public BuffPotion(String NAME, String DESCRIPTION, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(NAME, DESCRIPTION, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

    /**
     * Permet d'utiliser la potion de buff
     */
    @Override
    public abstract void use();
}