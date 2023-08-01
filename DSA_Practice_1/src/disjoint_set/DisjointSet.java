package disjoint_set;

public class DisjointSet {

    int par[];
    int rank[];

    public DisjointSet(int n) {
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        rank = new int[n];
    }

    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            this.par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            this.par[parB] = parA;
        } else {
            this.par[parA] = parB;
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);
        ds.union(1, 3);
        System.out.println(ds.find(3));
        ds.union(2, 4);
        System.out.println(ds.find(4));
        ds.union(3, 6);
        ds.union(1, 4);
        System.out.println(ds.find(3));
        // ds.union(1, 5);

        for (int i = 0; i < ds.par.length; i++) {
            System.out.print(ds.par[i]+" ");
        }
    }
}
