package resource;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class StateWithCost extends State {

    private int costToThisState;

    public StateWithCost(Graph graph, int selectedNodeId, State parentState, int costToThisState) {
        super(graph, selectedNodeId, parentState);
        this.costToThisState = costToThisState;
    }

    public static StateWithCost fromSimpleState(State state, int costToThisState) {
        return new StateWithCost(state.getGraph(), state.getSelectedNodeId(), state.getParentState(), costToThisState);
    }

    public int getCost() {
        if (getParentState() == null)
            return 0;

        return switch (getParentState().getGraph().getNode(getSelectedNodeId()).getColor()) {
            case Red -> 1;
            case Black -> 2;
            case Green -> 3;
        } + costToThisState;
    }

}
