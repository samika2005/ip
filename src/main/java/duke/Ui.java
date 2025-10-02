package duke;

public class Ui {
    private static final String LINE = "____________________________________________________________";

    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm Anna!");
        System.out.println("What can i do for you?");
        System.out.println(LINE);
    }

    public void showLine() { System.out.println(LINE); }

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

    public void showDeleted(Task t, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}