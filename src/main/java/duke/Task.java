package duke;

public class Task {
    protected String word;
    protected boolean isDone;

    public Task(String word) {
        this.word = word;
        this.isDone = false;
    }

    public void mark(boolean done) {
        this.isDone = done;
    }

    public String statusBit() {
        return (isDone ? "1" : "0");
    }

    public String toSaveFormat() {
        return (isDone ? "1 | " : "0 | ") + word;
    }

    public static Task fromSave(String line) throws DukeException {
        // T|0|desc
        // D|1|desc|by text
        // E|0|desc|from text|to text
        String[] parts = line.split("\\|", -1);
        if (parts.length < 3) throw new DukeException("Bad save line: " + line);
        String type = parts[0];
        boolean done = "1".equals(parts[1]);
        String desc = parts[2];

        Task t;
        switch (type) {
            case "T":
                t = new Todo(desc);
                break;
            case "D":
                if (parts.length < 4) throw new DukeException("Bad deadline line: " + line);
                t = new Deadline(desc, parts[3]);
                break;
            case "E":
                if (parts.length < 5) throw new DukeException("Bad event line: " + line);
                t = new Event(desc, parts[3], parts[4]);
                break;
            default:
                throw new DukeException("Unknown task type: " + type);
        }
        t.mark(done);
        return t;
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + word;
        } else {
            return "[ ] " + word;
        }
    }
}
