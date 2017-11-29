package game;

import character.GameCharacter;
import character.hero.Archer;
import world.Place;
import character.hero.Hero;
import character.hero.Paladin;
import character.hero.Sorcerer;
import character.hero.Thief;
import character.hero.Warrior;
import java.util.*;

public class Game {

    private List<Goal> gameGoals;
    private List<Hero> selectableHeroes;
    Collection<Place> worldPlaces;
    private Hero selectedHero;

    public Game() {
        selectableHeroes = new ArrayList<>();
        selectableHeroes.add(new Warrior());
        selectableHeroes.add(new Sorcerer());
        selectableHeroes.add(new Paladin());
        selectableHeroes.add(new Archer());
        selectableHeroes.add(new Thief());
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.chooseCharacter();
    }
    
    

    public void chooseCharacter() {
        System.out.println("Voici la liste des personnages:");
        for(int i=0;i<selectableHeroes.size();i++){
            System.out.println((i+1) + ". " + selectableHeroes.get(i).NAME + " (" + selectableHeroes.get(i).getCLASS_NAME() + ")");
        }
        int chosenNumber = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Choisissez un nombre qui correspond: ");
            chosenNumber = sc.nextInt();
        }while(chosenNumber < 1 || chosenNumber > selectableHeroes.size());
        selectedHero = selectableHeroes.get(chosenNumber-1);
        
    }

    public void startFight(GameCharacter charac1, GameCharacter charac2){

    }
}