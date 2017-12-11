package character.hero;

import character.Enemy;
import character.Hero;

/**
 * Classe du rôle Guerrier
 */
public class Warrior extends Hero {

	private final int FURY_STEP;
        private final int FURY_DAMAGE;

    /**
     * Permet d'instancier un guerrier
     */
    public Warrior() {
        super("Gundir", "Guerrier", 50, 5, 10, 15);
        FURY_STEP = 15;
        FURY_DAMAGE = 5;
    }
    
    /**
     * Permet d'attaquer un ennemi
     * @param enemy ennemi
     */
    @Override
    public void attack(Enemy enemy){
        if(currentHealth <= FURY_STEP){
            System.out.println("Rage du guerrier: " + NAME + " voit ses dégâts considérablement augmenter !");
            enemy.damage(this.getTotalForce() + FURY_DAMAGE);
        }
    }
}