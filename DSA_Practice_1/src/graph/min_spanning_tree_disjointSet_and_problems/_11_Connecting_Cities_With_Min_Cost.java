package graph.min_spanning_tree_disjointSet_and_problems;

import java.util.PriorityQueue;

public class _11_Connecting_Cities_With_Min_Cost {

    private static class Edge implements Comparable<Edge> {
        int dest;
        int cost;
        Edge(int d, int cost) {
            this.dest = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost-e2.cost;
        }
    }

    public static int minCost(int cities[][]) {
        boolean vis[] = new boolean[cities.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    int dest = i;
                    int cost = cities[curr.dest][i];

                    if (cities[curr.dest][i] != 0) pq.add(new Edge(dest, cost));
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},
                          {1,0,5,0,7},
                          {1,5,0,6,0},
                          {3,0,6,0,0},
                          {4,7,0,0,0}};

        System.out.println(minCost(cities));
    }
}
