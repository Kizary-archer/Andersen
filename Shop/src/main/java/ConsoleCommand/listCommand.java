package ConsoleCommand;

public class listCommand implements Command {

    ConsoleCommands consoleCommand;

    public listCommand(ConsoleCommands consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    @Override
    public void execute() {
        consoleCommand.list();
    }
}
