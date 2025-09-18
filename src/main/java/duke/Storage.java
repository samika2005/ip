package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    //Loads tasks from file
    public ArrayList<String> load() throws IOException {
        ArrayList<String> tasks = new ArrayList<>();
        File file = new File(filePath);

        // f the file doesn't exist, create the file
        if (!file.exists()) {
            file.getParentFile().mkdirs(); //creates "data" folder if missing
            file.createNewFile();
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            tasks.add(scanner.nextLine());
        }
        scanner.close();
        return tasks;
    }

    //Saves tasks to file
    public void save(ArrayList<String> tasks) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (String task : tasks) {
            writer.write(task + System.lineSeparator());
        }
        writer.close();
    }
}