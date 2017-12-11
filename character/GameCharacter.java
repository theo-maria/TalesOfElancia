package character;

import world.Place;
import game.Goal;
import java.util.*;

/**
 * Classe correspondant à un personnage du jeu
 */
public abstract class GameCharacter {

    /**
     * Lieu dans lequel se situe actuellement le personnage
     */
    protected Place currentPlace;

    /**
     * Liste des objectifs de l'intrigue auxquels le personnage est lié
     */
    protected List<Goal> activableGoals;

    /**
     * Nom du personnage
     */
    public final String NAME;

    /**
     * Vie de base
     */
    protected final int BASE_HEALTH;

    /**
     * Armure de base
     */
    protected final int BASE_ARMOR;

    /**
     * Force de base
     */
    protected final int BASE_FORCE;

    /**
     * Agilité de base
     */
    protected final int BASE_AGILITY;

    /**
     * Vie actuelle
     */
    protected int currentHealth;

    /**
     * Liste des dialogues du personnages
     */
    protected List<String> dialogues;

    /**
     * Permet d'instancier un personnage
     * @param NAME nom
     * @param BASE_HEALTH vie de base
     * @param BASE_ARMOR armure de base
     * @param BASE_FORCE force de base
     * @param BASE_AGILITY agilité de base
     */
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
    
    /**
     * Permet de répondre à un héros
     * @param heroTalking héros
     */
    public void talk(Hero heroTalking){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Appuyez sur Entrée pour lire les dialogues ---");
        while(!sc.nextLine().equals("")){}
        for(String texte : dialogues){
            System.out.println("- " + NAME + ": " + texte);
            while(!sc.nextLine().equals("")){}
        }
    }

    /**
     * Permet de savoir la vie maximale du personnage
     * @return vie maximale
     */
    public int getMaxHealth() 
    {
        return this.BASE_HEALTH;        
    }

    /**
     * Permet de savoir l'armure maximale du personnage
     * @return armure maximale
     */
    public int getTotalArmor()
    {
        return this.BASE_ARMOR;
    }

    /**
     * Permet de savoir la force maximale du personnage
     * @return force maximale
     */
    public int getTotalForce() 
    {
        return this.BASE_FORCE;
    }
    
    /**
     * Permet de savoir l'agilité maximale du personnage
     * @return agilité maximale
     */
    public int getTotalAgility() 
    {
        return this.BASE_AGILITY;
    }
    
    /**
     * Permet de savoir si le personnage est vivant
     * @return true si il est vivant, sinon false
     */
    public boolean isAlive(){
        return (currentHealth > 0);
    }
    
    /**
     * Permet de faire des dégâts au personnage
     * @param damageValue valeur des dégâts
     */
    public void damage(int damageValue){
        Random r = new Random();
        int chanceEsquive = r.nextInt(99)+1;
        if(chanceEsquive <= getTotalAgility())
            System.out.println(NAME + " esquive le coup !");
        else{
            int viePerdue = damageValue - getTotalArmor();
            if(viePerdue < 0)
                viePerdue = 0;
            System.out.println(NAME + " perd " + viePerdue + " points de vie");
            currentHealth-=viePerdue;
        }
    }

    /**
     * Permet de savoir la vie actuelle du personnage
     * @return vie actuelle
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Permet de savoir le lieu actuel du personnage
     * @return lieu actuel
     */
    public Place getCurrentPlace() {
        return currentPlace;
    }

    /**
     * Permet de définir le lieu où se trouve le personnage
     * @param currentPlace lieu
     */
    public void setCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
    }

    /**
     * Permet de savoir si il est possible de parler au personnage
     * @return true si il possède des dialogues, sinon false
     */
    public boolean isTalkable() {
        return !dialogues.isEmpty();
    }
    
    /**
     * Permet d'ajouter un objectif lié au joueur
     * @param goal objectif
     */
    public void addActivableGoal(Goal goal){
        activableGoals.add(goal);
    }
    
    /**
     * Permet de donner (ou enlever) de la vie à un personnage
     * @param healValue valeur de vie
     */
    public void heal(int healValue){
        if(currentHealth+healValue > getMaxHealth())
            currentHealth = getMaxHealth();
        else if(currentHealth+healValue < 0)
            currentHealth = 0;
        else
            currentHealth+=healValue;
    }
}