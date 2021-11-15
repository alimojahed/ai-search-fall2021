package search.informed;

import resource.State;
import resource.StateWithCostAndH;
import search.informed.heuristic.Heuristic;

import java.util.*;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class AStar extends InformedSearchAlgorithm {

    private PriorityQueue<StateWithCostAndH> open =
            new PriorityQueue<>(Comparator.comparingInt(StateWithCostAndH::evaluation));

    private PriorityQueue<StateWithCostAndH> close =
            new PriorityQueue<>(Comparator.comparingInt(StateWithCostAndH::evaluation));

    private Hashtable<String, StateWithCostAndH> explored =
            new Hashtable<>();

    private Set<String> closeQueueTracker = new HashSet<>();

    public AStar(State initialState, Heuristic heuristic) {
        super(initialState, "A*", heuristic);
    }

    @Override
    public void search() {


        open.add(new StateWithCostAndH(initialState, 0, 0));
        explored.put(initialState.hash(), new StateWithCostAndH(initialState, 0, 0));

        while (!open.isEmpty()) {
            StateWithCostAndH current = open.poll();

            if (isGoal(current)) {
                result(current);
                return;
            }

            List<State> successors = current.successor();
            for (State child : successors) {
                StateWithCostAndH temp = new StateWithCostAndH(child, current.g(), heuristic.heuristic(child));
                if (!explored.containsKey(child.hash())) {
                    open.add(temp);
                    explored.put(child.hash(), temp);

                } else {
                    if (temp.g() < explored.get(temp.hash()).g()) {
                        explored.put(temp.hash(), temp);

                        if (close.contains(temp)) {
                            close.remove(temp);
                            open.add(temp);
                        }

                    }
                }
            }

            open.remove(current);
            close.add(current);

        }

    }
}
