import resource.Color;
import resource.Graph;
import resource.Node;
import resource.State;
import search.uninformed.DFS;

public class Main {

    public static void main(String[] args) {

        //-----------------------------------------------> test1 :
//        resource.Graph initialGraph= new resource.Graph(5);
//        initialGraph.addNode(new resource.Node(0, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(1, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(2, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(3, resource.Color.Green));
//        initialGraph.addNode(new resource.Node(4, resource.Color.Red));
//        initialGraph.addLinkBetween(initialGraph.getNode(0), initialGraph.getNode(1));
//        initialGraph.addLinkBetween(initialGraph.getNode(0), initialGraph.getNode(2));
//        initialGraph.addLinkBetween(initialGraph.getNode(0), initialGraph.getNode(3));
//        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(2));
//        initialGraph.addLinkBetween(initialGraph.getNode(3), initialGraph.getNode(4));

        //-----------------------------------------------> test2 :
        Graph initialGraph = new Graph(7);
        initialGraph.addNode(new Node(0, Color.Red));
        initialGraph.addNode(new Node(1, Color.Black));
        initialGraph.addNode(new Node(2, Color.Green));
        initialGraph.addNode(new Node(3, Color.Red));
        initialGraph.addNode(new Node(4, Color.Red));
        initialGraph.addNode(new Node(5, Color.Green));
        initialGraph.addNode(new Node(6, Color.Red));
        initialGraph.addLinkBetween(initialGraph.getNode(0), initialGraph.getNode(4));
        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(2));
        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(3));
        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(4));
        initialGraph.addLinkBetween(initialGraph.getNode(3), initialGraph.getNode(5));
        initialGraph.addLinkBetween(initialGraph.getNode(4), initialGraph.getNode(5));
        initialGraph.addLinkBetween(initialGraph.getNode(5), initialGraph.getNode(6));

        //-----------------------------------------------> test3 :
//        resource.Graph initialGraph= new resource.Graph(15);
//        initialGraph.addNode(new resource.Node(0, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(1, resource.Color.Black));
//        initialGraph.addNode(new resource.Node(2, resource.Color.Black));
//        initialGraph.addNode(new resource.Node(3, resource.Color.Black));
//        initialGraph.addNode(new resource.Node(4, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(5, resource.Color.Green));
//        initialGraph.addNode(new resource.Node(6, resource.Color.Green));
//        initialGraph.addNode(new resource.Node(7, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(8, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(9, resource.Color.Green));
//        initialGraph.addNode(new resource.Node(10, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(11, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(12, resource.Color.Red));
//        initialGraph.addNode(new resource.Node(13, resource.Color.Green));
//        initialGraph.addNode(new resource.Node(14, resource.Color.Red));
//
//        initialGraph.addLinkBetween(initialGraph.getNode(0), initialGraph.getNode(1));
//        initialGraph.addLinkBetween(initialGraph.getNode(0), initialGraph.getNode(2));
//        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(14));
//        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(2));
//        initialGraph.addLinkBetween(initialGraph.getNode(1), initialGraph.getNode(3));
//        initialGraph.addLinkBetween(initialGraph.getNode(2), initialGraph.getNode(5));
//        initialGraph.addLinkBetween(initialGraph.getNode(2), initialGraph.getNode(6));
//        initialGraph.addLinkBetween(initialGraph.getNode(2), initialGraph.getNode(7));
//        initialGraph.addLinkBetween(initialGraph.getNode(3), initialGraph.getNode(13));
//        initialGraph.addLinkBetween(initialGraph.getNode(3), initialGraph.getNode(14));
//        initialGraph.addLinkBetween(initialGraph.getNode(3), initialGraph.getNode(7));
//        initialGraph.addLinkBetween(initialGraph.getNode(4), initialGraph.getNode(6));
//        initialGraph.addLinkBetween(initialGraph.getNode(4), initialGraph.getNode(11));
//        initialGraph.addLinkBetween(initialGraph.getNode(5), initialGraph.getNode(10));
//        initialGraph.addLinkBetween(initialGraph.getNode(5), initialGraph.getNode(12));
//        initialGraph.addLinkBetween(initialGraph.getNode(6), initialGraph.getNode(11));
//        initialGraph.addLinkBetween(initialGraph.getNode(7), initialGraph.getNode(8));
//        initialGraph.addLinkBetween(initialGraph.getNode(7), initialGraph.getNode(9));
//        initialGraph.addLinkBetween(initialGraph.getNode(8), initialGraph.getNode(14));


        State initialState = new State(initialGraph, -1, null);

        DFS.search(initialState);
    }
}
