package rootbeerbehind;

import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by Eric on 3/31/17.
 * @author ericlabouve
 */
public class RootbeerBehindViewTest {

    RootbeerBehindView view;

    @Mock
    RootbeerBehindController controller;

    @org.junit.Before
    public void setUp() throws Exception {
        controller = mock(RootbeerBehindController.class);
        view = new RootbeerBehindView(controller);
    }

    @org.junit.Test
    public void update() throws Exception {
        update_Submit();
        // Add more tests for additional actionCommands
    }

    /**
     * Test for actionCommand = "Submit"
     * Expected for textAreaOutput = Undecided
     * Expected for textAreaInput = Cleared except for prompt "> "
     */
    public void update_Submit() {
        //view.update(null, "Submit");
        //assertEquals("Input does not contain prompt '> '", "> ", view.getInputText());
    }
}