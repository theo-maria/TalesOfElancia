/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.enemy;

import character.Enemy;
import character.Hero;

/**
 * Classe de Beelzum, un des ennemis du jeu
 */
public class Beelzum extends Enemy {
    
    /**
     * Permet d'instancier Beelzum
     */
    public Beelzum() {
        super("Beelzum", "Maître des tempêtes", 60, 2, 9, 15, 15);
    }

    /**
     * Permet d'effectuer une attaque spéciale sur le héros
     * @param hero le héros
     */
    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Beelzum fait 2 attaques d'affilé !");
        hero.damage(getTotalForce());
        hero.damage(getTotalForce());
    }
    
}
