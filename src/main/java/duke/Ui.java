package duke;

import java.util.Scanner;

public class Ui {
    private final Scanner in = new Scanner(System.in);
    private static final String LINE = "____________________________________________________________";

    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm Anna!");
        System.out.println("What can i do for you?");
        System.out.println(LINE);
    }

    public void showLine() { System.out.println(LINE); }

    public String read() { return in.nextLine(); }

    public void showError(String msg) {
        showLine();
        System.out.println(" " + msg);
        showLine();
    }

    public void showBye() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void showList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int j = 0; j < tasks.size(); j++) {
            System.out.println((j + 1) + ". " + tasks.get(j));
        }
    }

    public void showMarked(Task t, boolean done) {
        System.out.println(done
                ? "Nice! I've marked this task as done:"
                : "OK, I've marked this task as not done yet:");
        System.out.println(t);
    }

    public void showAdded(Task t, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println(t);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public void showDeleted(Task t, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}