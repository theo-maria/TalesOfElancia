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
    private List<Place> worldPlaces;
    private Place defaultPlace;
    private Hero selectedHero;

    public Game() {
        selectableHeroes = new ArrayList<>();
        selectableHeroes.add(new Warrior());
        selectableHeroes.add(new Sorcerer());
        selectableHeroes.add(new Paladin());
        selectableHeroes.add(new Archer());
        selectableHeroes.add(new Thief());
        
        defaultPlace = new Place("Prison");
        worldPlaces.add(defaultPlace);
        Place longCorridor = new Place("Long Couloir");
        worldPlaces.add(longCorridor);
        Place vilburasChamber = new Place("Chambre de Vilburas");
        worldPlaces.add(vilburasChamber);
        worldPlaces.add(new Place("Repère de [BOSS 1]"));
        worldPlaces.add(new Place("Repère de [BOSS 2]"));
        worldPlaces.add(new Place("Repère de [BOSS 3]"));
        Place enigmaticRoom = new Place("Pièce énigmatique");
        worldPlaces.add(enigmaticRoom);
        Place darkRoom = new Place("Pièce sombre");
        worldPlaces.add(darkRoom);
        Place stairs = new Place("Escalier");
        worldPlaces.add(stairs);
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
        System.out.println("Vous avez choisi d'incarner " + selectedHero.NAME);
    }

    public static void startFight(GameCharacter charac1, GameCharacter charac2){
        
    }
}