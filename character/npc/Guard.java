/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.npc;

import character.NPC;
import item.Key;

/**
 *
 * @author Theo
 */
public class Guard extends NPC {
    
    Key possesedKey;
    
    public Guard(String NAME, Key possesedKey) {
        super(NAME, 50, 10, 10, 10);
        this.possesedKey = possesedKey;
    }
    
    public void knockOut(){
        System.out.println("Le garde s'évanoui... et laisse tomber une clé !");
        currentPlace.addItem(possesedKey);
    }
}
