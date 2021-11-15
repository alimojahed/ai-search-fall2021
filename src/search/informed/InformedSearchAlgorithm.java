package search.informed;

import resource.State;
import search.SearchAlgorithm;
import search.informed.heuristic.Heuristic;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public abstract class InformedSearchAlgorithm extends SearchAlgorithm {

    protected Heuristic heuristic;

    public InformedSearchAlgorithm(State initialState, String algorithmName, Heuristic heuristic) {
        super(initialState, algorithmName);
        this.heuristic = heuristic;
    }

}
