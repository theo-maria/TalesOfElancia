/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Theo
 */
public class Enigme {
    private String question;
    private String reponse1;
    private String reponse2;
    private String reponse3;
    private String bonneReponse;

    public Enigme(String question, String reponse1, String reponse2, String reponse3, String bonneReponse) {
        this.question = question;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.bonneReponse = bonneReponse;
    }
}
