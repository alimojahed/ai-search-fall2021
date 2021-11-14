package search.uninformed;

/*
    author: alimojahed
    date: 14.11.21
    project: Search_Project_AI
*/


import resource.State;
import search.SearchAlgorithm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class DFS extends SearchAlgorithm {

    public DFS(State initialState) {
        super(initialState);
        this.algorithmName = "DFS";
    }

    public static void search(State initialState) {
        new DFS(initialState).search();
    }

    @Override
    public void search() {
        Stack<State> frontier = new Stack<>();
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if (isGoal(initialState)) {
            result(initialState);
            return;
        }
        frontier.add(initialState);
        inFrontier.put(initialState.hash(), true);
        while (!frontier.isEmpty()) {
            State tempState = frontier.pop();
            inFrontier.remove(tempState.hash());
            explored.put(tempState.hash(), true);
            ArrayList<State> children = tempState.successor();
            for (int i = 0; i < children.size(); i++) {
                if (!(inFrontier.containsKey(children.get(i).hash()))
                        && !(explored.containsKey(children.get(i).hash()))) {
                    if (isGoal(children.get(i))) {
                        result(children.get(i));
                        return;
                    }
                    frontier.add(children.get(i));
                    inFrontier.put(children.get(i).hash(), true);
                }
            }
        }
    }
}
