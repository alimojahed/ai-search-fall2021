package search.informed.heuristic;

import resource.Color;
import resource.Node;
import resource.State;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class HeuristicImpl1 implements Heuristic {
    @Override
    public int heuristic(State state) {

        List<Node> selectedNodeNeighbors = state.getGraph()
                .getNode(state.getSelectedNodeId())
                .getNeighborsIds()
                .stream()
                .map(id -> state.getGraph().getNode(id))
                .collect(Collectors.toList());

        Node selectedNode = state.getGraph().getNode(state.getSelectedNodeId());

        int numberOfGreenNodes = 0;

        for (int i = 0; i < state.getGraph().size(); i++) {
            if (state.getGraph().getNode(i).getColor() == Color.Green)
                numberOfGreenNodes++;
        }

        int numberOfGreenNeighbors = (int) selectedNodeNeighbors
                .stream()
                .filter(node -> node.getColor() == Color.Green)
                .count();

        int numberOfRedNeighbors = selectedNodeNeighbors.size() - numberOfGreenNeighbors;


        if (selectedNode.getColor() == Color.Black) {


            return Math.abs(numberOfRedNeighbors - numberOfGreenNeighbors) +
                    (numberOfRedNeighbors != numberOfGreenNeighbors ? 1 : 0) +
                    numberOfGreenNodes;

        }
        return Math.abs(numberOfRedNeighbors - numberOfGreenNeighbors) + 1 + numberOfGreenNodes;

    }
}
