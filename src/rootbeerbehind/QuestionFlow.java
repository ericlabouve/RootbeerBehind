package rootbeerbehind;

/**
 * @author lenoyavidan
 */

/*
 * Class to handle flow of questions. Has a list of questions and returns the next question
 * in the series of questions.
 */
public class QuestionFlow {

    private static int questNum = 0; // static counter for the current question
    private static String[] questions = new String[]{"What is your name?", "What is your gender? Enter male or female", "What is your age?", "What is your race?", "What is your favorite form of exercise?\n(Note eating pasta does not count, if you don't exercise please skip this question)", "Why does your life suck?", "Why does your life not suck?\n(Note: feel free to skip this question if you've given up on life)", "If you were a flavor of ice cream which flavor would you be and why?", "Write a couple sentences about your favorite food", "Who's your best friend and why?"}; // array of Strings holding the questions

    protected static int getQuestionNumber() {
        return questNum;
    }
    /*
     * Static method which gives the next question then increments questNum
     * Return: String with the next question
     */
    protected static String getNextQuestion() {
        if (questNum >= questions.length) {
            questNum = 0; // if finished series of questions, restart the sequence
        }

        return questions[questNum++];
    }

}
