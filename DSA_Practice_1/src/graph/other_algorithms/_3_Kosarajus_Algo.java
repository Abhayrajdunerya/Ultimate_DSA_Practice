package graph.other_algorithms;

import java.util.ArrayList;
import java.util.Stack;

import graph.Edge;

// Find Strongly Connected Components
public class _3_Kosarajus_Algo {

    public static void topoSort(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s) {
        vis[curr] = true;
        
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topoSort(graph, vis, e.dest, s);
            }
        }

        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        System.out.print(curr+" ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    // O(V+E)
    public static void kosarajusAlgo(ArrayList<Edge> graph[]) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        Stack<Integer> s = new Stack<>();
        ArrayList<Edge> transpose[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            transpose[i] = new ArrayList<>();
            if (!vis[i]) {
                topoSort(graph, vis, i, s);
            }
        }


        for (int i = 0; i < n; i++) {
            vis[i] = false;
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int src = e.src;
                int dest = e.dest;
                transpose[dest].add(new Edge(dest, src, 0));
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(transpose, vis, i);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Edge> graph1[] = new ArrayList[5];
        ArrayList<Edge> graph2[] = new ArrayList[7];

        for (int i = 0; i < graph1.length; i++) {
            graph1[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph1[0].add(new Edge(0, 2, 0));
        graph1[0].add(new Edge(0, 3, 0));
        graph1[1].add(new Edge(1, 0, 0));
        graph1[2].add(new Edge(2, 1, 0));
        graph1[3].add(new Edge(3, 4, 0));

        graph2[0].add(new Edge(0, 2, 0));
        graph2[1].add(new Edge(1, 0, 0));
        graph2[2].add(new Edge(2, 1, 0));
        graph2[2].add(new Edge(2, 5, 0));
        graph2[4].add(new Edge(4, 6, 0));
        graph2[5].add(new Edge(5, 4, 0));
        graph2[6].add(new Edge(6, 5, 0));

        kosarajusAlgo(graph1);
        System.out.println();
        kosarajusAlgo(graph2);

    }
}
