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
public class Gan extends Enemy {
    
    public Gan() {
        super("Gan", "Maître de la foudre", 70, 4, 5, 3, 15);
    }

    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Gan vous frappe de sa foudre puissante !");
        hero.damage(getTotalForce()+5);
    }
    
}
