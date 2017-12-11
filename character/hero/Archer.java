package character.hero;

import character.Enemy;
import character.Hero;
import java.util.Random;

public class Archer extends Hero {
   
    private final int HEADSHOT_CHANCE;
    
    public Archer() {
        super("Ellas", "Archer", 25, 3, 5, 30);
        HEADSHOT_CHANCE = 20;
    }

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