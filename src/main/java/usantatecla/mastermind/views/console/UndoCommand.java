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


    }

    @Override
    public boolean isActive() {
        return false;
    }
}
