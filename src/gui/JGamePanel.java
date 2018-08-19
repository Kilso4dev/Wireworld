package gui;

import core.DynamicMapInformation;
import core.GameField;
import core.GameRenderAdapter;
import core.TileType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class JGamePanel extends JPanel {

    protected Canvas drawingC;
    protected BufferStrategy bStrategy;
    protected GameRenderAdapter renderAdapter;
    protected Graphics panelGraphics;

    protected JGamePanel(GameRenderAdapter gra) {
        super();
        this.renderAdapter = gra;
        drawingC = new Canvas();
        drawingC.setPreferredSize(this.getPreferredSize());
        drawingC.setMinimumSize(this.getMinimumSize());
        drawingC.setMaximumSize(this.getMaximumSize());

        bStrategy = drawingC.getBufferStrategy();
        this.add(drawingC);
    }

    public static JGamePanel createByGameRenderAdapter(GameRenderAdapter gra) {
        return new JGamePanel(gra);
    }

    public synchronized void updateRender(GameField gf, DynamicMapInformation dynMapInfo) {
        if (drawingC.getBufferStrategy() == null) {
            drawingC.createBufferStrategy(2);
        }
        bStrategy = drawingC.getBufferStrategy();
        panelGraphics = bStrategy.getDrawGraphics();

        double relation = gf.size(GameField.Y)/ gf.size(GameField.X); //y = x * relation

        renderAdapter.updateGraphics();
        panelGraphics.drawImage(renderAdapter.getSubimage(dynMapInfo, relation), /*??*/, /*??*/, null);

        bStrategy.show();
        panelGraphics.dispose();
    }
}