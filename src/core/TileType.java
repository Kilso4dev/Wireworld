package core;

import java.awt.*;

public enum TileType {
    EMPTY((byte) 0, new Color(25, 25, 25)),
    CONDUCTOR((byte) 1, new Color(219, 179, 0)),
    ELECTRON_HEAD((byte) 2, new Color(0, 106, 206)),
    ELECTRON_TRAIL((byte) 3, new Color(156, 32, 22));

    private byte id;
    private Color color;

    TileType(byte id, Color tileColor) {
        this.id = id;
    }


    public byte getId() {
        return id;
    }
    public Color getColor() {
        return color;
    }

    static TileType parseByte(byte b) {
        switch (b) {
            case (byte)0: {
                return TileType.EMPTY;
            }
            case (byte)1: {
                return TileType.CONDUCTOR;
            }
            case (byte)2: {
                return TileType.ELECTRON_HEAD;
            }
            case (byte)3: {
                return TileType.ELECTRON_TRAIL;
            }
            default: {
                throw new NumberFormatException("No TileType ID found for inserted byte: " + b);
            }
        }
    }
}
