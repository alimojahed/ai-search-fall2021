package search.informed;

import resource.State;
import resource.StateWithCostAndH;
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
        int threshold = heuristic.heuristic(initialState);
        boolean searchIsOver = false;

        while (!searchIsOver) {
            ResultWrapper result = recursiveSearch(new StateWithCostAndH(initialState, 0, 0), threshold);
            if (result.dist == Integer.MAX_VALUE || result.isGoal) {
                searchIsOver = true;
            } else {
                threshold = result.dist;
            }

        }

    }

    private ResultWrapper recursiveSearch(StateWithCostAndH state, int threshold) {
        if (isGoal(state)) {
            result(state);
            return new ResultWrapper(state.g(), true);
        }

        if (state.evaluation() > threshold) {
            return new ResultWrapper(state.evaluation(), false);
        }

        int minDist = Integer.MAX_VALUE;

        for (State successor : state.successor()) {
            ResultWrapper result = recursiveSearch(
                    new StateWithCostAndH(successor, state.g(), heuristic.heuristic(successor)), threshold);

            if (result.isGoal) {
                return result;
            } else if (result.dist < minDist) {
                minDist = result.dist;
            }
        }

        return new ResultWrapper(minDist, false);
    }

    private class ResultWrapper {
        private int dist;
        private boolean isGoal;

        public ResultWrapper(int dist, boolean isGoal) {
            this.dist = dist;
            this.isGoal = isGoal;
        }
    }

}
