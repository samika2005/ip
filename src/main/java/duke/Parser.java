package duke;

/**
 * Utility class that handles parsing of stored task data
 * back into {@link Task} objects.
 */
public class Parser {

    /**
     * Parses a line from the save file and reconstructs the
     * appropriate {@link Task} object (Todo, Deadline, or Event).
     *
     * <p>
     * Each line is expected to follow the format:
     * <ul>
     *     <li>{@code T | 0/1 | description}</li>
     *     <li>{@code D | 0/1 | description | by}</li>
     *     <li>{@code E | 0/1 | description | from | to}</li>
     * </ul>
     * where:
     * <ul>
     *     <li>The first token is the task type ({@code T}, {@code D}, or {@code E}).</li>
     *     <li>The second token is {@code 1} if the task is done, {@code 0} otherwise.</li>
     *     <li>The rest are task-specific details.</li>
     * </ul>
     * </p>
     *
     * @param line A single line from the save file.
     * @return A reconstructed {@link Task}.
     * @throws DukeException If the line is invalid or cannot be parsed.
     */
    public static Task parseTaskFromSave(String line) throws DukeException {
        String cleaned = line.replace("\uFEFF", "").trim();
        String[] parts = cleaned.split("\\s*\\|\\s*");

        if (parts.length < 3) throw new DukeException("Bad save line: " + line);

        String type = parts[0].trim();
        boolean done = parts[1].trim().equals("1");
        String desc = parts[2];

        switch (type) {
            case "T":
                Todo t = new Todo(desc);
                t.mark(done);
                return t;
            case "D":
                if (parts.length < 4) throw new DukeException("Bad deadline line: " + line);
                Deadline d = new Deadline(desc, parts[3]);
                d.mark(done);
                return d;
            case "E":
                if (parts.length < 5) throw new DukeException("Bad event line: " + line);
                Event e = new Event(desc, parts[3], parts[4]);
                e.mark(done);
                return e;
            default:
                throw new DukeException("Unknown task type: '" + type + "'");
        }
    }


}
