package graph.min_spanning_tree_disjointSet_and_problems;

import java.util.ArrayList;
import java.util.Collections;

import disjoint_set.DisjointSet;
import graph.Edge;

public class _4_Kruskals_Algo {

    public static int kruskals_algo_minCost(ArrayList<Edge> edges, int v) {
        Collections.sort(edges, (a, b) -> a.weight-b.weight);
        DisjointSet ds = new DisjointSet(v);
        int mstCost = 0;
        int count = 0;
        for (int i = 0; count < v-1; i++) {
            Edge e = edges.get(i);
            int parA = ds.find(e.src);
            int parB = ds.find(e.dest);

            if (parA != parB) {
                mstCost += e.weight;
                ds.union(e.src, e.dest);
                count++;
            }
        }

        return mstCost;
    }
    public static void main(String[] args) {
        ArrayList<Edge> edges1 = new ArrayList<>();
        edges1.add(new Edge(0, 1, 10));
        edges1.add(new Edge(0, 2, 15));
        edges1.add(new Edge(0, 3, 30));
        edges1.add(new Edge(1, 3, 40));
        edges1.add(new Edge(2, 3, 50));

        System.out.println(kruskals_algo_minCost(edges1, 4));
    }
}
