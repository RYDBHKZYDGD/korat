package korat.examples.Graph;

import korat.finitization.IFinitization;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 */
public class Graph {
    Vertex root;

    //added by checking reachable
    int size;
    public static class Vertex {


        public List<Vertex> getOutgoingEdges() {

            return outgoingEdges;
        }

        public void setOutgoingEdges(List<Vertex> outgoingEdges) {
            this.outgoingEdges = outgoingEdges;
        }

        List<Vertex> outgoingEdges;
    }

    public Graph(Vertex root, int size) {
        this.root = root;
        this.size = size;
    }

    public Graph(){

    }

    // helper function to recursive run dsf. If there exists a back edge, then there is a cycle.
    boolean dfs(Vertex v,Set<Vertex> visited,Set<Vertex> path){
        boolean result=true;
        visited.add(v);
        path.add(v);
        if(v.getOutgoingEdges()!=null && v.getOutgoingEdges().size()!=0){
            for(Vertex child:v.getOutgoingEdges()){
                if(path.contains(child)){
                   return false;
                }
                else{

                   result= dfs(child,visited,path);
                   if(result==false){
                       return false;
                   }
                }

            }
        }
        path.remove(v);
        return  result;
    }

    //root must be a source in the DAG.
    public boolean repOk() {
        // returns true if and if only the graph reachable from "root"
        // is a directed acyclic graph

        Set<Vertex> visited = new HashSet<Vertex>();
        Set<Vertex> path = new HashSet<Vertex>();

        if(size<1){
            return false;
        }
        if(dfs(root,visited,path)){
            if(size==visited.size()){
                 return true;
            }
          }
        return false;


    }
    public static IFinitization finGraph(int nodesNum) {
        IFinitization f = FinitizationFactory.create(Graph.class);
        IObjSet nodes = f.createObjSet(Vertex.class, nodesNum);
        f.set("root", nodes);
        return f;
    }
}
