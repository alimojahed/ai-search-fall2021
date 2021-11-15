package resource;

/**
 * @author: alimojahed
 * @date: 15.11.21
 * @project: Search_Project_AI
 **/


public class StateWithCostAndH extends State {

    private int costToThisState;
    private int h;
    private Integer eval = null;

    public StateWithCostAndH(State state, int costToThisState, int h) {
        super(state.getGraph(), state.getSelectedNodeId(), state.getParentState());
        this.costToThisState = costToThisState;
        this.h = h;
    }

    public int evaluation() {
        return eval == null ? costToThisState + h + 1 : eval;
    }

    public int g() {
        return costToThisState + 1;
    }

    public int h() {
        return h;
    }

    public void setEval(Integer eval) {
        this.eval = eval;
    }
}
