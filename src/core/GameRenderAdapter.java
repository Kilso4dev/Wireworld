package core;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameRenderAdapter {

    protected float scale = 100f;
    protected GameField fieldReference;
    protected BufferedImage renderedField;
    protected Graphics renderGraphics;

    protected GameRenderAdapter(GameField fieldRef) {
        this.fieldReference = fieldRef;
        renderedField = new BufferedImage(fieldReference.size(GameField.X), fieldReference.size(GameField.Y), BufferedImage.TYPE_INT_RGB);
        renderGraphics = renderedField.getGraphics();

    }

    public static GameRenderAdapter createByGameField(GameField fieldRef) {
        return new GameRenderAdapter(fieldRef);
    }

    public BufferedImage getSubimage(DynamicMapInformation dynMapInfo, double relation) {
        //TODO
        dynMapInfo.
        return renderedField.getSubimage(x, y, width, height);
    }

    public synchronized BufferedImage updateGraphics() {
        for (int x = 0; x < fieldReference.size(GameField.X); x++) {
            for (int y = 0; y < fieldReference.size(GameField.Y); y++) {
                renderGraphics.setColor(fieldReference.getTypeByCoordinates(x, y).getColor());
                renderGraphics.drawRect(x, y, 1, 1);
            }
        }
        return renderedField;
    }
}
