package usantatecla.utils;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public List<Command> commandList;

    public Menu(){
        this.commandList = new ArrayList<>();
    }

    public void execute(){
        Console console = new Console();
        int option;
        boolean error;
        do {
            error = false;
            for (int i = 0; i < this.commandList.size(); i++) {
                if (this.commandList.get(i).isActive()){
                    console.writeln((i + 1) + ". " + this.commandList.get(i).getTitle());
                }
            }
            option = console.readInt("Opción número: ");
        } while (error);
        this.commandList.get(option - 1).execute();
    }

    protected void addComand(Command command){
        this.commandList.add(command);
    }
}
