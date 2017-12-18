/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.enemy;

import character.Enemy;
import character.Hero;

/**
 * Classe de Gotza, un des ennemis du jeu
 */
public class Gotza extends Enemy {
    
    /**
     * Bonus d'agilité de l'attaque spéciale de Gotza
     */
    private int agility_bonus;
    
    /**
     * Permet d'instancier Gotza
     */
    public Gotza() {
        super("Gotza", "Maître de la nuit", 50, 2, 7, 10, 10);
        agility_bonus = 0;
    }

    /**
     * Permet d'effectuer une attaque spéciale sur le héros
     * @param hero le héros
     */
    @Override
    public void specialAttack(Hero hero) {
        System.out.println("Attaque spéciale: Gotza assombri la pièce, il est plus difficile à atteindre !");
        agility_bonus += 10;
    }
    
    /**
     * Permet de retourner l'agilité de Gotza en prenant en compte son bonus
     * @return agilité totale
     */
    @Override
    public int getTotalAgility() 
    {
        return this.BASE_AGILITY + agility_bonus;
    }
    
}
