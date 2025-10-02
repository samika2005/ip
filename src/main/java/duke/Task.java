package duke;

public class Task {
    protected String word;
    protected boolean isDone;

    public Task(String word) {
        this.word = word;
        this.isDone = false;
    }

    public void mark(boolean done) {
        this.isDone = done;
    }

    public String statusBit() {
        return (isDone ? "1" : "0");
    }

    public String toSaveFormat() {
        return (isDone ? "1 | " : "0 | ") + word;
    }


    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + word;
        } else {
            return "[ ] " + word;
        }
    }
}
