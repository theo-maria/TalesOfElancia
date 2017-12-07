/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.enemy;

import character.Enemy;

/**
 *
 * @author Theo
 */
public class Vilburas extends Enemy {
    
    public Vilburas(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        super("Vilburas", 100, 3, 20, 10);
    }
    
}
