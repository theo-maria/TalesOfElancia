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

	public int getTotalHealth() 
        {
            return this.baseHealth;        
	}

	public int getTotalArmor() 
        {
            return this.baseArmor;
	}

	public int getTotalForce() 
        {
            return this.baseForce;
	}

	public int getTotalIntelligence() 
        {
            return this.baseIntelligence;
	}

	public int getTotalAgility() 
        {
            return this.baseAgility;
	}

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