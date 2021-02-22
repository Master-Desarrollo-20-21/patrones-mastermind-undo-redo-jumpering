package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.GameRegistry;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.List;

public class Session {

    private Game game;
    private State state;
    private GameRegistry gameRegistry;
    public Session(){
        this.game = new Game();
        this.state = new State();
        this.gameRegistry = new GameRegistry(this.game);
    }

    public boolean isUndoable() {
        return this.gameRegistry.isUndoable();
    }

    public void undo() {
        this.gameRegistry.undo();

    }

    public boolean isRedoable() {
        return this.gameRegistry.isRedoable();
    }

    public void redo() {
        this.gameRegistry.redo();

    }

    public int getWidth(){
        return this.game.getWidth();
    }

    public void next(){
        this.state.next();
    }

    public List<Color> getClearSecretCombination(){
        return this.game.getClearSecretCombination();
    }

    public StateValue getValueState(){
        return this.state.getValueState();
    }

    public void clear(){
        this.game.clear();
    }

    public void reset(){
        this.state.reset();
    }

    public void addProposedCombination(List<Color> colors){
        this.game.addProposedCombination(colors);
        gameRegistry.register();
    }

    public boolean isWinner(){
        return this.game.isWinner();
    }

    public boolean isLooser(){
        return this.game.isLooser();
    }

    public int getAttempts(){
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position){
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

}
