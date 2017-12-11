/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.npc;

import character.NPC;
import item.Key;

/**
 * Classe d'un garde tenant une clé
 */
public class Guard extends NPC {
    
    /**
     * Clé possédée
     */
    Key possesedKey;
    
    /**
     * Permet d'instancier un garde
     * @param NAME nom
     * @param possesedKey clé possédée
     */
    public Guard(String NAME, Key possesedKey) {
        super(NAME, 50, 10, 10, 10);
        this.possesedKey = possesedKey;
    }
    
    /**
     * Permet d'assomer le garde, pour qu'il laisse tomber sa clé au sol
     */
    public void knockOut(){
        System.out.println("Le garde s'évanoui... et laisse tomber une clé !");
        currentPlace.addItem(possesedKey);
    }
}
