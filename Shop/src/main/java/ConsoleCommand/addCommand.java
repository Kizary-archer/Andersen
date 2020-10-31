package ConsoleCommand;

public class addCommand implements Command {
    ConsoleCommands consoleCommand;

    public addCommand(ConsoleCommands consoleCommand) {
        this.consoleCommand = consoleCommand;
    }

    @Override
    public void execute() {
        consoleCommand.add();
    }
}
