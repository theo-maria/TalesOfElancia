package item.consumable;

public class LifePotion extends Potion {

    public LifePotion() {
        super("Life Potion", "Potion qui redonne de la vie", 0, 20, 0, 0, 0);
    }

    @Override
    public void use() {
        relatedHero.buffHero(this);
    }
}