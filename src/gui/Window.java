package gui;

import core.DynamicMapInformation;
import core.GameField;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JMenuBar windowMenuBar;

    private JMenuItem[] menuItems;
    private final String[] menuEntries = {
            "Conductor",
            "Electron",
            "Delete",
            "Start"
    };

    private Container c;
    private JGamePanel gameGUI;


    private Window(String name) {
        super(name);
        c = this.getContentPane();
        this.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.setSize(new Dimension((Toolkit.getDefaultToolkit().getScreenSize().width / 2), (Toolkit.getDefaultToolkit().getScreenSize().height / 2)));
  private final String[] menuEntries = {
            "Conductor",
            "Electron",
            "Delete",
            "Start"
    };
        initializeWindowMenu();

        gameGUI = JGamePanel.create();
        c.add(gameGUI, BorderLayout.CENTER);
    }

    public static Window createByName(String windowName) {
        return new Window(windowName);
    }


    private void initializeWindowMenu() {
        menuItems = new JMenuItem[menuEntries.length];
        windowMenuBar = new JMenuBar();
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i] = new JMenuItem(menuEntries[i]);
            windowMenuBar.add(menuItems[i]);
        }

        setJMenuBar(windowMenuBar);
    }

    public JGamePanel getGamePanel() {
        return gameGUI;
    }

    public void renderGUI(GameField gf, DynamicMapInformation dynMapInfo) {
        gameGUI.render(gf, dynMapInfo);
    }
}