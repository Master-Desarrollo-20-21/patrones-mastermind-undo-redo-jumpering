package usantatecla.mastermind.controllers;

import usantatecla.mastermind.types.Color;

import java.util.List;

public class StartController extends Controller {

	public StartController(Session session) {
		super(session);
	}

	public void start() {
		this.session.next();
	}

	public List<Color> getClearSecretCombination(){
		return this.session.getClearSecretCombination();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
