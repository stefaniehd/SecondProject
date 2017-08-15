/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.FileManager;
import java.util.LinkedList;

/**
 *
 * @author Stefanie
 */
public class Question {
    private String code;
    private String question;
    private String answerOne;
    private String answerTwo;
    private FileManager fileManager;

    public Question() {
        fileManager = new FileManager();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }
    
    public LinkedList<Models.Question> select(){
        LinkedList<Models.Question> q = new LinkedList<>();
        String [] text = fileManager.read("question.txt").split("\n");
        for (int i = 0; i < text.length; i++) {
            String [] data = text[i].split(";");
            Models.Question que = new Question();
            que.setQuestion(data[0]);
            que.setAnswerOne(data[1]);
            que.setAnswerTwo(data[2]);
            q.add(que);
        }
        return q;
    }
}
