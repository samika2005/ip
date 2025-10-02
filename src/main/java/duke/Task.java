package duke;

/**
 * Represents a generic task with a description and a completion status.
 * This is the superclass for more specific task types such as
 * {@link Todo}, {@link Deadline}, and {@link Event}.
 */
public class Task {
    protected String word;
    /** Whether the task is marked as done. */
    protected boolean isDone;

    /**
     * Creates a new task with the given description.
     * By default, the task is not marked as done.
     *
     * @param word Description of the task.
     */
    public Task(String word) {
        this.word = word;
        this.isDone = false;
    }

    /**
     * Marks or unmarks this task as done.
     *
     * @param done {@code true} to mark the task as done, {@code false} otherwise.
     */
    public void mark(boolean done) {
        this.isDone = done;
    }

/**
 * Returns the task's completion status in save format.
 *
 * @return "1" if the task is done, "0" otherwise.
 */
    public String statusBit() {
        return (isDone ? "1" : "0");
    }

    /**
     * Returns the string format used for saving this task to file.
     *
     * @return Save format string containing the completion status and description.
     */
    public String toSaveFormat() {
        return (isDone ? "1 | " : "0 | ") + word;
    }

    /**
     * Returns a string representation of the task, including its status.
     *
     * @return A string in the format "[X] description" if done,
     *         or "[ ] description" if not done.
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + word;
        } else {
            return "[ ] " + word;
        }
    }
}
