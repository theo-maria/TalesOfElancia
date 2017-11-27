package character.hero;

import character.GameCharacter;
import item.equipment.Equipment;
import item.Item;
import java.util.*;

public abstract class Hero extends GameCharacter {

    private Collection<Item> inventory;

    public Hero(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_INTELLIGENCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_INTELLIGENCE, BASE_AGILITY);
    }
        

	/**
	 * 
	 * @param item
	 */
	public void takeItem(Item item) {
		// TODO - implement Hero.takeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public void equipItem(Equipment e) {
		// TODO - implement Hero.equipItem
		throw new UnsupportedOperationException();
	}

}