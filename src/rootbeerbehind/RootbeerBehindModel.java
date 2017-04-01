package rootbeerbehind;

import java.util.Observable;

/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class RootbeerBehindModel extends Observable {

    /**
     * Action occurs when Submit button is pressed to notify view to update itself
     */
    public void submit() {
        setChanged();
        notifyObservers("Submit");
    }
}
