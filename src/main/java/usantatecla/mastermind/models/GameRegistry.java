package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private Game game;
    private List<GameMemento> gameMementoList;
    private int index;

    public GameRegistry(){
        this.index = 0;
        this.gameMementoList = new ArrayList<GameMemento>();
        //this.register();
    }

    public void register(){
        this.gameMementoList.add(this.index, this.game.gameMemento());
        this.index++;
    }

    public void undo(){
        this.index--;
        this.game.set(this.gameMementoList.get(this.index));
    }

    public void redo(){
        this.index++;
        this.game.set(this.gameMementoList.get(this.index));
    }
}
