package world;

import item.Item;
import character.GameCharacter;
import java.util.*;

public class Place {

    private Collection<Exit> exits;
    Collection<Item> items;
    private Collection<GameCharacter> characters;
    private String name;
    private Boolean isInDarkness;
}