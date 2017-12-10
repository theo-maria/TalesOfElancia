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
public class Beelzum extends Enemy {
    
    public Beelzum() {
        super("Beelzum", "Maître des tempêtes", 60, 6, 9, 15, 15);
    }

    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Beelzum fait 2 attaques d'affilé !");
        hero.damage(getTotalForce());
        hero.damage(getTotalForce());
    }
    
}
