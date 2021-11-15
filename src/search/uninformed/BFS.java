package search.uninformed;

import resource.State;
import search.SearchAlgorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends SearchAlgorithm {


    private final Hashtable<String, State> inFrontier = new Hashtable<>();
    private final Hashtable<String, State> explored = new Hashtable<>();
    private final Queue<State> frontier = new LinkedList<>();

    public BFS(State initialState) {
        super(initialState, "BFS");

        frontier.add(initialState);
        inFrontier.put(initialState.hash(), initialState);
    }

    public static void search(State initialState) {
        new BFS(initialState).search();
    }

    @Override
    public void search() {
        if (isGoal(initialState)) {
            result(initialState);
            return;
        }
        while (!frontier.isEmpty()) {
            oneStepSearch(true);
        }
    }

    public void oneStepSearch(boolean goalTest) {
        State tempState = frontier.poll();
        inFrontier.remove(tempState.hash());
        explored.put(tempState.hash(), tempState);
        ArrayList<State> children = tempState.successor();
        for (int i = 0; i < children.size(); i++) {
            if (!(inFrontier.containsKey(children.get(i).hash()))
                    && !(explored.containsKey(children.get(i).hash()))) {
                if (goalTest && isGoal(children.get(i))) {
                    result(children.get(i));
                    return;
                }
                frontier.add(children.get(i));
                inFrontier.put(children.get(i).hash(), children.get(i));
            }
        }

    }

    public Hashtable<String, State> getExplored() {
        return explored;
    }

    public Hashtable<String, State> getInFrontier() {
        return inFrontier;
    }

    public Queue<State> getFrontier() {
        return frontier;
    }
}


