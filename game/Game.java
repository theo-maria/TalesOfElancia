package game;

import character.GameCharacter;
import character.hero.Archer;
import world.Place;
import character.Hero;
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
    private Map<String,String> commands;

    public Game() {
        commands = new HashMap<>();
        commands.put("go", "Permet de se rendre dans un lieu voisin - Utilisation: go direction");
        commands.put("help", "Affiche la liste des commandes");
        commands.put("look", "Permet de regarder autour de vous, ou de regarder un objet en particulier - Utilisation: look [object]");
        commands.put("take", "Permet de ramasser un objet - Utilisation: take object");
        commands.put("quit", "Permet de quitter la partie");
        commands.put("use", "Permet d'utiliser un objet, ou deux objets ensemble - Utilisation: use object1 [object2]");
        commands.put("fight", "Permet d'engager un combat avec un ennemi - Utilisation: fight ennemi");
        
        selectableHeroes = new ArrayList<>();
        selectableHeroes.add(new Warrior());
        selectableHeroes.add(new Sorcerer());
        selectableHeroes.add(new Paladin());
        selectableHeroes.add(new Archer());
        selectableHeroes.add(new Thief());
        
        worldPlaces = new ArrayList<>();
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
        game.userAction();
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
    
    public void userAction(){
        System.out.println("Que faites-vous ?");
        Scanner sc = new Scanner(System.in);
        String textCommand = "";
        do{
            System.out.println("Entrez une commande valide:");
            textCommand = sc.nextLine();
            
        }while(!commands.containsKey(textCommand.split(" ", 2)[0]));
        
    }
}