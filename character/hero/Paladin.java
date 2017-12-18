package character.hero;

import character.Enemy;
import character.Hero;

/**
 * Classe du rôle Paladin
 */
public class Paladin extends Hero {
    /**
     * Vie donnée à chaque tour
     */
    private final int HEALTH_GIVEN;

    /**
     * Permet d'instancier un Paladin
     */
    public Paladin() {
        super("Sungwald Lighthawk", "Paladin", 75, 4, 5, 5);
        HEALTH_GIVEN = 2;
    }
    
    /**
     * Permet d'attaquer un ennemi, puis de se redonner de la vie à chaque tour
     * @param enemy ennemi
     */
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
        System.out.println(NAME + " se redonne " + HEALTH_GIVEN + " points de vie !");
    }
}