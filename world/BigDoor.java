/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import item.Key;

/**
 * Une grande porte terrifiante
 */
public class BigDoor extends Exit {
    
    /**
     * Permet d'instancier une grande porte
     * @param ledPlace lieu ou la porte menne
     * @param DOOR_NAME nom de la porte
     */
    public BigDoor(Place ledPlace, String DOOR_NAME) {
        super(ledPlace, DOOR_NAME);
    }
    
    /**
     * Permet d'accéder au lieu
     * @return lieu
     */
    @Override
    public Place accessExit(){
        System.out.println("Vous sentez dans cette pièce une présence familière qui vous fait trembler de peur... Vous entrez discrètement...");
        return super.accessExit();
    }
    
    /**
     * Permet d'accéder au lieu à l'aide d'une clé
     * @param key clé
     * @return lieu
     */
    @Override
    public Place accessExit(Key key){
        System.out.println("La clé n'est pas nécessaire, vous ouvrez la porte sans problème.");
        return accessExit();
    }
}
