/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

/**
 *
 * @author Theo
 */
public class Puzzle {
    private final String QUESTION;
    private final String GOOD_ANSWER;

    public Puzzle(String question, String goodAnswer) {
        this.QUESTION = question;
        this.GOOD_ANSWER = goodAnswer;
    }
    
    public Boolean solvePuzzle(){
        System.out.println("Question: ");
        System.out.println(QUESTION);
        System.out.println("Quelle est votre réponse ?");
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equals(GOOD_ANSWER)){
            System.out.println("Bonne réponse !");
            return true;
        }
        System.out.println("Mauvaise réponse !");
        return false;
    }
}
