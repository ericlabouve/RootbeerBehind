package rootbeerbehind;

import java.util.Observable;

/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class RootbeerBehindModel extends Observable {

    private static final String STARTING_INPUT_TEXT = "> ";
    private static final String STARTING_OUTPUT_TEXT = "Lenoy Sucks!";

    private String textAreaOutputText;
    private String textAreaInputText;

    public void init() {
        setTextAreaInputText(STARTING_INPUT_TEXT);
        setTextAreaOutputText(STARTING_OUTPUT_TEXT);
    }

    /**
     * Action occurs when Submit button is pressed to notify view to update itself
     *
     */
    public void submit() {
        // Update the on screen text
        setTextAreaOutputText(textAreaInputText.substring(STARTING_INPUT_TEXT.length()));
        setTextAreaInputText(STARTING_INPUT_TEXT);

        // Process the question here

        // Maybe output something like "ERROR ERROR ERROR right before file creation?"

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
