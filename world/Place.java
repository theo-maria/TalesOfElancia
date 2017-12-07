package world;

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
    
    public Item getItemByName(String name){
        Item item = null;
        for(Item i : getItems()){
            if(i.NAME.equals(name))
                item = i;
        }
        return item;
    }
}