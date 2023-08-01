package graph.problems_on_bfs_dfs;

import java.util.ArrayList;

import graph.Edge;

public class _6_Cycle_Detection_In_Unidirected_Graph_DFS {

    public static boolean cycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                if (cycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }

        return false;
    }

    // O(V+E)
    public static boolean cycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        
    }
}
