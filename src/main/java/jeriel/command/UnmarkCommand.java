package jeriel.command;
import jeriel.task.*;
import jeriel.util.*;
import java.io.IOException;

public class UnmarkCommand extends Command {
    private int taskIndex;

    public UnmarkCommand(String arguments) throws JerielException {
        try {
            this.taskIndex = Integer.parseInt(arguments) - 1;
        } catch (NumberFormatException e) {
            throw new JerielException("Invalid task number. Please enter a valid task number.");
        }
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws JerielException, IOException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new JerielException("Invalid task number. Please enter a valid task number.");
        }

        Task task = tasks.get(taskIndex);
        task.markAsNotDone();  // Unmark the task

        storage.save(tasks.getTasks());  // Save changes to storage

        // Return a confirmation message
        return "OK, I've marked this task as not done yet:\n" + task;
    }
}
