package character;

import world.Place;
import game.Goal;
import java.util.*;

public abstract class GameCharacter {

    private Place currentPlace;
    private List<Goal> activableGoals;
    private GameCharacter fightingCharacter;
    public final String NAME;
    private final int BASE_HEALTH;
    private final int BASE_ARMOR;
    private final int BASE_FORCE;
    private final int BASE_INTELLIGENCE;
    private final int BASE_AGILITY;
    protected int currentHealth;

    
    protected List<String> dialogues;

    public GameCharacter(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_INTELLIGENCE, int BASE_AGILITY) {
        this.NAME = NAME;
        this.BASE_HEALTH = BASE_HEALTH;
        this.BASE_ARMOR = BASE_ARMOR;
        this.BASE_FORCE = BASE_FORCE;
        this.BASE_INTELLIGENCE = BASE_INTELLIGENCE;
        this.BASE_AGILITY = BASE_AGILITY;
        this.currentHealth = this.BASE_HEALTH;
    }

    public int getMaxHealth() 
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
    
    public boolean isAlive(){
        return (currentHealth > 0);
    }
    
    public void damage(int damageValue){
        
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public void setCurrentHealth(int health)
    {
        this.currentHealth += health;
    }

    /**
     * 
     * @param c
     */
    public void talk(GameCharacter c) {
            // TODO - implement Character.talk
            throw new UnsupportedOperationException();
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }
    
    
}