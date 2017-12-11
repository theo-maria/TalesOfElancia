/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

/**
 * Une enigme posée au héros
 */
public class Puzzle {
    /**
     * La question posée au héros
     */
    private final String QUESTION;
    /**
     * La réponse à donner pour valider l'énigme
     */
    private final String GOOD_ANSWER;

    /**
     * Permet d'instancier une énigme
     * @param question la question posée
     * @param goodAnswer la bonne réponse
     */
    public Puzzle(String question, String goodAnswer) {
        this.QUESTION = question;
        this.GOOD_ANSWER = goodAnswer;
    }
    
    /**
     * Permet de tenter de résoudre l'énigme
     * @return true si énigme résolue, sinon false
     */
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
