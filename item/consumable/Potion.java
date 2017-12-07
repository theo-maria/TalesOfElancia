package item.consumable;

import item.Consumable;

public abstract class Potion extends Consumable {

    public Potion(String name, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

    @Override
    public abstract void use();
    //To change body of generated methods, choose Tools | Templates.

}