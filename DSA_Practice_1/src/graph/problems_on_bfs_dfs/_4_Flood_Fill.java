package graph.problems_on_bfs_dfs;

public class _4_Flood_Fill {

    public static void helper(int image[][], int sr, int sc, int color, int orgColor, boolean vis[][]) {
        if (sr >= image.length || sr < 0 || sc >= image[sr].length || sc < 0 || vis[sr][sc] || image[sr][sc] != orgColor) return;

        vis[sr][sc] = true;
        image[sr][sc] = color;

        // Left
        helper(image, sr, sc-1, color, orgColor, vis);
        // Right
        helper(image, sr, sc+1, color, orgColor, vis);
        // Up
        helper(image, sr-1, sc, color, orgColor, vis);
        // Bottom
        helper(image, sr+1, sc, color, orgColor, vis);
    }

    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, image[sr][sc], vis);

        return image;
    }
    public static void main(String[] args) {
        int image[][] = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};
        
        image = floodFill(image, 1, 1, 2);

        for (int row[] : image) {
            for (int x : row) {
                System.out.print(x+" ");
            }
            System.out.println();
        }

    }
}
