package syr.edu.hw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Class is use to store question with its question, prompt, acceptable answer and question type
 */
class Question {
    static enum QUESTION_TYPE_AND_PROMPT_CONSTANT{
        ADMINISTER ("True or False: "),
        LIEKERT ("Rate between 1-5 where \n5 is Strongly Agree\n4 is Somewhat Agree\n3 is Neutral\n2 is Somewhat Disagree\n1 is Strong Disagree");

        private final String prompt;
        QUESTION_TYPE_AND_PROMPT_CONSTANT(String prompt){
            this.prompt = prompt;
        }

        public String getPrompt(){
            return this.prompt;
        }
    }
    private String q;
    private String prompt;
    private List<String> acceptableAnswers;
    private QUESTION_TYPE_AND_PROMPT_CONSTANT type;
    public Question(String q, String prompt, List<String> acceptable,QUESTION_TYPE_AND_PROMPT_CONSTANT qt) {
        this.q = q;
        this.prompt = prompt;
        this.acceptableAnswers = acceptable;
        this.type = qt;
    }
    /*
     * Prints question with its prompt
     * Param: PrintStream
     * Return: void
     */
    public void render(PrintStream p) {
        p.println(q);
        p.println(prompt);
    }
    /*
     * Returns prompt value
     * Param: void
     * Return: String
     */
    public String getPrompt(){
        return this.prompt;
    }
    /*
     * Returns type value
     * Param: void
     * Return: QUESTION_TYPE_AND_PROMPT_CONSTANT
     */
    public QUESTION_TYPE_AND_PROMPT_CONSTANT getType(){
        return this.type;
    }
    /*
     * Check if answer is in acceptable answer list or not
     * Param: String
     * Return: Boolean
     */
    public boolean isAcceptableAnswer(String s) {
        return acceptableAnswers.contains(s);
    }
}

public class Questionnaire {
    /*
     * Store Agreement level of 1 to 5
     */
    enum AGREEMENT_LEVEL{
        Strongly_Agree ("Strongly Agree"),
        Somewhat_Agree ("Somewhat Agree"),
        Neutral ("Neutral"),
        Somewhat_Disagree ("Somewhat Disagree"),
        Strong_Disagree ("Strong Disagree");

        private final String levelName;
        AGREEMENT_LEVEL(String ln){
            this.levelName = ln;
        }

        public String getLevelName(){
            return this.levelName;
        }

    }
    List<Question> questions;
    public Questionnaire() {
        questions = new ArrayList<>();
    }
    /*
     * Adding question to the list
     * Param: Question
     * Return: void
     */
    public void addQuestion(Question q) {
        questions.add(q);
    }
    /*
     * Getting answer from user for all question
     * Param: void
     * Return: List of String
     */
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Question q: questions) {
            q.render(System.out);
            String response = "";
            do {
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!q.isAcceptableAnswer(response));
            if(q.getType() == Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.LIEKERT)
                switch (response) {
                    case "1":
                        response = AGREEMENT_LEVEL.Strong_Disagree.getLevelName();
                        break;
                    case "2":
                        response = AGREEMENT_LEVEL.Somewhat_Disagree.getLevelName();
                        break;
                    case "3":
                        response = AGREEMENT_LEVEL.Neutral.getLevelName();
                        break;
                    case "4":
                        response = AGREEMENT_LEVEL.Somewhat_Agree.getLevelName();
                        break;
                    case "5":
                        response = AGREEMENT_LEVEL.Strongly_Agree.getLevelName();
                        break;
                    default:
                        response = "Wrong choice";
                        break;
                }
            answers.add(response);
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addQuestion(new Question("Are you awake?", Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.ADMINISTER.getPrompt(), Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F"),Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.ADMINISTER));
        q.addQuestion(new Question("Have you had coffee?", Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.ADMINISTER.getPrompt(), Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F"),Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.ADMINISTER));
        q.addQuestion(new Question("Are you ready to get to work?", Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.ADMINISTER.getPrompt(), Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F"),Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.ADMINISTER));
        q.addQuestion(new Question("CSE 687 is awesome.", Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.LIEKERT.getPrompt(), Arrays.asList("1","2","3","4","5"),Question.QUESTION_TYPE_AND_PROMPT_CONSTANT.LIEKERT));
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
    }
}
