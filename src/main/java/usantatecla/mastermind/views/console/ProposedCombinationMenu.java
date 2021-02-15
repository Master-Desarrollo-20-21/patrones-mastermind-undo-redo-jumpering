package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.Console;
import usantatecla.utils.Menu;

import java.util.List;

public class ProposedCombinationMenu extends Menu {

    public ProposedCombinationMenu(ProposalController proposalController){
		new ProposedCombinationCommand(proposalController).execute();
		System.out.println("dddd");
		if (proposalController.getAttempts() > 0){
			//new UndoCommand(proposalController).execute();
		}
    }
}
