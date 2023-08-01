package graph.topo_sort_and_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.Edge;

public class _2_Kahns_Algo {

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topologicalSort_BFS (ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
