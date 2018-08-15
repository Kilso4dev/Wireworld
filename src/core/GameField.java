package core;

import exceptions.OrientationException;
import javafx.geometry.Orientation;

import java.util.ArrayList;

public class GameField {
    public static final int X = 1, Y = 2;

    byte[][] fieldCoordinates;

    private GameField() {
        fieldCoordinates  = new byte[10][10];
    }

    public static GameField create() {
        return new GameField();
    }


    public TileType getTypeByCoordinates(int x, int y) throws IndexOutOfBoundsException {
        try {
            return TileType.parseByte(fieldCoordinates[x][y]);
        } catch (NumberFormatException nfe) {
            System.out.println("Read a wrong Byte from the Field Array");
            nfe.printStackTrace();
        }
        return null;
    }


    public void setFieldCoordinates(int x, int y, TileType newType) {
        if (fieldCoordinates.length <= x) {
            if (fieldCoordinates[x].length <= y) {
                fieldCoordinates[x][y] = newType.getId();
            } else {
                //--> Extend y to length of var y
            }

        } else  {
            if (fieldCoordinates[x].length <= y) {
                //--> Extend x to length of var x
            } else {
                //--> Extend both, x and y to length of var x and var y
            }
        }
    }

    public int size(int orientation) throws OrientationException {
        if (orientation == X) {
            return fieldCoordinates.length;
        } else if (orientation == Y) {
            return fieldCoordinates[0].length;
        } else throw OrientationException.createByMessage("Wrong orientation");
    }
}
