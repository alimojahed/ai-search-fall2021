package search.uninformed;

import resource.State;
import search.SearchAlgorithm;

import java.util.HashSet;
import java.util.Stack;

/*
    author: alimojahed
    date: 14.11.21
    project: Search_Project_AI
*/

public class DFS extends SearchAlgorithm {

    public DFS(State initialState) {
        super(initialState, "DFS");
    }

    public static void search(State initialState) {
        new DFS(initialState).search();
    }

    @Override
    public void search() {
        Stack<State> states = new Stack<>();
        HashSet<String> explored = new HashSet<>();

        states.push(initialState);

        while (!states.isEmpty()) {
            State state = states.pop();

            explored.add(state.hash());

            if (isGoal(state)) {
                result(state);
                return;
            }

            for (State successor : state.successor()) {
                if (!explored.contains(successor.hash())) {
                    states.push(state);
                }
            }


        }

    }
}
