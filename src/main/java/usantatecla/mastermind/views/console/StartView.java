package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		startController.getClearSecretCombination().forEach(e -> this.console.write(e.toString() + " "));
		this.console.writeln();
		this.secretCombinationView.writeln();
	}

}
