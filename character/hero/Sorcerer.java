package character.hero;

import character.Enemy;
import character.Hero;
import java.util.Random;

/**
 * Classe du rôle sorcier
 */
public class Sorcerer extends Hero {
    
    /**
     * Pourcentage de chance que le familier du sorcier attaque
     */
    private final int COMPANION_ATTACK_CHANCE;
    /**
     * Dégâts effectués par le familier
     */
    private final int COMPANION_ATTACK_DAMAGE;

    /**
     * Permet d'instancier un sorcier
     */
    public Sorcerer() {
        super("Sagius", "Sorcier", 25, 2, 8, 20);
        COMPANION_ATTACK_CHANCE = 15;
        COMPANION_ATTACK_DAMAGE = 10;
    }
    
    /**
     * Permet d'attaquer un ennemi
     * @param enemy ennemi
     */
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
        Random rd = new Random();
        if(rd.nextInt(99)+1 < COMPANION_ATTACK_CHANCE){
            System.out.println("Le fidèle aigle magique de " + NAME + " est invoqué et attaque l'ennemi !");
            enemy.damage(COMPANION_ATTACK_DAMAGE);
        }
    }
}