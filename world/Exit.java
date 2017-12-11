package world;

import item.Key;

public class Exit {
    protected Place ledPlace;
    public final String DOOR_NAME;

    public Exit(Place ledPlace, String DOOR_NAME) {
        this.ledPlace = ledPlace;
        this.DOOR_NAME = DOOR_NAME;
    }
    
    public Place accessExit(){
        return ledPlace;
    }
    
    public Place accessExit(Key key){
        System.out.println("La clé n'est pas nécessaire, vous ouvrez la porte sans problème.");
        return accessExit();
    }
}