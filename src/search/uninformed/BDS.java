package search.uninformed;

import resource.State;
import search.SearchAlgorithm;

import java.util.*;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class BDS extends SearchAlgorithm {

    private final BFS bfsFromStart;
    private final BFS bfsFromGoal;

    private Map<String, State> pathTrackerFromGoal = new HashMap<>();
    private Map<String, State> pathTrackerFromStart = new HashMap<>();

    private State goalState;

    public BDS(State initialState, State goalState) {
        super(initialState, "BDS");

        this.goalState = goalState;

        bfsFromStart = new BFS(initialState);
        bfsFromGoal = new BFS(goalState);
    }

    @Override
    public void search() {
        while (!bfsFromStart.getFrontier().isEmpty() && !bfsFromGoal.getFrontier().isEmpty()) {

            keepTrackOfPath(bfsFromStart, pathTrackerFromStart);
            bfsFromStart.oneLevelSearch(false);

            keepTrackOfPath(bfsFromGoal, pathTrackerFromGoal);
            bfsFromGoal.oneLevelSearch(false);

            if (intersect()) {
                State intersectedState = getIntersectedState();
                result(intersectedState);
                return;
            }

        }
    }

    private void keepTrackOfPath(BFS bfsAlgorithm, Map<String, State> pathTracker) {
        State currentStateInAlgorithm = bfsAlgorithm.getFrontier().peek();
        List<State> children = currentStateInAlgorithm.successor();

        for (State child : children) {
            if (!bfsAlgorithm.getExplored().containsKey(child.hash())
                    && !bfsAlgorithm.getInFrontier().containsKey(child.hash())) {
                pathTracker.put(child.hash(), currentStateInAlgorithm);
            }
        }

    }

    private State getIntersectedState() {
        Set<String> exploredStatesFromGoalHashes = bfsFromGoal.getExplored().keySet();
        return bfsFromStart.getExplored()
                .entrySet()
                .stream()
                .filter(stringBooleanEntry -> exploredStatesFromGoalHashes.contains(stringBooleanEntry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    private boolean intersect() {
        return getIntersectedState() == null;
    }

    @Override
    protected Stack<State> getSolutionPath(State state) {

        Stack<State> temp = new Stack<>();

        State current = state;

        while (current != null) {
            current = pathTrackerFromGoal.get(current.hash());
            if (current != null) {
                temp.add(current);
            }
        }

        Stack<State> states = new Stack<>();
        temp.stream().forEach(s -> states.push(temp.pop()));

        current = state;

        while (current != null) {
            states.add(current);
            current = pathTrackerFromStart.get(current.hash());
        }

        return states;
    }
}
