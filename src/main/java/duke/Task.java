package duke;

public class Task {
    protected String word;
    protected boolean flag;

    public Task(String word) {
        this.word = word;
        this.flag = false;
    }

    public void mark(boolean done) {
        this.flag = done;
    }

    @Override
    public String toString() {
        if (flag) {
            return "[X] " + word;
        } else {
            return "[ ] " + word;
        }
    }
}
