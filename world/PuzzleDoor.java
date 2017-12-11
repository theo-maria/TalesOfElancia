/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import game.Puzzle;

/**
 *
 * @author Theo
 */
public class PuzzleDoor extends Exit {
    
    private final Puzzle PUZZLE;
    
    public PuzzleDoor(Place ledPlace, String DOOR_NAME, String question, String goodAnswer) {
        super(ledPlace, DOOR_NAME);
        PUZZLE = new Puzzle(question, goodAnswer);
    }
    
    @Override
    public Place accessExit(){
        System.out.println("Pour pouvoir ouvrir cette porte, vous devez répondre correctement à une énigme !");
        if(PUZZLE.solvePuzzle())
            return ledPlace;
        return null;
    }
}
