package core;

import java.awt.*;
import java.text.ParseException;

public enum Direction {
    NORTH(0,-1),
    NORTH_EAST(1,-1),
    EAST(1,0),
    SOUTH_EAST(1,1),
    SOUTH(0,1),
    SOUTH_WEST(-1,1),
    WEST(-1,0),
    NORTH_WEST(-1,-1);

    private int dx, dy;

    Direction(int x, int y) {
        dx = x;
        dy = y;
    }

    public Point getDeltaPos() {
        return new Point(dx, dy);
    }

    public Direction parseDirectionByOrdinal(int o) throws ParseException {
        for (Direction cDirection: Direction.values()) {
            if (cDirection.ordinal() == 0) {
                return cDirection;
            }
        }
        throw new ParseException("Ordinal not Available", o);
    }
}