/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import item.Key;
import java.util.Scanner;

/**
 *
 * @author Theo
 */
public class BigDoor extends Exit {
    
    public BigDoor(Place ledPlace, String DOOR_NAME) {
        super(ledPlace, DOOR_NAME);
    }
    
    public Place accessExit(){
        System.out.println("Vous sentez dans cette pièce une présence familière qui vous fait trembler de peur... Vous entrez discrètement...");
        return ledPlace;
    }
    
    public Place accessExit(Key key){
        System.out.println("La clé n'est pas nécessaire, vous ouvrez la porte sans problème.");
        return accessExit();
    }
}
