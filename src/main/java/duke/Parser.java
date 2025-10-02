package duke;

public class Parser {

    public static boolean isBye(String s)      { return s.equals("bye"); }
    public static boolean isList(String s)     { return s.equals("list"); }
    public static boolean isMark(String s)     { return s.startsWith("mark"); }
    public static boolean isUnmark(String s)   { return s.startsWith("unmark"); }
    public static boolean isDelete(String s)   { return s.startsWith("delete"); }
    public static boolean isTodo(String s)     { return s.startsWith("todo"); }
    public static boolean isDeadline(String s) { return s.startsWith("deadline"); }
    public static boolean isEvent(String s)    { return s.startsWith("event"); }

    /** Parses 1-based index after mark/unmark/delete. */
    public static int parseIndex1Based(String line) throws DukeException {
        String[] parts = line.trim().split("\\s+");
        if (parts.length < 2) throw new DukeException("Finish the sentence!!");
        try {
            int idx = Integer.parseInt(parts[1]);
            if (idx <= 0) throw new NumberFormatException();
            return idx;
        } catch (NumberFormatException e) {
            throw new DukeException("You know of numbers don't you? Use them.");
        }
    }

    /** Builds a Task from todo/deadline/event*/
    public static Task parseTask(String line) throws DukeException {
        if (isTodo(line)) {
            String description = line.substring(4).trim();
            if (description.isEmpty()) throw new DukeException("I am in fact not capable of making up tasks");
            return new Todo(description);
        }
        if (isDeadline(line)) {
            if (!line.contains("/by")) throw new DukeException("You're smart enough to use the right format aren't you?");
            String description = line.substring(9, line.indexOf('/')).trim();
            if (description.isEmpty()) throw new DukeException("Existential dread doesn't count, type in something adequate and preferably visible!");
            String by = line.substring(line.indexOf("/by") + 3).trim();
            if (by.isEmpty()) throw new DukeException("Planning to procrastinate huh?");
            return new Deadline(description, by);
        }
        if (isEvent(line)) {
            if (!line.contains("/from") || !line.contains("/to")) throw new DukeException("ain't got a timeframe?");
            String description = line.substring(6, line.indexOf('/')).trim();
            if (description.isEmpty()) throw new DukeException("No event in mind at all?");
            String from = line.substring(line.indexOf("/from") + 5, line.lastIndexOf('/')).trim();
            String to   = line.substring(line.lastIndexOf("/to") + 3).trim();
            if (from.isEmpty() || to.isEmpty()) throw new DukeException("Forever ain't a timeframe, use the typical hours like a normal person!");
            return new Event(description, from, to);
        }
        throw new DukeException("I've got no clue what you're possibly tryna do");
    }
}