package character.hero;

import character.GameCharacter;
import item.equipment.Equipment;
import item.Item;
import java.util.*;

public abstract class Hero extends GameCharacter {

	private Collection<Item> inventory;

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