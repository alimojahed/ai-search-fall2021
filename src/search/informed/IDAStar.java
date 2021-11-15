package search.informed;

import resource.State;
import search.informed.heuristic.Heuristic;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class IDAStar extends InformedSearchAlgorithm {
    public IDAStar(State initialState, Heuristic heuristic) {
        super(initialState, "IDA*", heuristic);
    }

    @Override
    public void search() {

    }
}
