package rootbeerbehind;

import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.*;
/**
 * @author lenoyavidan
 * @author ericlabouve
 */
public class RootbeerBehindView extends JFrame implements Observer {
    private JPanel mainPanel;
    private JTextArea textAreaOutput;
    private JTextArea textAreaInput;
    private JButton submitButton;

    private static final String STARTING_INPUT_TEXT = "> ";
    private static final String STARTING_OUTPUT_TEXT = "Lenoy Sucks!";

    public RootbeerBehindView (ActionListener controller) {
        // Set up parent frame
        super("Rootbeer Behind");
        setSize(100, 100);
        // Switch this off if you want to be a dick
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addControls();
        submitButton.addActionListener(controller);
    }
    
    public void addControls() {
        Container contentPane = this.getContentPane();

        JPanel textFieldPane = new JPanel(); //use FlowLayout
        textFieldPane.setLayout(new BoxLayout(textFieldPane, BoxLayout.PAGE_AXIS));

        // Output
        textAreaOutput = new JTextArea(10, 40);
        textAreaOutput.setText(STARTING_OUTPUT_TEXT);
        JScrollPane scrollPaneOutput = new JScrollPane(textAreaOutput);
        textAreaOutput.setEditable(false);
        textFieldPane.add(scrollPaneOutput);

        // Input 
        textAreaInput = new JTextArea(10, 40);
        textAreaInput.setText(STARTING_INPUT_TEXT);
        JScrollPane scrollPaneInput = new JScrollPane(textAreaInput);
        textAreaOutput.setEditable(true);
        textFieldPane.add(scrollPaneInput);

        //Create the "cards".
        JPanel buttonPane = new JPanel();
        submitButton = new JButton("Submit");
        buttonPane.add(submitButton);

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        //Create the panel that contains the "cards".
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(buttonPane);
        mainPanel.add(card2);

        contentPane.add(textFieldPane, BorderLayout.PAGE_START);
        contentPane.add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Used to update the view when the model has changed
     * @param obs = The model
     * @param arg = An Action Command passed from the model
     */
    public void update(Observable obs, Object arg)
    {
        String message = (String) arg;
        if (message.equals("Submit")) {
            textAreaOutput.setText(textAreaInput.getText().substring(STARTING_INPUT_TEXT.length()));
            textAreaInput.setText(STARTING_INPUT_TEXT);
        }
    }

    public String getOutputText() {
        return textAreaOutput.getText();
    }

    public String getInputText() {
        return textAreaInput.getText();
    }
}