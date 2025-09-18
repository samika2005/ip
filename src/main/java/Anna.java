import duke.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
public class Anna {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = "____________________________________________________________";
    int len = line.length();
    System.out.println(line);
    System.out.println("Hello! I'm Anna!");
    System.out.println("What can i do for you?");
    System.out.println(line);
    int c = 0;
    ArrayList<Task> list = new ArrayList<>();
    int i = 0;
    while (true) {
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
               for (int j = 0; j < list.size(); j++) {
                   System.out.println((j + 1) + ". " + list.get(j).toString());
               }
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
               int index = skip.nextInt() - 1;
               if (index < 0 || index >= list.size()){
                   throw new DukeException("Did you even come up with that many tasks in the first place?" + index);
               }
               list.get(index).mark(true);
               System.out.println("Nice! I've marked this task as done:");
               System.out.println(list.get(index).toString());
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
               int index = skip.nextInt() - 1;
               if (index < 0 || index >= list.size()){
                   throw new DukeException("Did you even come up with that many tasks in the first place?" + index);
               }
               list.get(index).mark(false);
               System.out.println("OK, I've marked this task as not done yet:");
               System.out.println(list.get(index).toString());
               i--;
               continue;
           } else if (word.startsWith("delete")) {
               Scanner skip = new Scanner(word);
               skip.next();
               if (!skip.hasNextInt()) {
                   throw new DukeException("You know of numbers don't you? Use them.");
               }
               int index = skip.nextInt() - 1;
               if (index < 0 || index >= list.size()) {
                   throw new DukeException("Did you even come up with that many tasks in the first place?" + (index + 1));
               }
               Task removed = list.remove(index);
               System.out.println("Noted. I've removed this task:");
               System.out.println("  " + removed);
               System.out.println("Now you have " + list.size() + " tasks in the list.");
               continue;
           } else if (word.startsWith("todo")) {
               String description = word.substring(4).trim();
               Task task = new Todo(description);
               if (description.isEmpty()) {
                   throw new DukeException("I am in fact not capable of making up tasks");
               }
               System.out.println("Got it. I've added this task:");
               list.add(task);
               System.out.println(task.toString());
               System.out.println("Now you have " + list.size() + " tasks in the list.");
           } else if (word.startsWith("deadline")) {
               if (!word.contains("/by")) {
                   throw new DukeException("You're smart enough to use the right format aren't you?");
               }
               System.out.println("Got it. I've added this task:");
               String description = word.substring(9, word.indexOf('/')).trim();
               if (description.isEmpty()) {
                   throw new DukeException("Existential dread doesn't count, type in something adequate and preferably visible!");
               }
               String by = word.substring(word.indexOf('/') + 3).trim();
               if (by.isEmpty()) {
                   throw new DukeException("Planning to procrastinate huh?");
               }
               Task task = new Deadline(description, by);
               list.add(task);
               System.out.println(task.toString());
               System.out.println("Now you have " + list.size() + " tasks in the list.");
           } else if (word.startsWith("event")) {
               if (!word.contains("/from") || !word.contains("/to")) {
                   throw new DukeException("ain't got a timeframe?");
               }
               System.out.println("Got it. I've added this task:");
               String description = word.substring(5, word.indexOf('/')).trim();
               if (description.isEmpty()) {
                   throw new DukeException("No event in mind at all?");
               }
               String from = word.substring(word.indexOf('/') + 6, word.lastIndexOf('/')).trim();
               String to = word.substring(word.lastIndexOf('/') + 3).trim();
               if (from.isEmpty() || to.isEmpty()) {
                   throw new DukeException("Forever ain't a timeframe, use the typical hours like a normal person!");
               }
               Task task = new Event(description, from, to);
               list.add(task);
               System.out.println(task.toString());
               System.out.println("Now you have " + list.size() + " tasks in the list.");
           } else {
               throw new DukeException("I've got no clue what you're possibly tryna do");
           }
       } catch (DukeException e) {
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
