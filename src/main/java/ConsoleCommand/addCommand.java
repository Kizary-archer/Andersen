package ConsoleCommand;

public class addCommand implements Command {
    ConsoleCommand consoleCommand;

    public addCommand(ConsoleCommand consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    @Override
    public void execute() {
        consoleCommand.add();
    }
}
