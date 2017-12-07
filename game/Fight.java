/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import character.Enemy;
import character.Hero;
import java.util.Random;

/**
 *
 * @author Theo
 */
public class Fight {
    
    Hero hero;
    Enemy enemy;
    
    public Fight(Hero hero, Enemy enemy)
    {
        this.hero = hero;
        this.enemy = enemy;
    }
    
    public void startFight()
    {
        System.out.println("\n Que le combat commence !!! \n");
        while(hero.isAlive() && enemy.isAlive())
        {
            System.out.println(hero.NAME + ":");
            System.out.println("Vie: " + hero.getCurrentHealth());
            System.out.println(enemy.NAME + ":");
            System.out.println("Vie: " + enemy.getCurrentHealth());
            this.chooseHeroAction();
            System.out.println(hero.NAME + ":");
            System.out.println("Vie: " + hero.getCurrentHealth());
            System.out.println(enemy.NAME + ":");
            System.out.println("Vie: " + enemy.getCurrentHealth());
            this.chooseEnemyAction(); 
        }
    }
    
    public void chooseHeroAction()
    {
        System.out.println("\n Au tour de " + hero.NAME + "\n");
        
    }
    
    public void chooseEnemyAction()
    {
        Random specialAttackChance = new Random();
        System.out.println("\n Au tour de " + enemy.NAME + "\n");
        if(specialAttackChance.nextInt(6)%5 == 0)
        {
            //specialAttack
        }
        else
        {
            System.out.println("\n" + enemy.NAME + " lance une attaque de base \n");
            hero.setCurrentHealth(hero.getCurrentHealth() + hero.getTotalArmor() - enemy.getTotalForce());
        }
    }
}
