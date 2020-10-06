package ConsoleCommand;

public class delCommand implements Command {
    ConsoleCommand consoleCommand;

    public delCommand(ConsoleCommand consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    @Override
    public void execute() {
consoleCommand.del();
    }
}
