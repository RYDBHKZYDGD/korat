//package korat.utils.graphTest;
//
//import junit.framework.TestCase;
//import korat.examples.graph.Graph;
//import sun.security.provider.certpath.Vertex;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
//* Created with IntelliJ IDEA.
//* User: ztx
//*/
//
////in graph structure, each node has an array and possible value inside is null or another vertex.
//public class GraphTest extends TestCase {
//    Graph.Vertex root =  new Graph.Vertex();
//    Graph.Vertex l1 =  new Graph.Vertex();
//    Graph.Vertex l21 =  new Graph.Vertex();
//    Graph.Vertex l22 =  new Graph.Vertex();
//    List<Graph.Vertex> outgoings  = new ArrayList<Graph.Vertex>();
//    List<Graph.Vertex>outgoings1  = new ArrayList<Graph.Vertex>();
//    List<Graph.Vertex> outgoings2  = new ArrayList<Graph.Vertex>();
//    List<Graph.Vertex> outgoings3  = new ArrayList<Graph.Vertex>();
//
//    private Graph.Vertex[] Convert(List<Graph.Vertex> temp){
//       Graph.Vertex[] results = new Graph.Vertex[temp.size()];
//        return temp.toArray(results);
//    }
//
//    //a graph contains a cycle which on the second path.
//    public void testFourNodesWithCycle() throws Exception {
//
//        outgoings.add(l1);
//        outgoings1.add(l22);
//        outgoings3.add(l21);
//        outgoings2.add(root);
//
//        root.setOutgoingEdges(Convert(outgoings));
//        l1.setOutgoingEdges(Convert(outgoings1));
//        l22.setOutgoingEdges(Convert(outgoings2));
//        l21.setOutgoingEdges(Convert(outgoings3));
//        Graph   graph = new Graph(root,4);
//        assertEquals(graph.repOK(),false);
//
//    }
//
//    // a four node graph with a triangle.
//    public void testFourNodesWithTriangle() throws Exception {
//
//        outgoings.add(l1);
//        outgoings.add(l21);
//        outgoings1.add(l22);
//        outgoings2.add(l1);
//        outgoings3.add(l21);
//        root.setOutgoingEdges(Convert(outgoings));
//        l1.setOutgoingEdges(Convert(outgoings1));
//        l21.setOutgoingEdges(Convert(outgoings2));
//        l22.setOutgoingEdges(Convert(outgoings3));
//
//        Graph   graph = new Graph(root,4);
//        assertEquals(graph.repOK(),false);
//
//    }
//    //from test2, change one edge to remove cycle.
//    public void testFourNodesDAG() throws Exception {
//
//        outgoings.add(l1);
//        outgoings.add(l21);
//        outgoings1.add(l22);
//        outgoings1.add(l21);
//        outgoings3.add(l21);
//        root.setOutgoingEdges(Convert(outgoings));
//        l1.setOutgoingEdges(Convert(outgoings1));
//        l21.setOutgoingEdges(Convert(outgoings2));
//        l22.setOutgoingEdges(Convert(outgoings3));
//
//        Graph   graph = new Graph(root,4);
//        assertEquals(graph.repOK(),true);
//        assertEquals(new Graph(root,-1).repOK(),false);
//
//    }
//
//    //one node
//    public void testOneNodeGraphe() throws Exception {
//        Graph   graph = new Graph(root,1);
//        assertEquals(graph.repOK(),true);
//
//    }
//
//    //two disjoin nodes and two connected nodes
//    public void testTwoNodesGraphe() throws Exception {
//        Graph   graph = new Graph(root,2);
//        assertEquals(graph.repOK(),false);
//
//        outgoings.add(l1);
//        root.setOutgoingEdges(Convert(outgoings));
//        assertEquals(graph.repOK(),true);
//
//    }
//
//
//
//
//
//
//
//}
