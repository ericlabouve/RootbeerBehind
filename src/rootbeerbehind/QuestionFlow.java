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
    private static String[] questions = new String[]{"What is your name?", "What is your gender? Enter male or female", "What is your age?", "What is your race?", "What is your favorite joke?", "Why does your life suck?", "Who is the Prime Minister of Israel"}; // array of Strings holding the questions

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
