package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * It assigns left less frequent feasible
 color in the graph to vertex v. If this is not possible, it assigns left
 feasible color that does not generate conflicts using Greedy (v). If
 the function changes the color assigned to the vertex, it returns
 true; otherwise, it returns false
 */
public class LessFrequentColor extends Function{

    public int getInputs(){return 1;}

    public LessFrequentColor(Tree t){
        super(t);
    }

    public boolean run(){
        if(left==null){
            return false;
        }

        Vertex v = left.search();
        if(v == null){
            return false;
        }

        int color = 0;
        int minFreq = Integer.MIN_VALUE;

        for (int i = 0; i < t.graphColorFreq.length; i++) {
            if(t.graphColorFreq[i]<minFreq){
                color=i;
                minFreq = t.graphColorFreq[i];
            }
        }


        MoreFrequentColor clasher = new MoreFrequentColor(t);

        if(color!=Integer.MAX_VALUE && !clasher.clash(v, color)){
            t.graphColorFreq[t.graphColors[v.index]]--;
            t.graphColors[v.index] = color;
            t.graphColorFreq[color]++;
            return true;
        }else{
            Greedy greedy = new Greedy(t);
            greedy.setFunctionLeft(left);
            greedy.setFunctionRight(right);
            return greedy.run();
        }

    }
}
