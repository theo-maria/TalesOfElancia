/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.enemy;

import character.Enemy;
import character.Hero;

/**
 * Classe de Gan, un des ennemis du jeu
 */
public class Gan extends Enemy {
    
    /**
     * Permet d'instancier Gan
     */
    public Gan() {
        super("Gan", "Maître de la foudre", 70, 3, 6, 3, 15);
    }

    /**
     * Permet d'effectuer une attaque spéciale sur le héros
     * @param hero le héros
     */
    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Gan vous frappe de sa foudre puissante !");
        hero.damage(getTotalForce()+5);
    }
    
}
