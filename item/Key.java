/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 * Une clé
 */
public class Key extends Item {

    /**
     * Permet d'instancier une clé
     * @param NAME nom
     * @param DESCRIPTION description
     */
    public Key(String NAME, String DESCRIPTION) {
        super(NAME, DESCRIPTION, 0, 0, 0, 0);
    }
}
