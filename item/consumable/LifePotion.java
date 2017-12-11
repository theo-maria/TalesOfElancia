package item.consumable;

/**
 * Potion de vie
 */
public class LifePotion extends Potion {

    /**
     * Permet d'instancier une potion de vie
     */
    public LifePotion() {
        super("Life Potion", "Potion qui redonne de la vie", 0, 20, 0, 0);
    }

    /**
     * Permet d'utiliser la potion
     */
    @Override
    public void use() {
        relatedHero.buffHero(this);
    }
}