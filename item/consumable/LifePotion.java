package item.consumable;

public class LifePotion extends Potion {

    public LifePotion() {
        super("Life Potion", 0, 20, 0, 0, 0);
    }

    @Override
    public void use() {
        relatedHero.buffHero(this);
    }
}