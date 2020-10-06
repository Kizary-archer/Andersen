package ConsoleCommand;

public class listCommand implements Command {

    ConsoleCommand consoleCommand;

    public listCommand(ConsoleCommand consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    @Override
    public void execute() {
        consoleCommand.list();
    }
}
