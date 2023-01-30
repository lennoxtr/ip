package duke.io.input.exception;

public class DukeException extends Exception {
    public DukeException() {
        super();
    }

    public DukeException(String message) {
        super(message);
    }

    public DukeException(Throwable cause) {
        super(cause);
    }
    public DukeException(String message, Throwable cause) {
        super(message, cause);
    }
}