package world;

import character.Enemy;
import item.Item;
import character.GameCharacter;
import java.util.*;

public class Place {

    private List<Exit> exits;
    private List<Item> items;
    private List<GameCharacter> characters;
    public final String NAME;
    public final String DESCRIPTION;
    private Boolean inDarkness;

    public Place(String NAME, String DESCRIPTION) {
        this.NAME = NAME;
        exits = new ArrayList<>();
        items = new ArrayList<>();
        characters = new ArrayList<>();
        this.DESCRIPTION = DESCRIPTION;
    }

    public List<Item> getItems() {
        return items;
    }
    
    public void removeItemFromPlace(Item i){
        items.remove(i);
    }
    
    public List<Enemy> getEnemies(){
        List<Enemy> enemies = new ArrayList<>();
        for(GameCharacter c : characters){
            if(c instanceof Enemy)
                enemies.add((Enemy)c);
        }
        return enemies;
    }

    public List<GameCharacter> getCharacters() {
        return characters;
    }
    
    public void addCharacter(GameCharacter c){
        if(c.getCurrentPlace() != null)
            c.getCurrentPlace().removeCharacter(c);
        characters.add(c);
        c.setCurrentPlace(this);
    }
    
    public void removeCharacter(GameCharacter c){
        characters.remove(c);
    }
    
    public void addItem(Item i){
        items.add(i);
    }

    public List<Exit> getExits() {
        return exits;
    }
    
    public void addExit(Exit e){
        exits.add(e);
    }
    
    public void setDarkness(Boolean inDarkness){
        this.inDarkness = inDarkness;
    }
}