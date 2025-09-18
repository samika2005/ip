package duke;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toSaveFormat() {
        return "T | " + statusBit() + " | " + word;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
