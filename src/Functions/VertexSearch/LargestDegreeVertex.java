package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

import java.util.ArrayList;

/**
 * Created by Brendan on 9/09/2017.
 *Largest-degree-vertex: It identifies the vertex with the
 most adjacent vertices. If there is more than one vertex that
 fulfills this characteristic, it returns the lowest numbered vertex
 that fulfills this condition, based on the Modified Largest
 Degree Ordering [31] vertex selection criterion; if the vertex
 does not exist, it returns false.
 */
public class LargestDegreeVertex extends Function {

    public boolean run(){return search() != null;}

    public LargestDegreeVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        Vertex largest = t.currentGraph.verticies.get(0);
        for(Vertex v: t.currentGraph.verticies){
            if(largest.neighbours.size()<v.neighbours.size()){
                largest = v;
            }
        }
        return largest;
    }
}
