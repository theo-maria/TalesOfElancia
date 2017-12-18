package world;

import character.Enemy;
import item.Item;
import character.GameCharacter;
import java.util.*;

/**
 * Un lieu du jeu
 */
public class Place {

    /**
     * Sorties du lieu
     */
    private List<Exit> exits;
    /**
     * Objets présents dans le lieu
     */
    private List<Item> items;
    /**
     * Personnages présents dans le lieu
     */
    private List<GameCharacter> characters;

    /**
     * Nom du lieu
     */
    public final String NAME;

    /**
     * Description du lieu
     */
    public final String DESCRIPTION;

    /**
     * Permet d'instancier un lieu
     * @param NAME nom
     * @param DESCRIPTION description
     */
    public Place(String NAME, String DESCRIPTION) {
        this.NAME = NAME;
        exits = new ArrayList<>();
        items = new ArrayList<>();
        characters = new ArrayList<>();
        this.DESCRIPTION = DESCRIPTION;
    }

    /**
     * Permet de retourner la liste des objets du lieu
     * @return les objets
     */
    public List<Item> getItems() {
        return items;
    }
    
    /**
     * Permet de supprimer un objet du lieu
     * @param i objet
     */
    public void removeItemFromPlace(Item i){
        items.remove(i);
    }
    
    /**
     * Permt de retourner les ennemis du lieu
     * @return ennemis
     */
    public List<Enemy> getEnemies(){
        List<Enemy> enemies = new ArrayList<>();
        for(GameCharacter c : characters){
            if(c instanceof Enemy)
                enemies.add((Enemy)c);
        }
        return enemies;
    }

    /**
     * Permet de retourner les personnages du lieu
     * @return personnages
     */
    public List<GameCharacter> getCharacters() {
        return characters;
    }
    
    /**
     * Permet d'ajouter un personnage au lieu
     * @param c personnage
     */
    public void addCharacter(GameCharacter c){
        if(c.getCurrentPlace() != null)
            c.getCurrentPlace().removeCharacter(c);
        characters.add(c);
        c.setCurrentPlace(this);
    }
    
    /**
     * Permer de savoir si un prsonnage est présent dans le lieu
     * @param c personnage
     * @return true si présent, sinon false
     */
    public Boolean hasCharacter(GameCharacter c){
        return characters.contains(c);
    }
    
    /**
     * Permet d'enlever un personnage du lieu
     * @param c personnage
     */
    public void removeCharacter(GameCharacter c){
        characters.remove(c);
    }
    
    /**
     * Permet d'ajouter un objet au lieu
     * @param i objet
     */
    public void addItem(Item i){
        items.add(i);
    }

    /**
     * Permet de retourner les sorties du lieu
     * @return sorties
     */
    public List<Exit> getExits() {
        return exits;
    }
    
    /**
     * Permet d'ajouter une sortie au lieu
     * @param e sortie
     */
    public void addExit(Exit e){
        exits.add(e);
    }
    
}