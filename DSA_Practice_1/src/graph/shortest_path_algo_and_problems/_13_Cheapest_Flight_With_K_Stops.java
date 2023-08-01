package graph.shortest_path_algo_and_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.Edge;

public class _13_Cheapest_Flight_With_K_Stops {

    static class Info {
        int n;
        int cost;
        int stops;
        Info(int n, int cost, int stops) {
            this.n = n;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            graph[src].add(new Edge(src, dest, cost));
        }
    }

    public static int cheapestFlight(int flights[][], int n, int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[n];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) break;

            for (int i = 0; i < graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if (curr.cost+wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                } 
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) return -1;

        return dist[dest];
    }

    public static void main(String[] args) {
        // ArrayList<Edge> graph1[] = new ArrayList[4];
        // ArrayList<Edge> graph2[] = new ArrayList[4];

        // for (int i = 0; i < 4; i++)  {
        //     graph1[i] = new ArrayList<>();
        //     graph2[i] = new ArrayList<>();
        // }

        // graph1[0].add(new Edge(0, 1, 100));
        // graph1[1].add(new Edge(1, 2, 100));
        // graph1[1].add(new Edge(1, 3, 600));
        // graph1[2].add(new Edge(2, 3, 200));
        // graph1[2].add(new Edge(2, 0, 100));

        // graph2[0].add(new Edge(0, 1, 1));
        // graph2[0].add(new Edge(0, 2, 5));
        // graph2[1].add(new Edge(1, 2, 1));
        // graph2[2].add(new Edge(2, 3, 1));
        
        int flights1[][] = {{0,1,100},{1,2,100},{1,3,600},{2,3,200},{2,0,100}};
        int flights2[][] = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};

        System.out.println(cheapestFlight(flights1, 4, 0, 3, 1));
        System.out.println(cheapestFlight(flights2, 4, 0, 3, 1));
    }
}
