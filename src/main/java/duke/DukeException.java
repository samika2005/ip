package duke;

/**
 * Represents an exception specific to the Anna chatbot.
 * <p>
 * This exception is thrown when the user provides invalid commands,
 * malformed input, or when storage/parsing fails in a way that Anna
 * cannot recover from gracefully.
 * </p>
 */
public class DukeException extends Exception {

    /**
     * Creates a new {@code DukeException} with the specified detail message.
     *
     * @param message the error message that explains the cause of the exception
     */
    public DukeException(String message) {
        super(message);
    }
}

