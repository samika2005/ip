package duke;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of {@link Task} objects.
 * <p>
 * Provides methods to add, remove, retrieve, and get the size of the task list.
 * Used as the main data structure to store tasks during program execution.
 * </p>
 */
public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() { }

/**
 * Creates a task list with the given initial tasks.
 *
 * @param initial A list of tasks to populate the task list with.
 */
    public TaskList(List<Task> initial) {
        tasks.addAll(initial);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the task at the specified index.
     *
     * @param i The index of the task to retrieve (0-based).
     * @return The task at the specified index.
     */
    public Task get(int i) {
        return tasks.get(i);
    }

    /**
     * Adds a task to the list.
     *
     * @param t The task to add.
     */
    public void add(Task t) {
        tasks.add(t);
    }

/**
 * Removes the task at the specified index.
 *
 * @param i The index of the task to remove (0-based).
 * @return The removed task.
 */

   public Task remove(int i) {
      return tasks.remove(i);
   }

    /**
     * Returns the list of tasks in raw list form.
     * Used for saving the tasks to storage.
     *
     * @return A list of tasks.
     */
    public List<Task> asList() {
        return tasks;
    }

}