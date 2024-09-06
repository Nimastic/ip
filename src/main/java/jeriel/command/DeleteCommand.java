package jeriel.command;
import jeriel.task.*;
import jeriel.util.*;
import java.io.IOException;

public class DeleteCommand extends Command {
    private int taskIndex;

    public DeleteCommand(String arguments) throws JerielException {
        try {
            this.taskIndex = Integer.parseInt(arguments) - 1;
        } catch (NumberFormatException e) {
            throw new JerielException("Invalid task number. Please enter a valid task number.");
        }
    }

    /**
     * Deletes a task from the task list, and saves the task list to file.
     *
     * @param tasks the task list to delete the task from
     * @param ui the ui to display the result
     * @param storage the storage to save to
     * @throws JerielException if the task number is invalid
     * @throws IOException if there is an error saving the task list
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws JerielException, IOException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new JerielException("Invalid task number. Please enter a valid task number.");
        }
        Task task = tasks.get(taskIndex);
        tasks.deleteTask(taskIndex);
        ui.showTaskDeleted(task, tasks.size());
        storage.save(tasks.getTasks());
        return ""; // Add a return statement here

    }
}
