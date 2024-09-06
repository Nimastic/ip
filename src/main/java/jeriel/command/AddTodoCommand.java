package jeriel.command;
import jeriel.task.*;
import jeriel.util.*;

import java.io.IOException;

public class AddTodoCommand extends Command {
    private String description;

    public AddTodoCommand(String arguments) {
        this.description = arguments.trim();
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws JerielException, IOException {
        if (description.isEmpty()) {
            throw new JerielException("The description of a todo cannot be empty.");
        }

        // Create a new Todo task
        Task task = new Todo(description);

        // Add the task to the task list
        tasks.addTask(task);

        // Save the updated task list to storage
        storage.save(tasks.getTasks());

        // Return confirmation message to the user
        return "Got it. I've added this task:\n" + task + "\nNow you have " + tasks.size() + " tasks in the list.";
    }
}
