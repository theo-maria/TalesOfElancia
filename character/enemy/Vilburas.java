/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.enemy;

import character.Enemy;
import character.Hero;

/**
 * Classe de Vilburas, un des ennemis du jeu
 */
public class Vilburas extends Enemy {
    
    /**
     * Le bonus de heal donné par la compétence spéciale de Vilburas
     */
    private final int HEAL_BONUS;
    
    /**
     * Permet d'instancier Vilburas
     */
    public Vilburas() {
        super("Vilburas", "Maître des lieux", 100, 4, 20, 10, 20);
        HEAL_BONUS = 10;
    }

    /**
     * Permet d'effectuer une attaque spéciale sur le héros
     * @param hero le héros
     */
    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Vilburas regagne de la vie !");
        currentHealth+=HEAL_BONUS;
    }
}
