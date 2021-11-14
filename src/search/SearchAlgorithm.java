package search;

/*
    author: alimojahed
    date: 14.11.21
    project: Search_Project_AI
*/

import resource.Color;
import resource.State;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public abstract class SearchAlgorithm {

    protected final State initialState;
    protected final String RESULT_PATH_PREFIX = "src/test/";
    protected final String RESULT_PATH_POSTFIX = "-result.txt";
    protected String algorithmName;

    public SearchAlgorithm(State initialState) {
        this.initialState = initialState;
    }

    public abstract void search();

    protected boolean isGoal(State state) {
        for (int i = 0; i < state.getGraph().size(); i++) {
            if (state.getGraph().getNode(i).getColor() == Color.Red
                    || state.getGraph().getNode(i).getColor() == Color.Black) {
                return false;
            }
        }
        return true;
    }

    protected void result(State state) {
        Stack<State> states = new Stack<State>();
        while (true) {
            states.push(state);
            if (state.getParentState() == null) {
                break;
            } else {
                state = state.getParentState();
            }
        }
        try {
            String resultFileName = RESULT_PATH_PREFIX + algorithmName + RESULT_PATH_POSTFIX;
            FileWriter myWriter = new FileWriter(resultFileName);
            System.out.println("initial state : ");
            while (!states.empty()) {
                State tempState = states.pop();
                if (tempState.getSelectedNodeId() != -1) {
                    System.out.println("selected id : " + tempState.getSelectedNodeId());
                }
                tempState.getGraph().print();

                myWriter.write(tempState.getSelectedNodeId() + " ,");
                myWriter.write(tempState.outputGenerator() + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
