package core;

import java.awt.*;

public class DynamicMapInformation {
    private Point renderOrigin, mousePosition;
    private double scale;

    private DynamicMapInformation() {

    }

    public static DynamicMapInformation create() {
        return new DynamicMapInformation();
    }

}
