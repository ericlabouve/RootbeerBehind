package rootbeerbehind;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author lenoyavidan
 * @author ericlabouve
 */
public class RootbeerBehind implements ActionListener {
    private JPanel mainPanel; 
     
    private JTextArea textAreaOutput;
    private JTextArea textAreaInput;
    
    public void addComponentToPane(Container pane) {
        JPanel textFieldPane = new JPanel(); //use FlowLayout
        textFieldPane.setLayout(new BoxLayout(textFieldPane, BoxLayout.PAGE_AXIS));
        
        // Output
        textAreaOutput = new JTextArea(10, 40);
        textAreaOutput.setText("Test\n");
        JScrollPane scrollPaneOutput = new JScrollPane(textAreaOutput); 
        textAreaOutput.setEditable(false);
        textFieldPane.add(scrollPaneOutput);
        
        // Input 
        textAreaInput = new JTextArea(10, 40);
        JScrollPane scrollPaneInput = new JScrollPane(textAreaInput); 
        textAreaOutput.setEditable(true);
        textFieldPane.add(scrollPaneInput);
         
        //Create the "cards".
        JPanel buttonPane = new JPanel();
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        buttonPane.add(submitButton);
         
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
         
        //Create the panel that contains the "cards".
        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(buttonPane);
        mainPanel.add(card2);
         
        pane.add(textFieldPane, BorderLayout.PAGE_START);
        pane.add(mainPanel, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        textAreaOutput.setText("");
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Rootbeer Behind");
        frame.setSize(100, 100);
        //There is no return
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        RootbeerBehind demo = new RootbeerBehind();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
