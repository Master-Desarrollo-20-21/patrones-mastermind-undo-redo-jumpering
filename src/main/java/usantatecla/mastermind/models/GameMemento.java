package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {

    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public GameMemento(List<ProposedCombination> proposedCombinations, List<Result> results){
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
        //proposedCombinations.forEach(e -> this.proposedCombinations.add(e.copy()));
        //results.forEach(e -> this.results.add(e.copy()));
        for (ProposedCombination proposedCombination: proposedCombinations) {
            this.proposedCombinations.add(proposedCombination);
        }
        for (Result result : results){
            this.results.add(result);
        }



    }

    public List<ProposedCombination> getProposedCombinations(){
        return this.proposedCombinations;
    }

    public List<Result> getResults(){
        return this.results;
    }
}
