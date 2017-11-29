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
    protected int currentHealth;
    protected int currentArmor;
    protected int currentForce;
    protected int currentIntelligence;
    protected int currentAgility;

    public GameCharacter(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_INTELLIGENCE, int BASE_AGILITY) {
        this.NAME = NAME;
        this.BASE_HEALTH = BASE_HEALTH;
        this.BASE_ARMOR = BASE_ARMOR;
        this.BASE_FORCE = BASE_FORCE;
        this.BASE_INTELLIGENCE = BASE_INTELLIGENCE;
        this.BASE_AGILITY = BASE_AGILITY;
    }

	public int getTotalHealth() 
        {
            return this.BASE_HEALTH;        
	}

	public int getTotalArmor() 
        {
            return this.BASE_ARMOR;
	}

	public int getTotalForce() 
        {
            return this.BASE_FORCE;
	}

	public int getTotalIntelligence() 
        {
            return this.BASE_INTELLIGENCE;
	}

	public int getTotalAgility() 
        {
            return this.BASE_AGILITY;
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