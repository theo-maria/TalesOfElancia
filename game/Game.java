package game;

import character.GameCharacter;
import character.hero.Archer;
import world.Place;
import character.Hero;
import character.hero.Paladin;
import character.hero.Sorcerer;
import character.hero.Thief;
import character.hero.Warrior;
import item.Item;
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
        commands.put("use", "Permet de voir l'inventaire du héros, ou d'utiliser un objet, ou deux objets ensemble - Utilisation: use [object1] [object2]");
        commands.put("fight", "Permet d'engager un combat avec un ennemi - Utilisation: fight ennemi");
        commands.put("talk", "Permet de parler avec un personnage - Utilisation: talk personnage");
        
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
        worldPlaces.add(new Place("Repère de Gotza"));
        worldPlaces.add(new Place("Repère de Beelzum"));
        worldPlaces.add(new Place("Repère de Gan"));
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
        List<String> commande = getUserCommand();
        
        if(commande.get(0).equals("go")){
            
        }
        else if(commande.get(0).equals("help")){
            System.out.println("Voici la liste des commandes utilisables:");
            for(Map.Entry<String,String> c : commands.entrySet()){
                System.out.println("- " + c.getKey() + " : " + c.getValue());
            }
        }
        else if(commande.get(0).equals("look")){
            // Un seul paramètre
            if(commande.size() == 1){
                System.out.println("Vous voyez:");
                for(Item i : ((GameCharacter)selectedHero).getCurrentPlace().getItems()){
                    System.out.println("- " + i.NAME);
                }
            }
            // Deux paramètres
            else{
                Item item = null;
                
                for(Item i : ((GameCharacter)selectedHero).getCurrentPlace().getItems()){
                    if(i.NAME == commande.get(1))
                        item = i;
                }
                
                if(item == null)
                    System.out.println("Il n'y a pas d'objet '" + commande.get(1) + "' dans la pièce");
                else
                    System.out.println(item.NAME + " : " + item.DESCRIPTION);
            }
        }
        else if(commande.get(0).equals("take"))
            ;
        else if(commande.get(0).equals("quit"))
            ;
        else if(commande.get(0).equals("use"))
            ;
        else if(commande.get(0).equals("fight"))
            ;
        else if(commande.get(0).equals("talk"))
            ;
    }
    
    public List<String> getUserCommand(){
        List<String> chosenCommand = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String textCommand = "";
        String firstWord = "";
        do{
            System.out.println("Entrez une commande valide:");
            textCommand = sc.nextLine();
            firstWord = textCommand.split(" ", 2)[0];
            if(!commands.containsKey(firstWord))
                System.out.println("Commande '" + firstWord + "' non reconnue");
        }while(!commands.containsKey(firstWord));
        
        for(String word : textCommand.split(" ")){
            chosenCommand.add(word);
        }
        return chosenCommand;
    }
}