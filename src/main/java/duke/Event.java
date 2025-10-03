package duke;

/**
 * Represents an {@link Task} with a start and end time.
 * <p>
 * An {@code Event} has a description, a start time, and an end time
 * to indicate when the event occurs.
 * </p>
 */
public class Event extends Task {
    protected String from;
    protected String to;

/**
 * Creates a new {@code Event}.
 *
 * @param description description of the event
 * @param from        the start time of the event
 * @param to          the end time of the event
 */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }


    /**
     * Returns the string representation of this event in the format
     * used for saving to file.
     *
     * @return formatted string for saving
     */
    @Override
    public String toSaveFormat() {
        return "E | " + statusBit() + " | " + word + " | " + from + " | " + to;
    }


    /**
     * Returns a user-friendly string representation of this event.
     *
     * @return formatted string for display
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to +  ")";
    }
}

