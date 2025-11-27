class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0) return false;
        int total = n * n;
        int[][] pos = new int[total][2]; 
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int val = grid[r][c];
                if (val < 0 || val >= total) return false;
                pos[val][0] = r;
                pos[val][1] = c;
            }
        }
        for (int k = 0; k < total - 1; k++) {
            int r1 = pos[k][0], c1 = pos[k][1];
            int r2 = pos[k + 1][0], c2 = pos[k + 1][1];

            if (!isKnightMove(r1, c1, r2, c2)) {
                return false;
            }
        }
      return true; 
    }

    private boolean isKnightMove(int r1, int c1, int r2, int c2) {
        int dr = Math.abs(r1 - r2);
        int dc = Math.abs(c1 - c2);
        return (dr == 1 && dc == 2) || (dr == 2 && dc == 1);
    }
}
