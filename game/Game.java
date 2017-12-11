package game;

import character.Enemy;
import character.GameCharacter;
import character.hero.Archer;
import world.Place;
import character.Hero;
import character.enemy.Beelzum;
import character.enemy.Gan;
import character.enemy.Gotza;
import character.enemy.Vilburas;
import character.hero.Paladin;
import character.hero.Sorcerer;
import character.hero.Thief;
import character.hero.Warrior;
import character.npc.Guard;
import character.npc.Merchant;
import character.npc.OldWoman;
import item.Chest;
import item.Item;
import item.Key;
import item.SoldItem;
import item.ThrowableItem;
import item.UnatainableKey;
import item.equipment.Armor;
import item.equipment.Glasses;
import item.equipment.Ring;
import java.util.*;
import world.BigDoor;
import world.Exit;
import world.LockedExit;
import world.PuzzleDoor;

public class Game {
    /**
     * Objectif principal de la partie.
     */
    private Goal mainGoal;
    /**
     * Liste des objectifs de la partie.
     */
    private List<Goal> gameGoals;
    /**
     * Liste des héros sélectionnables par le joueur.
     */
    private List<Hero> selectableHeroes;
    /**
     * Liste des lieux du jeu.
     */
    private List<Place> worldPlaces;
    /**
     * Lieu par défaut, celui dans lequel le joueur commence la partie.
     */
    private Place defaultPlace;
    /**
     * Héros sélectionné par le joueur.
     */
    private Hero selectedHero;
    /**
     * Liste des commandes utilisateur, ainsi que leur descriptif.
     */
    private Map<String,String> commands;
    /**
     * Indique si le jeu est sur le point d'être quitté.
     */
    private Boolean quittingGame;

    
    /**
     * Programme principal, démarre une nouvelle partie.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("======= BIENVENUE DANS TALES OF ELANCIA =======");
        Game game = new Game();
        game.chooseCharacter();
        game.introScene();
        while(!game.isQuitting() && !game.isMainGoalAchieved() && game.isHeroAlive())
            game.userAction();
        if(!game.isHeroAlive())
            System.out.println("Vous avez échoué. GAME OVER.");
        else if(game.isMainGoalAchieved())
            System.out.println("Félicitations ! Vous avez sauvé le monde de l'ignoble Vilburas !");
    }
    
    /**
     * Constructeur d'une partie. Instancie tous les objets nécessaires au fonctionnement de la partie.
     */
    public Game() {
        quittingGame = false;
        
        // Ajout des différentes commandes utilisateur et leurs descriptions respectives
        commands = new HashMap<>();
        commands.put("go", "Permet de se rendre dans un lieu voisin - Utilisation: go direction [key]");
        commands.put("help", "Affiche la liste des commandes");
        commands.put("look", "Permet de regarder autour de vous, ou de regarder un objet en particulier - Utilisation: look [objet]");
        commands.put("take", "Permet de ramasser un objet - Utilisation: take object");
        commands.put("quit", "Permet de quitter la partie");
        commands.put("use", "Permet de voir l'inventaire du héros, ou d'utiliser un objet, ou deux objets ensemble - Utilisation: use [objet1] [objet2]");
        commands.put("fight", "Permet d'engager un combat avec un ennemi - Utilisation: fight ennemi");
        commands.put("talk", "Permet de parler avec un personnage - Utilisation: talk personnage");
        
        // Ajout des héros sélectionnables
        selectableHeroes = new ArrayList<>();
        selectableHeroes.add(new Warrior());
        selectableHeroes.add(new Sorcerer());
        selectableHeroes.add(new Paladin());
        selectableHeroes.add(new Archer());
        selectableHeroes.add(new Thief());
        
        // Ajout des objectifs du jeu
        gameGoals = new ArrayList<>();
        Goal killVilburas = new Goal("Tuer Vilburas");
        mainGoal = killVilburas;
        gameGoals.add(killVilburas);
        Goal killGan = new Goal("Tuer Gan");
        gameGoals.add(killGan);
        Goal killBeelzum = new Goal("Tuer Beelzum");
        gameGoals.add(killBeelzum);
        Goal killGotza = new Goal("Tuer Gotza");
        gameGoals.add(killGotza);
        
        // Ajout des lieux du jeu
        worldPlaces = new ArrayList<>();
        defaultPlace = new Place("Prison", "Vous avez été placé dans cette cellule humide.\nUn garde est là mais ne vous regarde pas.\nSur le mur est gravé '1337.'");
        worldPlaces.add(defaultPlace);
        Place longCorridor = new Place("Long couloir", "Une fois sorti de la cellule, vous errez dans ce long couloir "
                + "pendant des heures et des heures. Vous commencez à perdre espoir quand, tout à coup, "
                + "une vieille dame apparaît...");
        worldPlaces.add(longCorridor);
        Place hall = new Place("Hall Central", "Cette gigantesque pièce semble être le centre du château.");
        worldPlaces.add(hall);
        Place gotzaRoom = new Place("Repère de Gotza", "Repère de Gotza, maître de la nuit");
        worldPlaces.add(gotzaRoom);
        Place beelzumRoom = new Place("Repère de Beelzum", "Repère de Beelzum, maître des tempêtes");
        worldPlaces.add(beelzumRoom);
        Place ganRoom = new Place("Repère de Gan", "Repère de Gan, maître de la foudre");
        worldPlaces.add(ganRoom);
        Place vilburasChamber = new Place("Chambre de Vilburas", "Vous êtes dans la chambre du maître des lieux. Cette fois, pas de deuxième chance. Soyez sûr d'être prêt !");
        worldPlaces.add(vilburasChamber);
        Place enigmaticRoom = new Place("Pièce énigmatique", "Cette pièce vous donne un terrible mal de crâne.");
        worldPlaces.add(enigmaticRoom);
        Place darkRoom = new Place("Pièce sombre", "Même un chat n'oserait pas s'aventurer dans un lieu aussi sombre...");
        darkRoom.setDarkness(true);
        worldPlaces.add(darkRoom);
        Place stairs = new Place("Escalier", "Cet escalier en colimasson menne au sommet de la tour.");
        worldPlaces.add(stairs);
        Place secretShop = new Place("Magasin Secret", "Un magasin caché dans le château. Qui peut bien venir faire ses emplettes ici ?");
        worldPlaces.add(secretShop);
        
        // Ajout des liens entre les lieux (sorties et clés)
        Item hook = new Item("crochet","Un crochet. Qui a pu laisser un tel objet ici ?",0,0,0,0);
        Key prisonKey = new UnatainableKey("cle_prison", "Semble pouvoir ouvrir la cellule", hook);
        defaultPlace.addExit(new LockedExit(longCorridor, "sortie", prisonKey));
        
        longCorridor.addExit(new Exit(defaultPlace, "prison"));
        
        hall.addExit(new Exit(longCorridor, "couloir"));
        hall.addExit(new Exit(enigmaticRoom, "piece1"));
        hall.addExit(new Exit(stairs, "escalier"));
        hall.addExit(new Exit(darkRoom, "piece2"));
        hall.addExit(new BigDoor(vilburasChamber, "grande_porte"));
        
        enigmaticRoom.addExit(new Exit(hall, "hall"));
        enigmaticRoom.addExit(new PuzzleDoor(ganRoom, "repere_gan", "Quel est le nombre à 4 chiffres qui vous vient instinctivement en tête ?", "1337"));
        
        ganRoom.addExit(new Exit(enigmaticRoom,"enigmatic_room"));
        
        stairs.addExit(new Exit(hall, "hall"));
        stairs.addExit(new Exit(beelzumRoom, "repere_beelzum"));
        Key strangeKey = new Key("cle_etrange", "Une clé à la forme étrange. A quoi peut-elle bien servir ?");
        stairs.addExit(new LockedExit(secretShop, "magasin_secret", strangeKey));
        
        secretShop.addExit(new Exit(stairs, "escalier"));
        
        beelzumRoom.addExit(new Exit(stairs,"escalier"));
        
        darkRoom.addExit(new Exit(hall, "hall"));
        darkRoom.addExit(new Exit(gotzaRoom, "repere_gotza"));
        
        gotzaRoom.addExit(new Exit(darkRoom, "piece_sombre"));
        
        vilburasChamber.addExit(new Exit(hall, "hall"));
        
        
        // Ajout des personnages
        GameCharacter guard = new Guard("garde",prisonKey);
        defaultPlace.addCharacter(guard);
        
        GameCharacter oldWoman = new OldWoman(strangeKey, hall);
        longCorridor.addCharacter(oldWoman);
        
        Merchant merchant = new Merchant();
        secretShop.addCharacter(merchant);
        
        // Ajout des ennemis
        Gan gan = new Gan();
        gan.addActivableGoal(killGan);
        ganRoom.addCharacter(gan);
        Beelzum beelzum = new Beelzum();
        beelzum.addActivableGoal(killBeelzum);
        beelzumRoom.addCharacter(beelzum);
        Gotza gotza = new Gotza();
        gotza.addActivableGoal(killGotza);
        gotzaRoom.addCharacter(gotza);
        Vilburas vilburas = new Vilburas();
        vilburas.addActivableGoal(killVilburas);
        vilburasChamber.addCharacter(vilburas);
        
        // Ajout des objets
        Item stone = new ThrowableItem("caillou", "Un simple caillou",guard);
        Item slab = new Chest("dalle");
        ((Chest)slab).addItem(hook);
        defaultPlace.addItem(stone);
        defaultPlace.addItem(slab);
        
        Glasses nightVisionGlasses = new Glasses("lunettes_vision_nocturne", "Des lunettes qui permettent de voir dans le noir", 5, 0, 0, 5);
        merchant.addSoldItem(new SoldItem(nightVisionGlasses, killBeelzum));
        Armor legendaryArmor = new Armor("armure_legendaire", "Une armure dont émane une puissante aura. Elle vous donne un air supérieur.",10,5,5,5);
        merchant.addSoldItem(new SoldItem(legendaryArmor, killGan));
        Ring trueSightRing = new Ring("anneau_vision","Une anneau vous donnant la vraie vision",5,3,3,3);
        merchant.addSoldItem(new SoldItem(trueSightRing, killGotza));
    }
    
    /**
     * Permet de demander au joueur de choisir un personnage.
     */
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
    
    /**
     * Permet de dérouler la scène d'introduction du jeu.
     */
    public void introScene(){
        List<String> textes = new ArrayList<>();
        textes.add("Vous êtes le dernier élu. Tous vos compagnons sont morts au combat.");
        textes.add("Vous avez pris part à cette guerre afin de libérer le royaume d’Elancia du dernier démon vivant : Vilburas.\n"
                + "Il se trouve dans le château d’Anor-Mun.");
        textes.add("Vous rentrez dans le château et votre ennemi se dresse devant vous. Il est la, il vous observe, vous vous préparez à l’attaquer.");
        textes.add("- Vilburas: Quelle vermine ose pénétrer dans ma demeure ?!");
        textes.add("- " + selectedHero.NAME + ": Ton règne est désormais fini Vilburas ! Rentre dans ton monde et laisse les miens en paix !");
        textes.add("- Vilburas: Mwahahahaha ! Tu crois pouvoir me défier, faible mortel ? Laisse moi te montrer une fraction de ma puissance !");
        textes.add("Vilburas s’approche.");
        //Ajouter interface de combat
        textes.add("--- Appuyez pour attaquer ---");
        textes.add("Vilburas ne prend pas de dégâts...");
        textes.add("Il ricane, puis vous balaye d'un coup de hâche de guerre.");
        textes.add("Vous commencez à fléchir des jambes.");
        textes.add("Vous tombez au sol.");
        textes.add("Vous ne voyez plus.");
        textes.add("Vous perdez connaissance...");
        textes.add("\n\n\n\nVous vous réveillez dûrement, vous avez mal partout.");
        textes.add("Vous êtes enfermé dans une cellule. Trouvez un moyen de vous échapper.");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Appuyez sur Entrée pour lire les dialogues ---");
        while(!sc.nextLine().equals("")){}
        for(String texte : textes){
            System.out.println(texte);
            while(!sc.nextLine().equals("")){}
        }
        
        defaultPlace.addCharacter(selectedHero);
    }
    
    /**
     * Permet de demander au joueur quelle action il veut effectuer, et de déterminer l'action à effectuer en fonction de la commande retournée.
     */
    public void userAction(){
        System.out.println("\nQue faites-vous ?");
        List<String> command = getUserCommand();
        System.out.println("\n\n\n=====================================");
        switch (command.get(0)) {
            case "go":
                switch(command.size()){
                    case 2:
                        actionGo(command.get(1));
                        break;
                    case 3:
                        actionGo(command.get(1),command.get(2));
                        break;
                    default:
                        System.out.println("Utilisation : go direction [key]");
                        break;
                }
                break;
            case "help":
                if(command.size() == 1){
                    actionHelp();
                }
                else
                    System.out.println("Utilisation : help");
                break;
            case "look":
                switch (command.size()) {
                    case 1:
                        actionLookAround();
                        break;
                    case 2:
                        actionLookObject(command.get(1));
                        break;
                    default:
                        System.out.println("Utilisation: look [objet]");
                        break;
                }   break;
            case "take":
                if(command.size() == 2)
                    actionTakeItem(command.get(1));
                else
                    System.out.println("Utilisation : take [objet]");
                break;
            case "quit":
                if(command.size() == 1)
                    actionQuit();
                else
                    System.out.println("Utilisation : quit");
                break;
            case "use":
                switch(command.size()){
                    case 1:
                        actionLookInventory();
                        break;
                    case 2:
                        actionUseItem(command.get(1));
                        break;
                    case 3:
                        actionUseItem(command.get(1), command.get(2));
                        break;
                    default:
                        System.out.println("Utilisation : use [objet1] [objet2]");
                        break;
                }   break;
            case "fight":
                if(command.size() == 2)
                    actionFight(command.get(1));
                else
                    System.out.println("Utilisation : fight ennemi");
                break;
            case "talk":
                if(command.size() == 2){
                    actionTalk(command.get(1));
                }
                else{
                    System.out.println("Utilisation : talk personnage");
                }   break;
            default:
                break;
        }
    }
    
    /**
     * Permet de récupérer une commande de l'utilisateur
     * @return la commande séparée en mots qui correspondent aux paramètres de la commande
     */
    public List<String> getUserCommand(){
        List<String> chosenCommand = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String textCommand = "";
        String firstWord = "";
        do{
            System.out.println("Entrez une commande valide:");
            textCommand = sc.nextLine();
            // Récupère le premier mot de la ligne
            firstWord = textCommand.split(" ", 2)[0];
            if(!commands.containsKey(firstWord))
                System.out.println("Commande '" + firstWord + "' non reconnue");
        }while(!commands.containsKey(firstWord));
        
        for(String word : textCommand.split(" ")){
            chosenCommand.add(word);
        }
        return chosenCommand;
    }
    
    /**
     * Permet de tenter d'accéder à une porte sans clé
     * @param doorName nom de la porte
     */
    private void actionGo(String doorName){
        Exit exit = null;
         for(Exit e : selectedHero.getCurrentPlace().getExits()){
             if(e.DOOR_NAME.equals(doorName))
                 exit = e;
         }
         if(exit != null){
             System.out.println("Vous accédez à '" + exit.DOOR_NAME + "'");
             selectedHero.accessExit(exit);
         }
         else
             System.out.println("Il n'y a pas de sortie nommée '" + doorName + "'");
    }
    
    /**
     * Permet de tenter d'accéder à une porte avec une clé
     * @param doorName nom de la porte
     * @param keyName nom de la clé
     */
    private void actionGo(String doorName, String keyName){
        Exit exit = null;
        for(Exit e : selectedHero.getCurrentPlace().getExits()){
            if(e.DOOR_NAME.equals(doorName))
                exit = e;
        }
        
        Item key = Item.getItemByName(selectedHero.getInventory(), keyName);
        
        if(exit != null && key != null && key instanceof Key){
            System.out.println("Vous accédez à '" + exit.DOOR_NAME + "'");
            selectedHero.accessExit(exit, (Key)key);
        }
        else
            System.out.println("Quelque chose ne correspond pas...");
    }
    
    /**
     * Permet d'afficher la liste des commandes disponibles
     */
    private void actionHelp(){
        System.out.println("Voici la liste des commandes utilisables:");
        for(Map.Entry<String,String> c : commands.entrySet()){
            System.out.println("- " + c.getKey() + " : " + c.getValue());
        }
    }
    
    /**
     * Permet de donner un descriptif du lieu entourant le héros
     */
    private void actionLookAround(){
        System.out.println("Description de '" + selectedHero.getCurrentPlace().NAME + "':");
        System.out.println(selectedHero.getCurrentPlace().DESCRIPTION);
        System.out.println("> Objets visibles:");
        for(Item i : selectedHero.getCurrentPlace().getItems())
            System.out.println("- " + i.NAME);
        System.out.println("> Personnages visibles:");
        for(GameCharacter c : selectedHero.getCurrentPlace().getCharacters()){
            if(c!=selectedHero)
                System.out.println("- " + c.NAME);
        }
        System.out.println("> Sorties visibles:");
        for(Exit e : selectedHero.getCurrentPlace().getExits())
            System.out.println("- " + e.DOOR_NAME);
        System.out.println("");
    }
    
    /**
     * Permet d'avoir le descriptif d'un objet
     * @param objectName nom de l'objet
     */
    private void actionLookObject(String objectName){
        Item item = null;
        List<Item> itemList = selectedHero.getCurrentPlace().getItems();
        item = Item.getItemByName(itemList,objectName);
        if(item == null)
            System.out.println("Il n'y a pas d'objet '" + objectName + "' dans la pièce");
        else
            System.out.println(item.NAME + " : " + item.DESCRIPTION);
    }
    
    /**
     * Permet de faire ramasser un objet au héros
     * @param itemName 
     */
    private void actionTakeItem(String itemName){
        Item item;
        List<Item> items = selectedHero.getCurrentPlace().getItems();
        item = Item.getItemByName(items, itemName);
        if(item == null)
            System.out.println("Il n'y a pas d'objet '" + itemName + "' dans la pièce");
        else{
            System.out.println("Vous ramassez l'objet '" + item.NAME + "'");
            selectedHero.takeItem(item);
        }
    }
    
    /**
     * Permet de quitter le jeu, en demandant une confirmation à l'utilisateur
     */
    private void actionQuit(){
        System.out.println("Voulez-vous vraiment quitter ? 1 : Oui , 2 : Non");
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice == 1)
            quittingGame = true;
    }
    
    /**
     * Permet d'obtenir un descriptif de l'inventaire du héros
     */
    private void actionLookInventory(){
        System.out.println("Voici votre inventaire:");
        for(Item i : selectedHero.getInventory())
            System.out.println("- " + i.NAME + " : " + i.DESCRIPTION);
    }
    
    /**
     * Permet d'utiliser un objet
     * @param itemName nom de l'objet
     */
    private void actionUseItem(String itemName){
        Item item = Item.getItemByName(selectedHero.getInventory(), itemName);
        if(item != null){
            System.out.println("Vous utilisez l'objet '" + item.NAME + "'");
            selectedHero.useItem(item);
        }
        else{
            System.out.println("Vous ne possédez pas l'objet '" + itemName + "'");
        }
    }
    
    /**
     * Permet d'utiliser deux objets ensemble
     * @param itemName1 nom du premier objet
     * @param itemName2 nom du deuxième objet
     */
    private void actionUseItem(String itemName1, String itemName2){
        Item item1 = Item.getItemByName(selectedHero.getInventory(), itemName1);
        Item item2 = Item.getItemByName(selectedHero.getInventory(), itemName2);
        if(item1 != null && item2 != null){
            selectedHero.useItem(item1, item2);
            System.out.println("Vous utilisez l'objet '" + item1.NAME + "' avec l'objet '" + item2.NAME +"'");
        }
        else if(item1 == null && item2 == null)
            System.out.println("Vous ne possédez pas les objets '" + itemName1 + "' et '" + itemName2 + "'");
        else if(item1 == null)
            System.out.println("Vous ne possédez pas l'objet '" + itemName1 + "'");
        else if(item2 == null)
            System.out.println("Vous ne possédez pas l'objet '" + itemName2 + "'");
    }
    
    /**
     * Permet d'engager un combat entre le héros et un ennemi
     * @param enemyName nom de l'ennemi
     */
    private void actionFight(String enemyName){
        Enemy enemy = null;
        for(Enemy e : selectedHero.getCurrentPlace().getEnemies()){
            if(e.NAME.equals(enemyName))
                enemy = e;
        }
        if(enemy != null){
            System.out.println("Vous engagez un combat avec " + enemy.NAME);
            selectedHero.fight(enemy);
        }
        else
            System.out.println("Il n'y a pas d'enemi nommé '" + enemyName + "' aux alentours");
    }
    
    /**
     * Permet de démarrer une discussion entre le héros et un personnage
     * @param characterName nom du personnage
     */
    private void actionTalk(String characterName){
        GameCharacter character = null;
        for(GameCharacter c : selectedHero.getCurrentPlace().getCharacters()){
            if(c.NAME.equals(characterName))
                character = c;
            }
            if(character != null){
                System.out.println("Vous engagez la conversation avec '" + character.NAME + "'");
                selectedHero.talkTo(character);
            }
             else
                System.out.println("Il n'y a pas de personne nommée '" + characterName + "' aux alentours");
    }
    
    /**
     * Permet de savoir si le jeu est sur le point d'être quitté
     * @return true si le jeu se quitte, ou false si le jeu ne se quitte pas
     */
    public Boolean isQuitting() {
        return quittingGame;
    }
    
    /**
     * Permet de savoir si l'objectif principal de la partie est accompli
     * @return true si l'objectif est accompli, ou false si il n'est pas accompli
     */
    public Boolean isMainGoalAchieved(){
        return mainGoal.isAchieved();
    }
    
    /**
     * Permet de savoir si le héros est vivant
     * @return true si le héros est vivant, false si il est mort
     */
    public Boolean isHeroAlive(){
        return selectedHero.isAlive();
    }

    /**
     * Permet de retourner le lieu de démarrage de la partie
     * @return lieu par défaut
     */
    public Place getDefaultPlace() {
        return defaultPlace;
    }

    /**
     * Permet de retourner le héros choisi par le joueur
     * @return héros sélectionné
     */
    public Hero getSelectedHero() {
        return selectedHero;
    }
}