/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import game.Puzzle;

/**
 * Porte-énigme
 */
public class PuzzleDoor extends Exit {
    
    private final Puzzle PUZZLE;
    
    /**
     * Permet d'instancier une porte-énigme
     * @param ledPlace lieu
     * @param DOOR_NAME nom de la porte
     * @param question question posée par l'énigme
     * @param goodAnswer bonne réponse de l'énigme
     */
    public PuzzleDoor(Place ledPlace, String DOOR_NAME, String question, String goodAnswer) {
        super(ledPlace, DOOR_NAME);
        PUZZLE = new Puzzle(question, goodAnswer);
    }
    
    /**
     * Permet de tenter de résoudre l'énigme pour accéder à la sortie
     * @return sortie
     */
    @Override
    public Place accessExit(){
        System.out.println("Pour pouvoir ouvrir cette porte, vous devez répondre correctement à une énigme !");
        if(PUZZLE.solvePuzzle())
            return ledPlace;
        return null;
    }
}
