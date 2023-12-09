package utility.exception;

public class ShotFileException extends RuntimeException {
    public ShotFileException() {
        super();
    }

    public ShotFileException(String message) {
        super(message);
    }

    public ShotFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShotFileException(Throwable cause) {
        super(cause);
    }
}
