package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {

    private Game game;
    private List<GameMemento> gameMementoList;
    private int index;

    public GameRegistry(Game game){
        this.index = 0;
        this.gameMementoList = new ArrayList<GameMemento>();
        this.game = game;
        //this.register();
    }

    public void register(){
        this.gameMementoList.add(this.index, this.game.gameMemento());
        this.index += 1;
        System.out.println(this.index);
    }

    public void undo(){
        this.index--;
        this.game.set(this.gameMementoList.get(this.index), index);
    }

    public void redo(){
        this.index++;
        this.game.set(this.gameMementoList.get(this.index), index);
    }
}
