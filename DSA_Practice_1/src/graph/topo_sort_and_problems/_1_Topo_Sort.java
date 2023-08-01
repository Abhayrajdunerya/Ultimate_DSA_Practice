package graph.topo_sort_and_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import graph.Edge;

public class _1_Topo_Sort {

    public static void topologicalSort_DFS_util(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> s, int curr) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
                topologicalSort_DFS_util(graph, vis, s, e.dest);
            }

        }

        s.push(curr);
    }

    public static void topologicalSort_DFS(ArrayList<Edge> graph[]) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSort_DFS_util(graph, vis, s, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topologicalSort_BFS (ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 1, 0));
        graph[4].add(new Edge(4, 0, 0));
        graph[4].add(new Edge(4, 1, 0));
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        topologicalSort_DFS(graph);
        System.out.println();
        topologicalSort_BFS(graph);
    }
}
