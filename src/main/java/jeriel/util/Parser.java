package jeriel.util;

import jeriel.command.*;

public class Parser {
    
    public static Command parse(String fullCommand) throws JerielException {
        System.out.println("Parser received: " + fullCommand);  // Check the input sent to parser

        String[] commandAndArgs = fullCommand.split(" ", 2);  // Split command and arguments
        String command = commandAndArgs[0];  // First word is the command
        String arguments = commandAndArgs.length > 1 ? commandAndArgs[1] : "";  // Remaining part is arguments

        switch (command) {
            case "list":
                return new ListCommand();
            case "todo":
                return new AddTodoCommand(arguments);
            case "deadline":
                return new AddDeadlineCommand(arguments);
            case "event":
                return new AddEventCommand(arguments);
            case "mark":
                return new MarkCommand(arguments);
            case "unmark":
                return new UnmarkCommand(arguments);
            case "delete":
                return new DeleteCommand(arguments);
            case "bye":
                return new ExitCommand();
            default:
                throw new JerielException("Unknown command: " + command);
        }
    }
}
