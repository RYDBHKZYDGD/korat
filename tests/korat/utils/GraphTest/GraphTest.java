package korat.utils.GraphTest;

import junit.framework.TestCase;
import korat.examples.Graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 */
public class GraphTest extends TestCase {
    Graph.Vertex root =  new Graph.Vertex();
    Graph.Vertex l1 =  new Graph.Vertex();
    Graph.Vertex l21 =  new Graph.Vertex();
    Graph.Vertex l22 =  new Graph.Vertex();
    List<Graph.Vertex> outgoings  = new ArrayList<Graph.Vertex>();
    List<Graph.Vertex> outgoings1  = new ArrayList<Graph.Vertex>();
    List<Graph.Vertex> outgoings2  = new ArrayList<Graph.Vertex>();
    List<Graph.Vertex> outgoings3  = new ArrayList<Graph.Vertex>();

    //a graph contains a cycle which on the second path.
    public void testFourNodesWithCycle() throws Exception {

        outgoings.add(l1);
        outgoings1.add(l22);
        outgoings3.add(l21);
        outgoings2.add(root);
        root.setOutgoingEdges(outgoings);
        l1.setOutgoingEdges(outgoings1);
        l22.setOutgoingEdges(outgoings2);
        l21.setOutgoingEdges(outgoings3);
        Graph   graph = new Graph(root,4);
        assertEquals(graph.repOk(),false);

    }

    // a four node graph with a triangle.
    public void testFourNodesWithTriangle() throws Exception {

        outgoings.add(l1);
        outgoings.add(l21);
        outgoings1.add(l22);
        outgoings2.add(l1);
        outgoings3.add(l21);
        root.setOutgoingEdges(outgoings);
        l1.setOutgoingEdges(outgoings1);
        l21.setOutgoingEdges(outgoings2);
        l22.setOutgoingEdges(outgoings3);

        Graph   graph = new Graph(root,4);
        assertEquals(graph.repOk(),false);

    }
    //from test2, change one edge to remove cycle.
    public void testFourNodesDAG() throws Exception {

        outgoings.add(l1);
        outgoings.add(l21);
        outgoings1.add(l22);
        outgoings1.add(l21);
        outgoings3.add(l21);
        root.setOutgoingEdges(outgoings);
        l1.setOutgoingEdges(outgoings1);
        l21.setOutgoingEdges(outgoings2);
        l22.setOutgoingEdges(outgoings3);

        Graph   graph = new Graph(root,4);
        assertEquals(graph.repOk(),true);
        assertEquals(new Graph(root,-1).repOk(),false);

    }

    //one node
    public void testOneNodeGraphe() throws Exception {
        Graph   graph = new Graph(root,1);
        assertEquals(graph.repOk(),true);

    }

    //two disjoin nodes and two connected nodes
    public void testTwoNodesGraphe() throws Exception {
        Graph   graph = new Graph(root,2);
        assertEquals(graph.repOk(),false);

        outgoings.add(l1);
        root.setOutgoingEdges(outgoings);
        assertEquals(graph.repOk(),true);

    }







}
