package core;

import help.Problematic;

import java.awt.*;

public enum TileType {
    EMPTY(new Color(25, 25, 25)),
    CONDUCTOR(new Color(219, 179, 0)),
    ELECTRON_HEAD(new Color(0, 106, 206)),
    ELECTRON_TRAIL(new Color(156, 32, 22));

    private Color color;

    TileType(Color tileColor) {
        this.color = tileColor;
    }


    public byte getId() {
        return (byte) this.ordinal();
    }
    public Color getColor() {
        return color;
    }

    //TODO?
    @Problematic
    static TileType parseByte(byte b) {
        for (TileType cType : TileType.values()) {
            if(cType.ordinal() == b) {
                return cType;
            }
        }
        throw new NumberFormatException("No TileType ID found for inserted byte: " + b);
    }
}
