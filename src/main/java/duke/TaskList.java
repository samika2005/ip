package duke;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskList() { }

    public TaskList(List<Task> initial) { tasks.addAll(initial); }

    public int size() { return tasks.size(); }

    public Task get(int i) { return tasks.get(i); }

    public void add(Task t) { tasks.add(t); }

    public Task remove(int i) { return tasks.remove(i); }

    public List<Task> asList() { return tasks; }

}