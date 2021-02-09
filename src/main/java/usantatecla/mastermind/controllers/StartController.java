package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.types.Color;

import java.util.List;

public class StartController extends Controller {

	public StartController(Game game, State state) {
		super(game, state);
	}

	public void start() {
		this.state.next();
	}

	public List<Color> getClearSecretCombination(){

		return this.game.getClearSecretCombination();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
