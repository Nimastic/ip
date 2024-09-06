package jeriel.command;
import jeriel.task.*;
import jeriel.util.*;
import java.io.IOException;

public abstract class Command {
    public String execute(TaskList tasks, Ui ui, Storage storage) throws JerielException, IOException {
        // Add your implementation here
        // ...
        return null; // Replace null with the appropriate return statement
    }

    /**
     * Returns true if the command should exit the program, and false otherwise.
     * 
     * Default behavior is that the command doesn't exit the program.
     * 
     * @return true if the command should exit the program, and false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
