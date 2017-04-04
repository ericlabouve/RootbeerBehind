package rootbeerbehind;

import java.util.Observable;
import javax.swing.JOptionPane;

/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class RootbeerBehindModel extends Observable {

    private static final String STARTING_INPUT_TEXT = "> ";
    private static final String STARTING_OUTPUT_TEXT = "Lenoy Sucks!";

    private String textAreaOutputText;
    private String textAreaInputText;
    private FileCreation fc;

    public void init() {
        setTextAreaInputText(STARTING_INPUT_TEXT);
        setTextAreaOutputText(QuestionFlow.getNextQuestion());
        fc = new FileCreation();
    }

    /**
     * Action occurs when Submit button is pressed to notify view to update itself
     *
     */
    public void submit() {
        // Update the on screen text
        
        // Process the question here
        if (QuestionFlow.getQuestionNumber() == 1) {
            fc.setName(getTextAreaInputText().substring(2));
        }
        else if (QuestionFlow.getQuestionNumber() == 2) {
            fc.setGender(getTextAreaInputText().substring(2));
            //System.out.println("Name is " + fc.getName() + " Gender is " + fc.getGender());
            fc.execute();
            JOptionPane.showMessageDialog(null, "ERROR: Virus Detected\n" + 
                                            "Recommended course of action: Go Fuck Yourself");
            System.exit(0);

        }
        
        // Maybe output something like "ERROR ERROR ERROR right before file creation?"

        setTextAreaOutputText(QuestionFlow.getNextQuestion());
        setTextAreaInputText(STARTING_INPUT_TEXT);
        
        // Notify the view
        setChanged();
        notifyObservers("Submit");
    }

    public void setTextAreaOutputText(String str) {
        textAreaOutputText = str;
        setChanged();
        notifyObservers("OutputText");
    }

    public void setTextAreaInputText(String str) {
        textAreaInputText = str;
        setChanged();
        notifyObservers("InputText");
    }

    public String getTextAreaOutputText() {
        return new String(textAreaOutputText);
    }

    public String getTextAreaInputText() {
        return new String(textAreaInputText);
    }
}
