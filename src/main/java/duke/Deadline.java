package duke;

/**
 * Represents a task with a deadline.
 * <p>
 * A {@code Deadline} is a {@link Task} that includes a description and a "by" time
 * indicating the deadline. It overrides {@code toSaveFormat()} to provide a string
 * suitable for saving to file, and {@code toString()} for display to the user.
 * </p>
 */

public class Deadline extends Task {
    protected String by;

    /**
     * Creates a new Deadline task with the given description and deadline.
     *
     * @param description The description of the deadline task.
     * @param by The time or date by which the task should be completed.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }


/**
 * Returns the string representation of this deadline task
 * in a format suitable for saving to storage.
 *
 * @return A string in the format: {@code D | 0/1 | description | by}.
 */
    @Override
    public String toSaveFormat() {
        return "D | " + statusBit() + " | " + word + " | " + by;
    }

    /**
     * Returns the string representation of this deadline task
     * for displaying to the user.
     *
     * @return A string in the format: {@code [D][ ] description (by: time)}.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
