package world;

import item.Key;

/**
 * Sortie d'un lieu
 */
public class Exit {

    /**
     * Lieu où menne la sortie
     */
    protected Place ledPlace;

    /**
     * Nom de la porte
     */
    public final String DOOR_NAME;

    /**
     * Permet d'instancier une sortie
     * @param ledPlace lieu
     * @param DOOR_NAME nom
     */
    public Exit(Place ledPlace, String DOOR_NAME) {
        this.ledPlace = ledPlace;
        this.DOOR_NAME = DOOR_NAME;
    }
    
    /**
     * Permet d'accéder au lieu de la sortie
     * @return
     */
    public Place accessExit(){
        return ledPlace;
    }
    
    /**
     * Permet d'accéder à la sortie avec une clé
     * @param key clé
     * @return
     */
    public Place accessExit(Key key){
        System.out.println("La clé n'est pas nécessaire, vous ouvrez la porte sans problème.");
        return accessExit();
    }
}