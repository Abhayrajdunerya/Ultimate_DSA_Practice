package graph.shortest_path_algo_and_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import graph.Edge;


public class _3_Dijisktras_Algo {

    static class Pair implements Comparable<Pair> {
        int n;
        int path;
        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path-p2.path;
        }
    }

    // O(V+E.log(V))
    public static void shortest_path_Dijisktras(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(v, wt));
                    }

                }
            }

        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        shortest_path_Dijisktras(graph, 0);
    }
}
