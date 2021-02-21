package usantatecla.mastermind.controllers;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}
	
	public void resume(boolean newGame) {
		if (newGame) {
			this.session.clear();
			this.session.reset();
		} else {
			this.session.next();
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
