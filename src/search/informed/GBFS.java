package search.informed;

import resource.State;
import resource.StateWithCostAndH;
import search.informed.heuristic.Heuristic;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class GBFS extends InformedSearchAlgorithm {


    private PriorityQueue<StateWithCostAndH> fringe =
            new PriorityQueue<>(Comparator.comparingInt(StateWithCostAndH::h));

    private Hashtable<String, StateWithCostAndH> explored = new Hashtable<>();


    public GBFS(State initialState, Heuristic heuristic) {
        super(initialState, "GBFS", heuristic);
    }

    @Override
    public void search() {
        fringe.add(new StateWithCostAndH(initialState, 0, 0));
        explored.put(initialState.hash(), new StateWithCostAndH(initialState, 0, 0));

        while (!fringe.isEmpty()) {
            StateWithCostAndH temp = fringe.poll();

            if (isGoal(temp)) {
                result(temp);
                return;
            }

            for (State state : temp.successor()) {
                if (!explored.containsKey(state.hash())) {
                    StateWithCostAndH newState = new StateWithCostAndH(state, temp.g(), heuristic.heuristic(state));
                    fringe.add(newState);
                    explored.put(state.hash(), newState);
                }
            }

        }

    }
}
