package character.hero;

import character.Enemy;
import character.Hero;
import java.util.Random;

/**
 * Classe du rôle Archer
 */
public class Archer extends Hero {
   
    /**
     * Pourcentage de chance d'effectuer un 'head shot'
     */
    private final int HEADSHOT_CHANCE;
    
    /**
     * Permet d'instancier un archer
     */
    public Archer() {
        super("Ellas", "Archer", 25, 1, 5, 30);
        HEADSHOT_CHANCE = 20;
    }

    /**
     * Permet d'attaquer un ennemi
     * @param enemy ennemi
     */
    @Override
    public void attack(Enemy enemy) {
        Random rd = new Random();
        if(rd.nextInt(99)+1 < HEADSHOT_CHANCE){
            System.out.println(NAME + " fait un headshot !");
            enemy.damage(this.getTotalForce() * 2);
        }
        else
            enemy.damage(this.getTotalForce());
    }
    
}