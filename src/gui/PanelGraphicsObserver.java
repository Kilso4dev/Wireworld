package gui;

import help.WORK;

import java.awt.*;
import java.awt.image.ImageObserver;

@WORK //TODO
public class PanelGraphicsObserver implements ImageObserver {
    @Override
    public boolean imageUpdate(Image image, int x1, int y1, int i2, int i3, int i4) {
        image.getGraphics().drawRect(, , , );

        return false;
    }
}
