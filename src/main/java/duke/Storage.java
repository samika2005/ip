package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    // Loads tasks from file
    public List<Task> load() throws IOException, DukeException {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            File parent = file.getParentFile();
            if (parent != null) parent.mkdirs();  // create "data" folder if missing
            file.createNewFile();
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                Task t = parseTaskFromSave(line);
                tasks.add(t);
            }
        }
        return tasks;
    }

    private Task parseTaskFromSave(String line) throws DukeException {
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

    // Saves tasks to file
    public void save(List<Task> tasks) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.toSaveFormat());
                writer.write(System.lineSeparator());
            }
        }
    }
}