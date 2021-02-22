package usantatecla.mastermind.controllers;

import java.util.List;

import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.GameRegistry;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

public class ProposalController extends Controller {

	private UndoController undoController;

	public ProposalController(Session session) {
		super(session);
		this.undoController = new UndoController(session);
	}

	public Error addProposedCombination(List<Color> colors) {

//		gameRegistry.register();
//		Console console = new Console();
//		int userOption = console.readInt("1 undo\n2 redo\n3 continue");
//		if (userOption == 1){
//			gameRegistry.undo();
//		}
//		if (userOption == 2){
//			gameRegistry.redo();
//		}

		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			this.session.addProposedCombination(colors);
			if (this.session.isWinner() || this.session.isLooser()) {
				this.session.next();
			}
		}
		return error;
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}
	
	public int getAttempts() {
		return this.session.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

	public int getBlacks(int position) {
		return this.session.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.session.getWhites(position);
	}

	public void undo(){
		this.undoController.undo();
	}

	public boolean isUndoable(){
		return this.session.isUndoable();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
