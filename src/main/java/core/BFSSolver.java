package core;

import utils.Graph;
import utils.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSSolver extends ISolver{
    @Override
    public Vertex solve(Graph graph) {
        Queue<Vertex> search_que=new LinkedList<Vertex>();
        search_que.offer(graph.vtx);
        while(!search_que.isEmpty()){
            Vertex nvtx=search_que.poll();
            if(is_same(nvtx))
                return nvtx;
            nvtx.vtx.keySet().forEach((x)->{
                if(nvtx.active.get(x)&&nvtx.data.get(x)<nvtx.state.get(x)-1)
                    search_que.offer(spread(nvtx,graph.edge,x));
            });
        }
        return null;
    }
}
