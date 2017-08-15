/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.LinkedList;

/**
 *
 * @author Stefanie
 */
public class Question {
    private Models.Question question;

    public Question() {
        question = new Models.Question();
    }

    public Question(Models.Question question) {
        this.question = question;
    }
    
    public LinkedList<Models.Question> select(){
        return question.select();
    }
}
