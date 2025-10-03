package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles loading and saving of tasks from/to a file.
 * <p>
 * The {@code Storage} class is responsible for:
 * <ul>
 *   <li>Reading tasks from a specified file when the chatbot starts.</li>
 *   <li>Writing tasks back into the file whenever the list is updated.</li>
 * </ul>
 * This ensures that tasks persist between different runs of the chatbot.
 * </p>
 */
public class Storage {
    private final String filePath;

    /**
     * Creates a new {@code Storage} object with the given file path.
     *
     * @param filePath the path of the file used to load and save tasks
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the file.
     * <p>
     * If the file does not exist, it creates a new file (and the parent
     * directory if missing). Each line in the file is parsed into a
     * {@link Task} using {@link Parser#parseTaskFromSave(String)}.
     * </p>
     *
     * @return a {@code List<Task>} containing all tasks from the file
     * @throws IOException    if there is an error reading from the file
     * @throws DukeException  if the file contents cannot be parsed properly
     */
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
                Task t = Parser.parseTaskFromSave(line);
                tasks.add(t);
            }
        }
        return tasks;
    }

    /**
     * Saves the given list of tasks into the file.
     * <p>
     * Each task is written in the format returned by
     * {@link Task#toSaveFormat()}, followed by a newline.
     * </p>
     *
     * @param tasks the list of tasks to save
     * @throws IOException if there is an error writing to the file
     */
    public void save(List<Task> tasks) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.toSaveFormat());
                writer.write(System.lineSeparator());
            }
        }
    }
}