package item;


import item.Item;

public abstract class Consumable extends Item {

    public Consumable(String name, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

	public abstract void use();

}