package usantatecla.mastermind.controllers;

public class UndoController {

    private Session session;
    public UndoController(Session session){
        this.session = session;
    }

    public void undo(){
        if (session.isUndoable()){
            this.session.undo();
        }

    }
}
