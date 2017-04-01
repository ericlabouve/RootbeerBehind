package rootbeerbehind;

import java.util.PrintWriter;
/**
 * @author lenoyavidan
 */
private static int questNum = 0; // static counter for the current question
private String[] questions = ["What is your name?", "What is your gender? Enter male or female"]; // array of Strings holding the questions

/*
 * Class to handle flow of questions. Has a list of questions and returns the next question
 * in the series of questions.
 */
public class QuestionFlow {

    // Defualt constructor
    public QuestionFlow() {
        name = "";
        gender = "";
    }

    /*
     * Static method which gives the next question then increments questNum
     * Return: String with the next question
     */
    protected static String getNextQuestion() {
        if (questNum >= questions.length()) {
            questNum = 0; // if finished series of questions, restart the sequence
        }

        return questions[questNum++];
    }

}