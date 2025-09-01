import java.util.*;
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
    Task[] list = new Task[100];
    for (int i = 1; i <= 100; i++) {
    String word = in.nextLine();
    c = c + 5;
    list[i] = new Task(word);
    if(word.equals("bye")) {
    break;
    }
    else {
        if((c%len) >= (len-5)) {
            c = 0;
        }
        System.out.println(line.substring(0,c) + "(._.)" + line.substring(c+5,len));
        if(word.equals("list")) {
            System.out.println("Here are the tasks in your list:");
            for(int j=1;j<i;j++) {
                System.out.println(j+". " + list[j].toString());
            }
            i = i - 1;
            continue;
        }
        else if(word.startsWith("mark")) {
            Scanner skip = new Scanner(word);
            skip.next();
            int index = skip.nextInt();
            list[index].mark(true);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(list[index].toString());
            i--;
            continue;
        }
        else if(word.startsWith("unmark")) {
            Scanner skip = new Scanner(word);
            skip.next();
            int index = skip.nextInt();
            list[index].mark(false);
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(list[index].toString());
            i--;
            continue;
        }
        else if(word.startsWith("todo")){
            System.out.println("Got it. I've added this task:");
            String description = word.substring(5);
            list[i] = new Todo(description);
            System.out.println(list[i].toString());
            System.out.println("Now you have " + i + " tasks in the list.");
        }
        else if(word.startsWith("deadline")) {
            System.out.println("Got it. I've added this task:");
            String description = word.substring(9,word.indexOf('/'));
            String by = word.substring(word.indexOf('/') + 3);
            list[i] = new Deadline(description,by);
            System.out.println(list[i].toString());
            System.out.println("Now you have " + i + " tasks in the list.");
        }
        else if(word.startsWith("event")) {
            System.out.println("Got it. I've added this task:");
            String description = word.substring(6,word.indexOf('/'));
            String from = word.substring(word.indexOf('/') + 5, word.lastIndexOf('/'));
            String to = word.substring(word.lastIndexOf('/') + 3);
            list[i] = new Event(description,from,to);
            System.out.println(list[i].toString());
            System.out.println("Now you have " + i + " tasks in the list.");
        }
        else{
            i--;
        }
        System.out.println(line.substring(0,c) + "(._.)" + line.substring(c+5,len));
    }
    }
    System.out.println(line);
    System.out.println("Bye. Hope to see you again soon!");
    System.out.println(line);
    }
}
