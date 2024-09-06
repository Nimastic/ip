package jeriel.command;
import jeriel.task.*;
import jeriel.util.*; 

public class ExitCommand extends Command {
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
        return ""; // Add a return statement here

    }

    /**
     * Returns true if this command is an exit command.
     *
     * @return true if this command is an exit command
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
