package character;

import world.Place;
import game.Goal;
import java.util.*;

public abstract class GameCharacter {

    private Place currentPlace;
    private Collection<Goal> activableGoals;
    private GameCharacter fightingCharacter;
    private final String NAME;
    private final int BASE_HEALTH;
    private final int BASE_ARMOR;
    private final int BASE_FORCE;
    private final int BASE_INTELLIGENCE;
    private final int BASE_AGILITY;

    public GameCharacter(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_INTELLIGENCE, int BASE_AGILITY) {
        this.NAME = NAME;
        this.BASE_HEALTH = BASE_HEALTH;
        this.BASE_ARMOR = BASE_ARMOR;
        this.BASE_FORCE = BASE_FORCE;
        this.BASE_INTELLIGENCE = BASE_INTELLIGENCE;
        this.BASE_AGILITY = BASE_AGILITY;
    }
        
        

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