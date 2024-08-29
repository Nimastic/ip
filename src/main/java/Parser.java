public class Parser {
    public static Command parse(String fullCommand) throws JerielException {
        String[] commandAndArgs = fullCommand.split(" ", 2);
        String command = commandAndArgs[0];
        String arguments = commandAndArgs.length > 1 ? commandAndArgs[1] : "";

        switch (command) {
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(arguments);
            case "unmark":
                return new UnmarkCommand(arguments);
            case "todo":
                return new AddTodoCommand(arguments);
            case "deadline":
                return new AddDeadlineCommand(arguments);
            case "event":
                return new AddEventCommand(arguments);
            case "delete":
                return new DeleteCommand(arguments);
            case "bye":
                return new ExitCommand();
            default:
                throw new JerielException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
