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
    public Questionnaire() {
        questions = new ArrayList<>();
    }

    /*
     * Add the question to the question list
     * Param: String
     * Return: void
     */
    public void addQuestion(String s) {
        if(s != null || s != "")
            questions.add(s);
    }

    /*
     * Record the answer depending on the question type and save in the answer list.
     * ASSUMPTION: for question where answer is true or false, question should have "?".
     * Param: none
     * Return: List of String
     * 
     */
    
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String s: questions) {
            if(s.trim().contains("?")){
                System.out.println("True or False: ");
            }else{
                System.out.println("Rate between 1-5 where \n5 is Strongly Agree\n4 is Somewhat Agree\n3 is Neutral\n2 is Somewhat Disagree\n1 is Strong Disagree");
            }
            System.out.println(s);
            String response = "";
            boolean validAnswer = false;
            while(!validAnswer){
                try {
                    response = reader.readLine();
                    if(s.trim().contains("?")){
                        if(!response.trim().equalsIgnoreCase(ANSWERS.FALSE.name()) && !response.trim().equalsIgnoreCase(ANSWERS.TRUE.name())){
                            System.out.println("Answer can be true or false, please answer the following question " + s + " again.");
                        }else{
                            validAnswer = true;
                        }
                    }else{
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
        q.addQuestion("Are you awake?");
        q.addQuestion("Have you had coffee?");
        q.addQuestion("Are you ready to get to work?");
        q.addQuestion("CSE 687 is awesome.");
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}
