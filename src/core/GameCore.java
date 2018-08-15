package core;

import gui.Window;
import help.WORK;

import java.awt.*;

public class GameCore extends Thread {
    static final long SEC_IN_NANO = (long)1e9;
    static final int GAME_FPS = 200;

    private boolean running = false, finalize = false;
    private int fpsCounter;

    private int maxAreaWidth;

    Window gameWindow;
    GameField gameField;

    InputHandler input;

    private GameCore(String[] args) {
        if (args.length >= 1) {
            maxAreaWidth = Integer.parseInt(args[0]);
        } else {
            System.out.println("Couldn't parse Field width, using standard of 50 x 50");
            maxAreaWidth = 50;
        }

        gameWindow = Window.createByName("Testfenster");
        gameField = GameField.create();
        input = InputHandler.create();

    }

    public static GameCore createByCmdArgs(String[] args) {
        return new GameCore(args);
    }

    public void start() {
        init();
        running = true;
        run();
    }

    public void run() {
        int fps = 200;
        long beforeLoop = System.nanoTime(), inLoop, lastFPSTime = System.nanoTime(), newFPSTime;
        double deltaPercentage = 0;

        while(!finalize) {
            if (running) {
                inLoop = System.nanoTime();
                deltaPercentage += ((inLoop - beforeLoop) * fps) / 1e9;

                if (deltaPercentage >= 1) {
                    {
                        newFPSTime = System.nanoTime();
                        try {
                            fpsCounter = (int) (1 / ((newFPSTime - lastFPSTime) * 1e-9));
                            System.out.print("FPS: " + fpsCounter + "   \n");
                        } catch (ArithmeticException ae) {
                            System.out.println("No valid FPS");
                        }
                        lastFPSTime = newFPSTime;
                    }

                    tick();
                    render();


                    deltaPercentage--;
                }
                beforeLoop = inLoop;
            }
        }
    }


    private void init() {
        gameWindow.setVisible(true);
    }
    public void pause() {
        running = false;
    }
    public void restart() {
        running = true;
    }



    public void tick() {

    }

    public void render() {
        gameWindow.renderGUI(gameField, input.updateInput());
    }


}
