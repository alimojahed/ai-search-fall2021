package search.uninformed;

import resource.State;
import resource.StateWithCost;
import search.SearchAlgorithm;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class UCS extends SearchAlgorithm {

    private PriorityQueue<StateWithCost> fringe = new PriorityQueue<>(Comparator.comparingInt(StateWithCost::getCost));
    private Hashtable<String, State> explored = new Hashtable<>();

    public UCS(State initialState) {
        super(initialState, "UCS");
    }

    @Override
    public void search() {
        int cost = Integer.MAX_VALUE;
        fringe.add(StateWithCost.fromSimpleState(initialState, 0));
        State goal = null;
        while (!fringe.isEmpty()) {
            StateWithCost current = fringe.poll();

            if (isGoal(current) && cost > current.getCost()) {
                goal = current;
                cost = current.getCost();
            }

            if (!explored.containsKey(current.hash())) {
                current.successor().forEach(state -> fringe.add(StateWithCost.fromSimpleState(state, current.getCost())));
            }
            explored.put(current.hash(), current);
        }

        if (goal != null) {
            System.out.println("Goal is found with cost " + cost);
            result(goal);
        }

    }
}