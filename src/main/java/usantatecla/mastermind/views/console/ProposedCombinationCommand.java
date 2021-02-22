package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Command;
import usantatecla.utils.Console;

import java.util.List;

public class ProposedCombinationCommand extends Command {

    private ProposalController proposalController;

    public ProposedCombinationCommand(ProposalController proposalController) {
        super("Proposed combination");
        this.proposalController = proposalController;
    }

    @Override
    public void execute() {
    	Console console = new Console();
        Error error;
		do {
			List<Color> colors = new ProposedCombinationView(proposalController).read();
			error = proposalController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		console.writeln();
		new AttemptsView(proposalController).writeln();
		new SecretCombinationView(proposalController).writeln();
		for (int i = 0; i < proposalController.getAttempts(); i++) {
			new ProposedCombinationView(proposalController).write(i);
			new ResultView(proposalController).writeln(i);
		}
		if (proposalController.isWinner()) {
			console.writeln(MessageView.WINNER.getMessage());
		} else if (proposalController.isLooser()) {
			console.writeln(MessageView.LOOSER.getMessage());
		}
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
