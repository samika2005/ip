import duke.*;
import java.io.IOException;
import java.util.*;
import java.lang.*;
public class Anna {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Storage storage = new Storage("./data/anna.txt");
    ArrayList<String> loadedTasks;
    try {
        loadedTasks = storage.load();
        System.out.println("Loaded tasks from file:");
        for (String task : loadedTasks) {
            System.out.println(task);
        }
      } catch(IOException e) {
        System.out.println("Error loading file: " + e.getMessage());
        loadedTasks = new ArrayList<>();
       }

    String line = "____________________________________________________________";
    int len = line.length();
    System.out.println(line);
    System.out.println("Hello! I'm Anna!");
    System.out.println("What can i do for you?");
    System.out.println(line);
    int c = 0;
    Task[] list = new Task[100];
    for (int i = 1; i <= 100; i++) {
    String word = in.nextLine();
    c = c + 5;
    if(word.equals("bye")) {
    break;
    }
    else {
        if((c%len) >= (len-5)) {
            c = 0;
        }
        System.out.println(line.substring(0,c) + "(._.)" + line.substring(c+5,len));
       try {
           if (word.equals("list")) {
               System.out.println("Here are the tasks in your list:");
               for (int j = 1; j < i; j++) {
                   System.out.println(j + ". " + list[j].toString());
               }
               i = i - 1;
               continue;
           } else if (word.startsWith("mark")) {
               Scanner skip = new Scanner(word);
               if (!skip.hasNext()) {
                   throw new DukeException("Finish the sentence!!");
               }
               skip.next();
               if (!skip.hasNextInt()) {
                   throw new DukeException("You know of numbers don't you? Use them.");
               }
               int index = skip.nextInt();
               if (index < 1 || index >= i || list[index] == null){
                   throw new DukeException("Did you even come up with that many tasks in the first place?" + index);
               }
               list[index].mark(true);
               System.out.println("Nice! I've marked this task as done:");
               System.out.println(list[index].toString());
               i--;
               continue;
           } else if (word.startsWith("unmark")) {
               Scanner skip = new Scanner(word);
               if (!skip.hasNext()) {
                   throw new DukeException("Finish the sentence!!");
               }
               skip.next();
               if (!skip.hasNextInt()) {
                   throw new DukeException("You know of numbers don't you? Use them.");
               }
               int index = skip.nextInt();
               if (index < 1 || index >= i || list[index] == null){
                   throw new DukeException("Did you even come up with that many tasks in the first place?" + index);
               }
               list[index].mark(false);
               System.out.println("OK, I've marked this task as not done yet:");
               System.out.println(list[index].toString());
               i--;
               continue;
           } else if (word.startsWith("todo")) {
               list[i] = new Task(word);
               String description = word.substring(4);
               if (description.isEmpty()) {
                   throw new DukeException("I am in fact not capable of making up tasks");
               }
               System.out.println("Got it. I've added this task:");
               list[i] = new Todo(description);
               System.out.println(list[i].toString());
               System.out.println("Now you have " + i + " tasks in the list.");
           } else if (word.startsWith("deadline")) {
               if (!word.contains("/by")) {
                   throw new DukeException("You're smart enough to use the right format aren't you?");
               }
               list[i] = new Task(word);
               System.out.println("Got it. I've added this task:");
               String description = word.substring(9, word.indexOf('/'));
               if (description.isEmpty()) {
                   throw new DukeException("Existential dread doesn't count, type in something adequate and preferably visible!");
               }
               String by = word.substring(word.indexOf('/') + 3);
               if (by.isEmpty()) {
                   throw new DukeException("Planning to procrastinate huh?");
               }
               list[i] = new Deadline(description, by);
               System.out.println(list[i].toString());
               System.out.println("Now you have " + i + " tasks in the list.");
           } else if (word.startsWith("event")) {
               if (!word.contains("/from") || !word.contains("/to")) {
                   throw new DukeException("ain't got a timeframe?");
               }
               list[i] = new Task(word);
               System.out.println("Got it. I've added this task:");
               String description = word.substring(6, word.indexOf('/'));
               if (description.isEmpty()) {
                   throw new DukeException("No event in mind at all?");
               }
               String from = word.substring(word.indexOf('/') + 5, word.lastIndexOf('/'));
               String to = word.substring(word.lastIndexOf('/') + 3);
               if (from.isEmpty() || to.isEmpty()) {
                   throw new DukeException("Forever ain't a timeframe, use the typical hours like a normal person!");
               }
               list[i] = new Event(description, from, to);
               System.out.println(list[i].toString());
               System.out.println("Now you have " + i + " tasks in the list.");
           } else {
               i--;
               throw new DukeException("I've got no clue what you're possibly tryna do");
           }
       } catch (DukeException e) {
           i--;
           System.out.println(line);
           System.out.println(" " + e.getMessage());
           System.out.println(line);
       }
        System.out.println(line.substring(0,c) + "(._.)" + line.substring(c+5,len));
    }
    }
    System.out.println(line);
    System.out.println("Bye. Hope to see you again soon!");
    System.out.println(line);
    }
}
