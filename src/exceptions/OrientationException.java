package exceptions;

public class OrientationException extends RuntimeException {
    private OrientationException(String msg) {
        super(msg);
    }

    public static OrientationException createByMessage(String msg) {
        return new OrientationException(msg);
    }
    public static OrientationException create() {
        return OrientationException.createByMessage("");
    }
}
