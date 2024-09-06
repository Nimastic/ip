package jeriel.command;
import jeriel.task.*;
import jeriel.util.*;

import java.io.IOException;

public class AddDeadlineCommand extends Command {
    private String description;
    private String by;

    public AddDeadlineCommand(String arguments) {
        String[] parts = arguments.split(" /by ");
        this.description = parts[0].trim();
        this.by = parts.length > 1 ? parts[1].trim() : "";
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws JerielException, IOException {
        if (description.isEmpty() || by.isEmpty()) {
            throw new JerielException("The description and due date of a deadline cannot be empty.");
        }
        Task task = new Deadline(description, by);
        tasks.addTask(task);
        storage.save(tasks.getTasks());  // Save after adding

        // Return confirmation message to the user
        return "Got it. I've added this deadline:\n" + task + "\nNow you have " + tasks.size() + " tasks in the list.";
    }
}
