package rootbeerbehind;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class RootbeerBehindController implements ActionListener {

    private RootbeerBehindModel model;
    private RootbeerBehindView view;

    public void setUp(RootbeerBehindModel model, RootbeerBehindView view) {
        this.model = model;
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Submit"))
        {
            model.setTextAreaInputText(view.getInputText());
            model.setTextAreaOutputText(view.getOutputText());
            model.submit();
        }
    }

}
