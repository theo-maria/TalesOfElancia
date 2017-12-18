/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import character.Enemy;
import character.Hero;
import java.util.Random;
import java.util.Scanner;

/**
 * Combat entre un ennemi et un héros
 */
public class Fight {
    
    /**
     * Le héros
     */
    Hero hero;
    /**
     * L'ennemi
     */
    Enemy enemy;
    
    /**
     * Permet d'instancier un combat
     * @param hero héros
     * @param enemy ennemi
     */
    public Fight(Hero hero, Enemy enemy)
    {
        this.hero = hero;
        this.enemy = enemy;
    }
    
    /**
     * Permet de démarrer le combat
     */
    public void startFight()
    {
        System.out.println("--- " + enemy.NAME + ": " + enemy.DESCRIPTION + " ---");
        System.out.println("\nQue le combat commence !!!\n");
        while(hero.isAlive() && enemy.isAlive())
        {
            System.out.println("----------------------------------------");
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
        if(hero.isAlive())
            System.out.println("\n" + hero.NAME + " remporte le combat !");
        else
            System.out.println("\n " + hero.NAME + " a péri face au terrible " + enemy.NAME);
        hero.clearBuffs();
    }
    
    /**
     * Permet de déterminer l'action du héros
     */
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
            System.out.println(hero.NAME + " attaque " + enemy.NAME);
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
    
    /**
     * Permet de déterminer l'action de l'ennemi
     */
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
