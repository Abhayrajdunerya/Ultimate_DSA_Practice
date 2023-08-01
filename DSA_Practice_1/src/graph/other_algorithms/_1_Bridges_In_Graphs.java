package graph.other_algorithms;

import java.util.ArrayList;

import graph.Edge;

// Tarjan's Algorithm
public class _1_Bridges_In_Graphs {

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int dt[], int low[], int time, int curr, int par) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                dfs(graph, vis, dt, low, time, neigh, curr);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.println(curr + " ----- " + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    // O(V+E)
    public static void tarjansAlgo_findBridges(ArrayList<Edge> graph[]) {
        int n = graph.length;
        boolean vis[] = new boolean[n];

        int dt[] = new int[n];
        int low[] = new int[n];
        int time = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, vis, dt, low, time, i, -1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph1[] = new ArrayList[5];
        ArrayList<Edge> graph2[] = new ArrayList[6];

        for (int i = 0; i < 6; i++) {
            if (i < 5) {
                graph1[i] = new ArrayList<>();
            }
            graph2[i] = new ArrayList<>();
        }

        graph1[0].add(new Edge(0, 1, 0));
        graph1[0].add(new Edge(0, 2, 0));
        graph1[0].add(new Edge(0, 3, 0));

        graph1[1].add(new Edge(1, 0, 0));
        graph1[1].add(new Edge(1, 2, 0));

        graph1[2].add(new Edge(2, 0, 0));
        graph1[2].add(new Edge(2, 1, 0));

        graph1[3].add(new Edge(3, 0, 0));
        graph1[3].add(new Edge(3, 4, 0));

        graph1[4].add(new Edge(4, 3, 0));


        graph2[0].add(new Edge(0, 1, 0));
        graph2[0].add(new Edge(0, 2, 0));
        graph2[0].add(new Edge(0, 3, 0));

        graph2[1].add(new Edge(1, 0, 0));
        graph2[1].add(new Edge(1, 2, 0));

        graph2[2].add(new Edge(2, 0, 0));
        graph2[2].add(new Edge(2, 1, 0));

        graph2[3].add(new Edge(3, 0, 0));
        graph2[3].add(new Edge(3, 4, 0));
        graph2[3].add(new Edge(3, 5, 0));

        graph2[4].add(new Edge(4, 3, 0));
        graph2[4].add(new Edge(4, 5, 0));

        graph2[5].add(new Edge(5, 3, 0));
        graph2[5].add(new Edge(5, 4, 0));

        tarjansAlgo_findBridges(graph1);
        System.out.println();
        tarjansAlgo_findBridges(graph2);
    }
}
