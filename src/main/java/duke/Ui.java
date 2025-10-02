package duke;

/**
 * Handles all interactions with the user by displaying messages and formatting output.
 */
public class Ui {
    private static final String LINE = "____________________________________________________________";

    /**
     * Prints the welcome message when the chatbot starts.
     */
    public void showWelcome() {
        System.out.println(LINE);
        System.out.println("Hello! I'm Anna!");
        System.out.println("What can i do for you?");
        System.out.println(LINE);
    }

    /**
     * Prints a horizontal line separator.
     */
    public void showLine() { System.out.println(LINE); }



/**
 * Prints an error message surrounded by separator lines.
 *
 * @param msg The error message to display.
 */
    public void showError(String msg) {
        showLine();
        System.out.println(" " + msg);
        showLine();
    }

    /**
     * Prints the goodbye message when the chatbot exits.
     */
    public void showBye() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    /**
     * Prints all the tasks currently in the task list.
     *
     * @param tasks The list of tasks to display.
     */
    public void showList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int j = 0; j < tasks.size(); j++) {
            System.out.println((j + 1) + ". " + tasks.get(j));
        }
    }


    /**
     * Prints a confirmation message when a task is deleted.
     *
     * @param t    The task that was removed.
     * @param size The number of tasks remaining in the list.
     */
    public void showDeleted(Task t, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + size + " tasks in the list.");
    }
}