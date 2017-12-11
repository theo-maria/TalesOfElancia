package character;

import game.Fight;
import item.Consumable;
import item.Equipment;
import item.Item;
import item.Key;
import item.ThrowableItem;
import java.util.*;
import world.Exit;
import world.Place;

/**
 * Classe correspondant à un héros
 */
public abstract class Hero extends GameCharacter {
    
    /**
     * Inventaire des objets possédés par le joueur
     */
    private List<Item> inventory;
    
    /**
     * Liste des objets actifs du joueur
     */
    private List<Consumable> activatedItems ;
    private final String CLASS_NAME;

    /**
     * Permet d'instancier un nouveau héros
     * @param NAME nom du héros
     * @param CLASS_NAME nom de la classe du héros (son rôle)
     * @param BASE_HEALTH sa vie de base
     * @param BASE_ARMOR son armure de base
     * @param BASE_FORCE sa force de base
     * @param BASE_AGILITY son agilité de base
     */
    public Hero(String NAME, String CLASS_NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_AGILITY);
        this.CLASS_NAME = CLASS_NAME;
        inventory = new ArrayList<>();
        activatedItems = new ArrayList<>();
    }

    /**
     * Retourne le nom de la classe du héros (son rôle)
     * @return nom de la classe
     */
    public String getCLASS_NAME() {
        return CLASS_NAME;
    }
    /**
     * Permet de tenter de ramasser un objet
     * @param item objet a ramasser
     */
    public void takeItem(Item item)
    {
        item.take(this);
    }

    /**
     * Permet de retourner la vie maximale du joueur
     * @return vie maximale
     */
    @Override
    public int getMaxHealth() {

        int healthBonus = 0;
        for(Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    healthBonus += item.getBONUS_HEALTH();
                }
            }
        }

        return super.getMaxHealth() + healthBonus;   
    }

    /**
     * Permet de retourner l'armure totale du joueur
     * @return armure totale
     */
    @Override
    public int getTotalArmor() 
    {
        int armorBonus = 0;
        for(Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    armorBonus += item.getBONUS_ARMOR();
                }
            }
        }

        return super.getTotalArmor() + armorBonus;
    }

    /**
     * Permet de retourner la force totale du joueur
     * @return force totale
     */
    @Override
    public int getTotalForce() 
    {
        int forceBonus = 0;
        for( Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    forceBonus += item.getBONUS_FORCE();
                }
            }
        }

        return super.getTotalForce() + forceBonus;
    }

    /**
     * Permet de retourner l'agilité totale du joueur
     * @return agilité totale
     */
    @Override
    public int getTotalAgility() 
    {
        int agilityBonus = 0;
        for( Item item : this.inventory)
        {
            if(item instanceof Equipment)
            {
                if(((Equipment) item).isWorned())
                {
                    agilityBonus += item.getBONUS_AGILITY();
                }
            }
        }
        return super.getTotalAgility() + agilityBonus;
    }

    /**
     * Permet d'équiper un objet
     * @param e objet à équiper
     */
    public void equipItem(Equipment e)
    {
        for(Item item : this.inventory)
        {
            if(item.equals(e))
            {
                e.setWorn(true);
            }
        }
    }
    
    /**
     * Permet d'utiliser un objet
     * @param item objet à utiliser
     */
    public void useItem(Item item){
        if (item instanceof Equipment)
            equipItem((Equipment)item);
        else if(item instanceof Consumable)
            ((Consumable) item).use();
        else if(item instanceof ThrowableItem){
            if(currentPlace.hasCharacter((GameCharacter) ((ThrowableItem)item).getThrowableOn())){
                ((ThrowableItem)item).throwItem();
                inventory.remove(item);
            }
        }
        else
            System.out.println("Rien ne se passe");
    }
    
    /**
     * Permet d'utiliser deux objets ensemble
     * @param item1 objet 1
     * @param item2 objet 2
     */
    public void useItem(Item item1, Item item2){
        
    }

    /**
     * Permet de consommer un objet donnant un bonus au héros
     * @param c
     */
    public void buffHero(Consumable c)
    {
        activatedItems.add(c);
        inventory.remove(c);
    }
    
    /**
     * Permet de parler à un autre personnage
     * @param c personnage
     */
    public void talkTo(GameCharacter c) {
        if(c.isTalkable()){
            c.talk(this);
        }
        else{
            System.out.println("Pas de réponse...");
        }
    }

    /**
     * Permet d'engager un combat contre un ennemi
     * @param e ennemi
     */
    public void fight(Enemy e) {
        Fight fight = new Fight(this, e);
        fight.startFight();
    }
    
    /**
     * Permet de lancer une attaque contre un ennemi
     * @param enemy ennemi
     */
    public void attack(Enemy enemy){
        enemy.damage(this.getTotalForce());
    }
    
    /**
     * Permet de tenter d'accéder à une sortie
     * @param exit sortie
     */
    public void accessExit(Exit exit){
        Place p = exit.accessExit();
        if(p != null)
            currentPlace = p;
    }
    
    /**
     * Permet de tenter d'accéder à une sortie avec une clé
     * @param exit la sortie
     * @param key la clé
     */
    public void accessExit(Exit exit, Key key){
        Place p = exit.accessExit(key);
        if(p != null)
            currentPlace = p;
    }

    /**
     * Permet de retourner l'inventaire du héros
     * @return inventaire
     */
    public List<Item> getInventory() {
        return inventory;
    }
    
    /**
     * Permet de retourner la liste des consomables possédés par le joueur
     * @return liste des consommables
     */
    public List<Consumable> getConsumableItems(){
        List<Consumable> liste = new ArrayList<>();
        for(Item i : getInventory()){
            if(i instanceof Consumable)
                liste.add((Consumable)i);
        }
        return liste;
    }
    
    /**
     * Permet d'ajouter un objet à l'inventaire du héros
     * @param i objet à ajouter
     */
    public void addItem(Item i){
        inventory.add(i);
    }
    
    /**
     * Permet de savoir si le héros possède un objet
     * @param i objet
     * @return true si l'objet est possédé, sinon false
     */
    public Boolean hasItem(Item i){
        return inventory.contains(i);
    }
    
    /**
     * Permet de vider la liste des bonus du joueur (typiquement à la fin dun combat)
     */
    public void clearBuffs(){
        activatedItems.clear();
    }
}
