package item.consumable;

public class ForcePotion extends BuffPotion {


    public ForcePotion() {
        super("Force Potion", "Potion qui donne un bonus de force pour 1 combat", 0, 0, 5,0);
    }
    
    @Override
    public void use() {
        relatedHero.buffHero(this);
    }
    
}