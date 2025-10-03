package duke;

/**
 * Represents a simple task without any time constraint.
 * <p>
 * A {@code Todo} is a {@link Task} that only has a description.
 * It overrides {@code toSaveFormat()} to provide a string suitable
 * for saving to file, and {@code toString()} for displaying to the user.
 * </p>
 */
public class Todo extends Task {

    /**
     * Creates a new Todo task with the given description.
     *
     * @param description The description of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the string representation of this todo task
     * in a format suitable for saving to storage.
     *
     * @return A string in the format: {@code T | 0/1 | description}.
     */
    @Override
    public String toSaveFormat() {
        return "T | " + statusBit() + " | " + word;
    }

    /**
     * Returns the string representation of this todo task
     * for displaying to the user.
     *
     * @return A string in the format: {@code [T][ ] description}.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
