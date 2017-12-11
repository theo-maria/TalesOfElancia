package item.consumable;

/**
 * Potion de force
 */
public class ForcePotion extends BuffPotion {

    /**
     * Permet d'instancier une potion de force
     */
    public ForcePotion() {
        super("Force Potion", "Potion qui donne un bonus de force pour 1 combat", 0, 0, 5,0);
    }
    
    /**
     * Permet d'utiliser la potion
     */
    @Override
    public void use() {
        relatedHero.buffHero(this);
    }
    
}