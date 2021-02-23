package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.utils.Command;

public class UndoCommand extends Command {

    private ProposalController proposalController;

    public UndoCommand(ProposalController proposalController) {
        super("Undo command");
        this.proposalController = proposalController;
    }

    @Override
    protected void execute() {
        this.proposalController.undo();
        new AttemptsView(proposalController).writeln();
        for (int i = 0; i < proposalController.getAttempts(); i++) {
            new ProposedCombinationView(proposalController).write(i);
            new ResultView(proposalController).writeln(i);
        }

    }

    @Override
    public boolean isActive() {
        return this.proposalController.isUndoable();
    }
}
