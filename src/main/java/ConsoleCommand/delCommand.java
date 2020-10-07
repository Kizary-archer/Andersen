package ConsoleCommand;

public class delCommand implements Command {
    ConsoleCommands consoleCommand;

    public delCommand(ConsoleCommands consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    @Override
    public void execute() {
        consoleCommand.del();
    }
}
