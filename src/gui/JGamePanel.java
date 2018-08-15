package gui;

import core.DynamicMapInformation;
import core.GameField;
import core.TileType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class JGamePanel extends JPanel {

    private Canvas drawingC;
    private BufferStrategy bStrategy;
    private Graphics panelGraphics;

    private float scale = 100f;

    private JGamePanel() {
        super();
        drawingC = new Canvas();
        drawingC.setPreferredSize(this.getPreferredSize());
        drawingC.setMinimumSize(this.getMinimumSize());
        drawingC.setMaximumSize(this.getMaximumSize());

        bStrategy = drawingC.getBufferStrategy();
        this.add(drawingC);
    }

    public static JGamePanel create() {
        return new JGamePanel();
    }

    public synchronized void render(GameField gf, DynamicMapInformation dynMapInfo) {
        if (drawingC.getBufferStrategy() == null) {
            drawingC.createBufferStrategy(2);
        }
        bStrategy = drawingC.getBufferStrategy();
        panelGraphics = bStrategy.getDrawGraphics();

        int tileWidth = Math.round(this.getWidth()/ gf.size(GameField.X)),
        tileHeight = Math.round(this.getHeight()/ gf.size(GameField.Y));

        //Vorruebergehende Loesung
        for (int x = 0; x < gf.size(GameField.X); x++) {
            for (int y = 0; y < gf.size(GameField.Y); y++) {
                drawSquare(panelGraphics, new Point((x * tileWidth), (y * tileHeight)), new Dimension(tileWidth, tileHeight), gf.getTypeByCoordinates(x, y));
            }
        }

        bStrategy.show();
        panelGraphics.dispose();
    }

    private void drawSquare(Graphics g, Point targetOrigin, Dimension size, TileType type) {
        Color oldColor = g.getColor();
        g.setColor(new Color(230, 230, 230));
        g.drawRect(targetOrigin.x, targetOrigin.y, size.width, size.height);
        g.setColor(type.getColor());
        g.drawRect(targetOrigin.x+1, targetOrigin.y+1, size.width - 2, size.height - 2);
        g.setColor(oldColor);
    }
}