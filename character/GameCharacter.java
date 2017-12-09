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
    protected int dialogueCount;

    public GameCharacter(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        this.NAME = NAME;
        this.BASE_HEALTH = BASE_HEALTH;
        this.BASE_ARMOR = BASE_ARMOR;
        this.BASE_FORCE = BASE_FORCE;
        this.BASE_AGILITY = BASE_AGILITY;
        this.currentHealth = this.BASE_HEALTH;
        
        activableGoals = new ArrayList<>();
        dialogues = new ArrayList<>();
        dialogueCount = 0;
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

    public void talk(GameCharacter c) {
        if(c.isTalkable()){
            String dialogue = null;
            dialogue = c.getNextDialogue();
            if(dialogue != null)
                System.out.println(NAME + ": \"" + dialogue + "\"");
        }
        else{
            System.out.println("Pas de réponse...");
        }
    }
    
    public String getNextDialogue(){
        if(isTalkable()){
            if(dialogueCount == dialogues.size()-1)
                return dialogues.get(dialogueCount);
            else{
                dialogueCount++;
                return dialogues.get(dialogueCount);
            }
        }
        return null;
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