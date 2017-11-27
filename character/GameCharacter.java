package character;

import world.Place;
import game.Goal;
import java.util.*;

public abstract class GameCharacter {

	private Place currentPlace;
	private Collection<Goal> activableGoals;
	private GameCharacter fightingCharacter;
	private int name;
	private int baseHealth;
	private int baseArmor;
	private int baseForce;
	private int baseIntelligence;
	private int baseAgility;

	public void getTotalHealth() {
		// TODO - implement Character.getTotalHealth
		throw new UnsupportedOperationException();
	}

	public void getTotalArmor() {
		// TODO - implement Character.getTotalArmor
		throw new UnsupportedOperationException();
	}

	public void getTotalForce() {
		// TODO - implement Character.getTotalForce
		throw new UnsupportedOperationException();
	}

	public void getTotalIntelligence() {
		// TODO - implement Character.getTotalIntelligence
		throw new UnsupportedOperationException();
	}

	public void getTotalAgility() {
		// TODO - implement Character.getTotalAgility
		throw new UnsupportedOperationException();
	}
        
        //Commentaire de test

	/**
	 * 
	 * @param character
	 */
	public void attack(GameCharacter character) {
		// TODO - implement Character.attack
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void startFight(GameCharacter c) {
		// TODO - implement Character.startFight
		throw new UnsupportedOperationException();
	}

	public void endFight() {
		// TODO - implement Character.endFight
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void talk(GameCharacter c) {
		// TODO - implement Character.talk
		throw new UnsupportedOperationException();
	}

}