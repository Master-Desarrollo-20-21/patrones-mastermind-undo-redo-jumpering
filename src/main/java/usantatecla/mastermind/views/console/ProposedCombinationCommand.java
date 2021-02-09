package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.utils.Command;

public class ProposedCombinationCommand extends Command {

    private StartController startController;

    public ProposedCombinationCommand(StartController startController) {
        super("Proposed combination");
        this.startController = startController;
    }

    @Override
    public void execute() {
        startController.start();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
