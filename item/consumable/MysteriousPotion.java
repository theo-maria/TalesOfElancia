package item.consumable;

/**
 * Une potion mystérieuse ayant un effet négatif et un effet positif
 */
public class MysteriousPotion extends DoubleEffectPotion {

    /**
     * Permet d'instancier une potion mystérieuse
     */
    public MysteriousPotion() {
        super("Mysterious Potion", "???", 0, -10, -20, 0);
    }

    /**
     * Permet d'utiliser la potion
     */
    @Override
    public void use() {
        relatedHero.buffHero(this);
    }

}