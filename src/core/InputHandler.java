package core;

import java.awt.*;

public class InputHandler {

    private Point mousePos;

    private InputHandler() {

    }
    public static InputHandler create() {
        return new InputHandler();
    }


    public synchronized DynamicMapInformation updateInput() {
        return DynamicMapInformation.create();
    }
}
