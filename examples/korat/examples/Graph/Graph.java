package korat.examples.graph;

import korat.finitization.IArraySet;
import korat.finitization.IFinitization;
import korat.finitization.IIntSet;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;

import java.util.ArrayList;
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


        Vertex[] outgoingEdges;

        public Vertex[] getOutgoingEdges() {
            return outgoingEdges;
        }

        public void setOutgoingEdges(Vertex[] outgoingEdges) {
            this.outgoingEdges = outgoingEdges;
        }

        public Vertex(Vertex[] outgoingEdges) {
            this.outgoingEdges = outgoingEdges;
        }
        public  Vertex(){

        }
    }

    public Graph(Vertex root, int size) {
        this.root = root;
        this.size = size;
    }

    public Graph(){

    }

    // helper function to recursive run dsf. If there exists a back edge, then there is a cycle.
    private boolean dfs(Vertex v,Set<Vertex> visited,Set<Vertex> path){
        boolean result=true;
        visited.add(v);
        path.add(v);
        if(v.getOutgoingEdges()!=null && v.getOutgoingEdges().length>0){
//            for(Vertex child:v.getOutgoingEdges()){
            for(int i=0;i<v.getOutgoingEdges().length;i++){
                if(v.getOutgoingEdges()[i]==null)
                    continue;
                Vertex child = v.getOutgoingEdges()[i];
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
    public boolean repOK() {
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
        f.set("size", f.createIntSet(nodesNum));
        IObjSet nodes = f.createObjSet(Graph.Vertex.class, nodesNum,false);
        f.set("root", nodes);
        IIntSet arrLen = f.createIntSet(0, nodesNum - 1);
        IArraySet childrenArray = f.createArraySet(Vertex[].class, arrLen, nodes, nodesNum);
        f.set("Vertex.outgoingEdges",childrenArray);

        return f;
    }
}
