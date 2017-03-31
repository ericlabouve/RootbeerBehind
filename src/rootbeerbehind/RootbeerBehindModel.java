package rootbeerbehind;

import java.util.Observable;

/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class RootbeerBehindModel extends Observable {

    /**
     * Action occurs when Submit button is pressed
     */
    public void submit() {
        setChanged();
        notifyObservers("Submit");
    }
}
