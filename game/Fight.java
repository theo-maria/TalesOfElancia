/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import character.Enemy;
import character.Hero;
import item.Consumable;
import java.util.Random;
import java.util.Scanner;

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
        System.out.println("--- " + enemy.NAME + ": " + enemy.DESCRIPTION + " ---");
        System.out.println("\nQue le combat commence !!!\n");
        while(hero.isAlive() && enemy.isAlive())
        {
            System.out.println("");
            System.out.println(hero.NAME + ":");
            System.out.println("Vie: " + hero.getCurrentHealth());
            System.out.println(enemy.NAME + ":");
            System.out.println("Vie: " + enemy.getCurrentHealth());
            this.chooseHeroAction();
            System.out.println(hero.NAME + ":");
            System.out.println("Vie: " + hero.getCurrentHealth());
            System.out.println(enemy.NAME + ":");
            System.out.println("Vie: " + enemy.getCurrentHealth());
            if(enemy.isAlive())
                this.chooseEnemyAction(); 
        }
        hero.clearBuffs();
    }
    
    public void chooseHeroAction()
    {
        System.out.println("\n Au tour de " + hero.NAME + "\n");
        System.out.println("Voici vos choix: 1. Attaquer   2. Utiliser un objet");
        Scanner sc = new Scanner(System.in);
        int choixAction = 0;
        do{
            System.out.println("Entrez une valeur qui correspond:");
            choixAction = sc.nextInt();
        }while(choixAction != 1 && choixAction != 2);
        if(choixAction == 1){
            hero.attack(enemy);
        }
        else{
            int choixObjet;
            System.out.println("Choisissez un objet:");
            for(int i=0;i<hero.getConsumableItems().size();i++)
                System.out.println(i + ". " + hero.getConsumableItems().get(i).NAME);
            System.out.println("0. Retour");
            do{
                System.out.println("Entrez une valeur qui correspond:");
                choixObjet = sc.nextInt();
            }while(choixObjet < 0 || choixObjet > hero.getConsumableItems().size());
            if(choixObjet == 0)
                chooseHeroAction();
            else
                hero.useItem(hero.getConsumableItems().get(choixObjet+1));
        }
    }
    
    public void chooseEnemyAction()
    {
        Random specialAttackChance = new Random();
        System.out.println("\n Au tour de " + enemy.NAME + "\n");
        if(specialAttackChance.nextInt(99)+1 < enemy.getSPECIAL_ATTAQUE_CHANCE())
        {
            enemy.specialAttack(hero);
        }
        else
        {
            System.out.println("\n" + enemy.NAME + " lance une attaque de base \n");
            enemy.attack(hero);
        }
    }
}
