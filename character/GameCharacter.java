package character;

import world.Place;
import game.Goal;
import java.util.*;

public abstract class GameCharacter {

    protected Place currentPlace;
    protected List<Goal> activableGoals;
    public final String NAME;
    protected final int BASE_HEALTH;
    protected final int BASE_ARMOR;
    protected final int BASE_FORCE;
    protected final int BASE_AGILITY;
    protected int currentHealth;
    protected List<String> dialogues;

    public GameCharacter(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        this.NAME = NAME;
        this.BASE_HEALTH = BASE_HEALTH;
        this.BASE_ARMOR = BASE_ARMOR;
        this.BASE_FORCE = BASE_FORCE;
        this.BASE_AGILITY = BASE_AGILITY;
        this.currentHealth = this.BASE_HEALTH;
        
        activableGoals = new ArrayList<>();
        dialogues = new ArrayList<>();
    }
    
    public void talk(Hero heroTalking){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Appuyez sur Entrée pour lire les dialogues ---");
        while(!sc.nextLine().equals("")){}
        for(String texte : dialogues){
            System.out.println("- " + NAME + ": " + texte);
            while(!sc.nextLine().equals("")){}
        }
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

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
    }

    public boolean isTalkable() {
        return !dialogues.isEmpty();
    }
    
    public void addActivableGoal(Goal goal){
        activableGoals.add(goal);
    }
}