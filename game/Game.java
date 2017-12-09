package game;

import character.Enemy;
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
    private Boolean quittingGame;

    public Game() {
        commands = new HashMap<>();
        commands.put("go", "Permet de se rendre dans un lieu voisin - Utilisation: go direction");
        commands.put("help", "Affiche la liste des commandes");
        commands.put("look", "Permet de regarder autour de vous, ou de regarder un objet en particulier - Utilisation: look [objet]");
        commands.put("take", "Permet de ramasser un objet - Utilisation: take object");
        commands.put("quit", "Permet de quitter la partie");
        commands.put("use", "Permet de voir l'inventaire du héros, ou d'utiliser un objet, ou deux objets ensemble - Utilisation: use [objet1] [objet2]");
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
        List<String> command = getUserCommand();
        
        if(command.get(0).equals("go")){
            
        }
        else if(command.get(0).equals("help")){
            if(command.size() == 1){
                System.out.println("Voici la liste des commandes utilisables:");
                for(Map.Entry<String,String> c : commands.entrySet()){
                    System.out.println("- " + c.getKey() + " : " + c.getValue());
                }
            }
            else
                System.out.println("Utilisation : help");
            
        }
        else if(command.get(0).equals("look")){
            switch (command.size()) {
                // Un seul paramètre
                case 1:
                    System.out.println("Vous voyez:");
                    for(Item i : ((GameCharacter)selectedHero).getCurrentPlace().getItems()){
                        System.out.println("- " + i.NAME);
                    }   break;
                // Deux paramètres
                case 2:
                    Item item = null;
                    List<Item> itemList = ((GameCharacter)selectedHero).getCurrentPlace().getItems();
                    item = Item.getItemByName(itemList,command.get(1));
                    if(item == null)
                        System.out.println("Il n'y a pas d'objet '" + command.get(1) + "' dans la pièce");
                    else
                        System.out.println(item.NAME + " : " + item.DESCRIPTION);
                    break;
                default:
                    System.out.println("Utilisation: look [objet]");
                    break;
            }
        }
        else if(command.get(0).equals("take")){
            switch(command.size()){
                case 2:
                    Item item = null;
                    List<Item> items = ((GameCharacter)selectedHero).getCurrentPlace().getItems();
                    item = Item.getItemByName(items, command.get(1));
                    if(item == null)
                        System.out.println("Il n'y a pas d'objet '" + command.get(1) + "' dans la pièce");
                    else{
                        selectedHero.takeItem(item);
                        System.out.println("Vous ramassez l'objet '" + item.NAME + "'");
                    }
                    break;
                default:
                    System.out.println("Utilisation : take [objet]");
            }
        }
        else if(command.get(0).equals("quit")){
            if(command.size() == 1)
            {
                System.out.println("Voulez-vous vraiment quitter ? 1 : Oui , 2 : Non");
                Scanner sc = new Scanner(System.in);
                int choice;
                do{
                    choice = sc.nextInt();
                }while(choice != 1 && choice != 2);
                if(choice == 1)
                    quittingGame = true;
            }
            else
            {
                System.out.println("Utilisation : quit");
            }
            
        }
        else if(command.get(0).equals("use")){
            switch(command.size()){
                case 1:
                    System.out.println("Voici votre inventaire:");
                    for(Item i : selectedHero.getInventory())
                        System.out.println("- " + i.NAME + " : " + i.DESCRIPTION);
                    break;
                case 2:
                    Item item = Item.getItemByName(selectedHero.getInventory(), command.get(1));
                    if(item != null){
                        selectedHero.useItem(item);
                        System.out.println("Vous utilisez l'objet '" + item.NAME + "'");
                    }
                    else{
                        System.out.println("Vous ne possédez pas l'objet '" + command.get(1) + "'");
                    }
                    break;
                case 3:
                    Item item1 = Item.getItemByName(selectedHero.getInventory(), command.get(1));
                    Item item2 = Item.getItemByName(selectedHero.getInventory(), command.get(2));
                    if(item1 != null && item2 != null){
                        selectedHero.useItem(item1, item2);
                        System.out.println("Vous utilisez l'objet '" + item1.NAME + "' avec l'objet '" + item2.NAME +"'");
                    }
                    else if(item1 == null && item2 == null)
                        System.out.println("Vous ne possédez pas les objets '" + command.get(1) + "' et '" + command.get(2) + "'");
                    else if(item1 == null)
                        System.out.println("Vous ne possédez pas l'objet '" + command.get(1) + "'");
                    else if(item2 == null)
                        System.out.println("Vous ne possédez pas l'objet '" + command.get(2) + "'");
                default:
                    System.out.println("Utilisation : use [objet1] [objet2]");
                    break;
            }
        }
        else if(command.get(0).equals("fight")){
            switch(command.size()){
                case 2:
                    Enemy enemy = null;
                    for(Enemy e : selectedHero.getCurrentPlace().getEnemies()){
                        if(e.NAME.equals(command.get(1)))
                            enemy = e;
                    }
                    if(enemy != null){
                        System.out.println("Vous engagez un combat avec " + enemy.NAME);
                        selectedHero.fight(enemy);
                    }
                    else
                        System.out.println("Il n'y a pas d'enemi nommé '" + command.get(1) + "' aux alentours");
                    break;
                default:
                    System.out.println("Utilisation : fight ennemi");
            }
        }
        else if(command.get(0).equals("talk")){
            if(command.size() == 2){
                GameCharacter character = null;
                for(GameCharacter c : selectedHero.getCurrentPlace().getCharacters()){
                   if(c.NAME.equals(command.get(1)))
                       character = c;
                }
                if(character != null){
                    System.out.println("Vous engagez la conversation avec '" + character.NAME + "'");
                    selectedHero.talk(character);
                }
                else
                    System.out.println("Il n'y a pas de personne nommée '" + command.get(1) + "' aux alentours");
            }
            else{
                System.out.println("Utilisation : talk personnage");
            }
        }
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