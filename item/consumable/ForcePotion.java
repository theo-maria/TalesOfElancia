package item.consumable;

public class ForcePotion extends BuffPotion {


    public ForcePotion() {
        super("Force Potion", 0, 0, 0, 5,0);
    }
    
    @Override
    public void use() {
        relatedHero.buffHero(this);
    }
    
}