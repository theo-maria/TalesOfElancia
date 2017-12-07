package item.consumable;

public class MysteriousPotion extends DoubleEffectPotion {

    public MysteriousPotion() {
        super("Mysterious Potion", "???", 0, -10, -20, 0);
    }

    @Override
    public void use() {
        relatedHero.buffHero(this);
    }

}