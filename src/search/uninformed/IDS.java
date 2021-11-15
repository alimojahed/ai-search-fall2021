package search.uninformed;


import resource.State;
import search.SearchAlgorithm;

import java.util.List;

/*
    author: alimojahed
    date: 14.11.21
    project: Search_Project_AI
*/


public class IDS extends SearchAlgorithm {

    private final int maxDepth;

    public IDS(State initialState, int maxDepth) {
        super(initialState, "IDS");
        this.maxDepth = maxDepth;
    }

    public static void search(State initialState, int maxDepth) {
        new IDS(initialState, maxDepth).search();
    }

    @Override
    public void search() {
        for (int i = 0; i < maxDepth; i++) {
            boolean hasResult = searchRecursive(initialState, maxDepth);
            if (hasResult) {
                return;
            }
        }
    }

    private boolean searchRecursive(State state, int depthLimit) {
        if (isGoal(state)) {
            result(state);
            return true;
        }

        if (depthLimit < 1) {
            return false;
        }

        List<State> successors = state.successor();
        for (State successor : successors) {
            if (searchRecursive(successor, depthLimit - 1)) {
                return true;
            }
        }

        return false;

    }
}
