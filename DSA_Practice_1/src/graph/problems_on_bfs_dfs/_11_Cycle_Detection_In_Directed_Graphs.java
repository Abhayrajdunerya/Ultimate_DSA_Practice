package graph.problems_on_bfs_dfs;

import java.util.ArrayList;

import graph.Edge;

public class _11_Cycle_Detection_In_Directed_Graphs {

    // DFS - O(V+E)
    public static boolean cycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && cycleUtil(graph, vis, stack, i)) {
                return true;
            }
        }

        return false;
    }

    // O(V+E)
    public static boolean cycleUtil(ArrayList<Edge> graph[], boolean vis[], boolean stack[], int curr) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) {
                return true;
            }

            if (!vis[e.dest] && cycleUtil(graph, vis, stack, e.dest)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        
    }
}
