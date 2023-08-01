package graph.problems_on_bfs_dfs;

import java.util.ArrayList;

import graph.Edge;

public class _12_Has_Path {

    public static boolean hasPathUtil(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest) return true;

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if (!vis[e.dest] && hasPathUtil(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest) {
        if (src >= graph.length) return false;
        boolean vis[] = new boolean[graph.length];

        return hasPathUtil(graph, src, dest, vis);

    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[7];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));

        System.out.println(hasPath(graph, 0, 5));
    }
}
