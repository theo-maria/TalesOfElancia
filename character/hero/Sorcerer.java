package character.hero;

import character.Enemy;
import character.Hero;
import java.util.Random;

public class Sorcerer extends Hero {

	private final int COMPANION_ATTACK_CHANCE;
        private final int COMPANION_ATTACK_DAMAGE;

    public Sorcerer() {
        super("Sagius", "Sorcier", 25, 5, 8, 20);
        COMPANION_ATTACK_CHANCE = 15;
        COMPANION_ATTACK_DAMAGE = 10;
    }
    
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