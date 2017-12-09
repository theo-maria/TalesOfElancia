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
    private Boolean isInDarkness;

    public Place(String NAME) {
        this.NAME = NAME;
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

    public void setCharacters(List<GameCharacter> characters) {
        this.characters = characters;
    }
    
    
}