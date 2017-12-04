/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import character.GameCharacter;
import character.enemy.Enemy;
import character.hero.Hero;

/**
 *
 * @author Theo
 */
public class Fight {
    Hero hero;
    Enemy enemy;
    public Fight(Hero hero, Enemy enemy){
        this.hero = hero;
        this.enemy = enemy;
    }
    
    public void startFight(){
        while(hero.isAlive() && enemy.isAlive()){
            System.out.println(hero.NAME + ":");
            System.out.println("Vie: " + hero.getCurrentHealth());
            System.out.println(enemy.NAME + ":");
            System.out.println("Vie: " + enemy.getCurrentHealth());
            
        }
    }
    
    public void chooseHeroAction(){
        
    }
    
    public void chooseEnemyAction(){
        
    }
}
