package rootbeerbehind;

import javax.swing.*;


/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class Driver {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        // Create model
        RootbeerBehindModel model = new RootbeerBehindModel();
        // Create controller
        RootbeerBehindController controller = new RootbeerBehindController();
        // Create view
        RootbeerBehindView view = new RootbeerBehindView(controller);
        // Update the view when the model changes
        model.addObserver(view);
        controller.setUp(model, view);
        //Display the window.
        view.pack();
        view.setVisible(true);
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
