package character.hero;

import character.Enemy;
import character.Hero;

public class Paladin extends Hero {

	private final int HEALTH_GIVEN;

    public Paladin() {
        super("Sungwald Lighthawk", "Paladin", 75, 8, 5, 5);
        HEALTH_GIVEN = 2;
    }
    
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
        System.out.println(NAME + " se redonne " + HEALTH_GIVEN + " points de vie !");
    }
}