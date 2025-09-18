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

    protected String statusBit() {
        return isDone ? "1" : "0";   // 1 = done, 0 = not done
    }

    public String toSaveFormat() {
        return "T | " + statusBit() + " | " + word;
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
