class Solution {

    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        int[][] memo = new int[m][n];
        int maxPath = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, memo, i, j));
            }}
        return maxPath;
    }
    private int dfs(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];

        int max = 1; 

        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < m && y >= 0 && y < n &&
                matrix[x][y] > matrix[i][j]) {

                max = Math.max(max, 1 + dfs(matrix, memo, x, y));
            }}
       memo[i][j] = max; 
        return max;
    }
}
