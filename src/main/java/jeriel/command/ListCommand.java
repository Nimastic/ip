package jeriel.command;
import jeriel.task.*;
import jeriel.util.*;
public class ListCommand extends Command {
    /**
     * Shows the current tasks in the task list.
     *
     * @param tasks the task list to show
     * @param ui the ui to display the result
     * @param storage the storage to save to (not used)
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            return "Your task list is empty.";
        }
        
        StringBuilder response = new StringBuilder("Here are the tasks in your list:\n");
        
        for (int i = 0; i < tasks.size(); i++) {
            response.append(i + 1).append(". ").append(tasks.getTask(i)).append("\n");
        }
        
        // Optionally show the task list in the UI
        ui.showTaskList(tasks);
        
        // Return the task list as a response string
        return response.toString();
    }
}
