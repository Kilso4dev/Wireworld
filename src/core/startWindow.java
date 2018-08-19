package core;


public class startWindow {
    public static void main(String[] args) {
        GameCore game = GameCore.createByCmdArgs(args);
        game.start();
    }
}
