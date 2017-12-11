/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.enemy;

import character.Enemy;
import character.Hero;

/**
 *
 * @author Theo
 */
public class Gotza extends Enemy {
    
    private int agility_bonus;
    
    public Gotza() {
        super("Gotza", "Maître de la nuit", 50, 3, 7, 10, 10);
        agility_bonus = 0;
    }

    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Gotza assombri la pièce, il est plus difficile à atteindre !");
        agility_bonus += 10;
    }
    
    @Override
    public int getTotalAgility() 
    {
        return this.BASE_AGILITY + agility_bonus;
    }
    
}
