/*
 * Assumption:
 * There are different kind of question type, for that we use different list.
 * Separate method for adding and getting answer defined for administer and liekert question type.
 */
package syr.edu.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
    private enum ANSWERS{
        FALSE,
        TRUE
    }
    List<String> questions;
    List<String> liekertQuestions;
    public Questionnaire() {
        questions = new ArrayList<>();
        liekertQuestions = new ArrayList<>();
    }

    /*
     * Add the administer question to the administer question list
     * Param: String
     * Return: void
     */
    public void addAdministerQuestion(String s) {
        if(s != null || s != "")
            questions.add(s);
    }

    /*
     * Add the liekert question to the liekert question list
     * Param: String
     * Return: void
     */
    public void addLiekertQuestion(String s) {
        if(s != null || s != "")
            liekertQuestions.add(s);
    }

    /*
     * Record the answer for the administer question type and save in the answer list.
     * Param: none
     * Return: List of String
     * 
     */
    
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String s: questions) {
            System.out.println("True or False: ");
            System.out.println(s);
            String response = "";
            boolean validAnswer = false;
            while(!validAnswer){
                try {
                    response = reader.readLine();
                    if(response.length() > 0){
                        if(!response.trim().equalsIgnoreCase(ANSWERS.FALSE.name()) && !response.trim().equalsIgnoreCase(ANSWERS.TRUE.name())){
                            System.out.println("Answer can be true or false, please answer the following question " + s + " again.");
                        }else{
                            validAnswer = true;
                        }
                    }else{
                        System.out.println("Please provide an answer");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(validAnswer)
                    answers.add(response);
            }
        }
        return answers;
    }

    /*
     * Record the answer for the liekert question type and save in the answer list.
     * Param: none
     * Return: List of String
     * 
     */
    
    public List<String> liekertQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String s: liekertQuestions) {
            System.out.println("Rate between 1-5 where \n5 is Strongly Agree\n4 is Somewhat Agree\n3 is Neutral\n2 is Somewhat Disagree\n1 is Strong Disagree");
            System.out.println(s);
            String response = "";
            boolean validAnswer = false;
            while(!validAnswer){
                try {
                    response = reader.readLine();
                    if(response.length() > 0){
                        try{
                            int answer = Integer.parseInt(response);
                            if(answer < 0 || answer > 5){
                                System.out.println("Rating is between 1 to 5, please rate the following question " + s + " again.");
                            }else{
                                validAnswer = true;
                            }
                        }catch(NumberFormatException e){
                            System.out.println("Please provide a valid number");
                        }
                    }else{
                        System.out.println("Please provide an answer");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(validAnswer)
                    answers.add(response);
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addAdministerQuestion("Are you awake?");
        q.addAdministerQuestion("Have you had coffee?");
        q.addAdministerQuestion("Are you ready to get to work?");
        q.addLiekertQuestion("CSE 687 is awesome.");
        List<String> answers = q.administerQuestionnaire();
        answers.addAll(q.liekertQuestionnaire());
        System.out.println("complete!");
        System.out.println(answers);
    }
}
