//package usantatecla.mastermind.models;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GameRegistry {
//
//    private Game game;
//    private List<GameMemento> gameMementoList;
//    private int index;
//
//    public GameRegistry(Game game) {
//
//        this.index = 0;
//        this.gameMementoList = new ArrayList<GameMemento>();
//        this.game = game;
//        //this.register();
//    }
//
//    public void register() {
//        this.gameMementoList.add(this.index, this.game.gameMemento());
//        //this.index += 1;
//        //this.game.getAttempts();
//        System.out.println(this.index);
//    }
//
//    public void undo() {
//        this.index = this.index - 1;
//        this.game.set(this.gameMementoList.get(this.index));
//    }
//
//    public void redo() {
//        this.index++;
//        this.game.set(this.gameMementoList.get(this.index));
//    }
//
//    public boolean isUndoable() {
//        return this.gameMementoList.size() > 0;
//    }
//
//    public boolean isRedoable() {
//        return this.gameMementoList.size() > 0;
//    }
//}








package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private List<GameMemento> mementos;
    private Game game;
    private int firstPrevious;

    public GameRegistry(Game game) {
        this.game = game;
        this.mementos = new ArrayList<>();
        this.firstPrevious = 0;
        this.mementos.add(this.firstPrevious, this.game.gameMemento());
    }

    public void register() {
        for (int i = 0; i < this.firstPrevious; i++) {
            this.mementos.remove(0);
            this.firstPrevious--;
        }
        this.mementos.add(this.firstPrevious, this.game.gameMemento());
    }

    public void undo() {
        this.firstPrevious++;
        this.game.set(this.mementos.get(this.firstPrevious));
    }

    public void redo() {
        this.firstPrevious--;
        this.game.set(this.mementos.get(this.firstPrevious));
    }

    public boolean isUndoable() {
        return this.firstPrevious < this.mementos.size() - 1;
    }

    boolean isRedoable() {
        return this.firstPrevious >= 1;
    }

}
