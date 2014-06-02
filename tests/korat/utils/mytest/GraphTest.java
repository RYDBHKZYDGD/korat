package korat.utils.mytest;

import junit.framework.TestCase;
import korat.examples.Graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/1/14
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphTest extends TestCase {

    public void test1() throws Exception {
        Graph.Vertex root =  new Graph.Vertex();
        Graph.Vertex l1 =  new Graph.Vertex();
        Graph.Vertex l21 =  new Graph.Vertex();
        Graph.Vertex l22 =  new Graph.Vertex();
        List<Graph.Vertex> outgoings  = new ArrayList<Graph.Vertex>();
        List<Graph.Vertex> outgoings1  = new ArrayList<Graph.Vertex>();
        List<Graph.Vertex> outgoings2  = new ArrayList<Graph.Vertex>();
        outgoings.add(l1);
        outgoings1.add(l21);
        root.setOutgoingEdges(outgoings);
        outgoings1.add(l22);
        l1.setOutgoingEdges(outgoings1);
        outgoings2.add(root);
        l22.setOutgoingEdges(outgoings2);

        Graph   graph = new Graph(root,4);
        assertEquals(graph.repOk(),false);

    }
}
