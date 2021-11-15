package search.informed;

import resource.State;
import resource.StateWithCostAndH;
import search.informed.heuristic.Heuristic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class RBFS extends InformedSearchAlgorithm {
    public RBFS(State initialState, Heuristic heuristic) {
        super(initialState, "RBFS", heuristic);
    }


    @Override
    public void search() {
        recursiveSearch(new StateWithCostAndH(initialState, 0, 0), Integer.MAX_VALUE);
    }

    private ResultWrapper recursiveSearch(StateWithCostAndH state, int limit) {

        if (isGoal(state)) {
            result(state);
            return new ResultWrapper(true, state, -1);
        }

        boolean flagHasAnswer = false;
        StateWithCostAndH result = state;

        PriorityQueue<StateWithCostAndH> successors =
                new PriorityQueue<>(Comparator.comparingInt(StateWithCostAndH::evaluation));

        successors.addAll(
                state.successor()
                        .stream()
                        .map(s -> new StateWithCostAndH(s, state.g(), heuristic.heuristic(s)))
                        .collect(Collectors.toList())
        );

        while (!successors.isEmpty()) {
            StateWithCostAndH bestSuccessor = successors.poll();

            if (bestSuccessor.evaluation() > limit) {
                return new ResultWrapper(false, null, Integer.MAX_VALUE);
            }

            int secondValue = successors.peek().evaluation();

            ResultWrapper tempResult = recursiveSearch(bestSuccessor, Math.min(secondValue, limit));

            bestSuccessor.setEval(tempResult.value);

            successors.add(bestSuccessor);

            if (tempResult.isGoal) {
                result = tempResult.state;
                flagHasAnswer = true;
                break;
            }

        }
        return new ResultWrapper(flagHasAnswer, result, -1);
    }


    private class ResultWrapper {
        private boolean isGoal;
        private StateWithCostAndH state;
        private int value;

        public ResultWrapper(boolean isGoal, StateWithCostAndH state, int value) {
            this.isGoal = isGoal;
            this.state = state;
            this.value = value;
        }
    }
}
