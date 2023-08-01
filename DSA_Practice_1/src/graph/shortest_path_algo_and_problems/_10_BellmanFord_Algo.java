package graph.shortest_path_algo_and_problems;

import java.util.ArrayList;
import java.util.Arrays;

import graph.Edge;

public class _10_BellmanFord_Algo {

    // O(V+E.V)
    public static void shortest_path_BellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int vertices = graph.length-1;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        dist[v] = dist[u]+wt;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        shortest_path_BellmanFord(graph, 0);

    }
}
