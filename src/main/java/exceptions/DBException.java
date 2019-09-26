package exceptions;

public class DBException extends Exception {
    public DBException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DBException(String message) {
        super(message);
    }
}
