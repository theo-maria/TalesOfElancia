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
public class Vilburas extends Enemy {
    
    public Vilburas() {
        super("Vilburas", "Maître des lieux", 100, 3, 20, 10, 20);
    }

    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Vilburas regagne de la vie !");
        currentHealth+=10;
    }
}
