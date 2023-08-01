package graph.min_spanning_tree_disjointSet_and_problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

import graph.Edge;

public class _2_Prims_Algo {

    static class Pair implements Comparable<Pair> {
        int n;
        int cost;
        Pair(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost-p2.cost;
        }
    }

    public static int prims_algo_minCost(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCost = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;
                finalCost += curr.cost;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    pq.add(new Pair(e.dest, e.weight));
                }
            }
        }

        return finalCost;
    }

    public static void prims_algo_getEdges(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight-b.weight);
        ArrayList<Edge> edges = new ArrayList<>();

        pq.add(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;

                edges.add(new Edge(curr.src, curr.dest, curr.weight));

                for (int i = 0; i < graph[curr.src].size(); i++) {
                    Edge e = graph[curr.src].get(i);
                    pq.add(new Edge(e.src, e.dest, e.weight));
                }
            }
        }

        if (edges.size() > 0) {
            edges.remove(0);
        }
        
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            System.err.println(e.src + " -> " + e.dest + " [" + e.weight + "]");
        }
        
    }



    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[4];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        System.out.println(prims_algo_minCost(graph));
        System.out.println();
        prims_algo_getEdges(graph);
    }
}
