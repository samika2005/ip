package duke;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final ArrayList<Task> list = new ArrayList<>();

    public TaskList() { }

    public TaskList(List<Task> initial) { list.addAll(initial); }

    public int size() { return list.size(); }

    public Task get(int i) { return list.get(i); }

    public void add(Task t) { list.add(t); }

    public Task remove(int i) { return list.remove(i); }

    public List<Task> asList() { return list; }

}