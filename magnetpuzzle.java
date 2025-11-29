import java.util.*;

public class magnetpuzzle {
    static int R, C;
    static char[][] grid;
    static int[][] ans;        

    static int[] top, bottom, left, right; 

    static boolean isSafe(int r, int c, int val) {
        if (r < 0 || r >= R || c < 0 || c >= C) return false;

        if (r > 0 && ans[r - 1][c] == val) return false;
        if (r < R - 1 && ans[r + 1][c] == val) return false;
        if (c > 0 && ans[r][c - 1] == val) return false;
        if (c < C - 1 && ans[r][c + 1] == val) return false;

        return true;
    }

    static boolean checkConstraints() {
       
        for (int i = 0; i < R; i++) {
            int plus = 0, minus = 0;
            for (int j = 0; j < C; j++) {
                if (ans[i][j] == 1) plus++;
                if (ans[i][j] == -1) minus++;
            }
            if (left[i] != -1 && plus != left[i]) return false;
            if (right[i] != -1 && minus != right[i]) return false;
        }

      
        for (int j = 0; j < C; j++) {
            int plus = 0, minus = 0;
            for (int i = 0; i < R; i++) {
                if (ans[i][j] == 1) plus++;
                if (ans[i][j] == -1) minus++;
            }
            if (top[j] != -1 && plus != top[j]) return false;
            if (bottom[j] != -1 && minus != bottom[j]) return false;
        }
        return true;
    }

    static boolean solve(int r, int c) {
        if (r == R) return checkConstraints();

        int nr = (c == C - 1) ? r + 1 : r;
        int nc = (c == C - 1) ? 0 : c + 1;

        char ch = grid[r][c];

        if (ch == 'R' || ch == 'B' || ch == 'X') {
            return solve(nr, nc);
        }

        if (ch == 'L') {
            
            if (c + 1 >= C || grid[r][c + 1] != 'R') {
                
                return false;
            }
            if (isSafe(r, c, 1) && isSafe(r, c + 1, -1)) {
                ans[r][c] = 1; ans[r][c + 1] = -1;
                if (solve(nr, nc)) return true;
                ans[r][c] = ans[r][c + 1] = 0;
            }

           
            if (isSafe(r, c, -1) && isSafe(r, c + 1, 1)) {
                ans[r][c] = -1; ans[r][c + 1] = 1;
                if (solve(nr, nc)) return true;
                ans[r][c] = ans[r][c + 1] = 0;
            }
            ans[r][c] = ans[r][c + 1] = 0;
            if (solve(nr, nc)) return true;
            ans[r][c] = ans[r][c + 1] = 0;

            return false;
        }
        if (ch == 'T') {
            if (r + 1 >= R || grid[r + 1][c] != 'B') {
                return false;
            }
            if (isSafe(r, c, 1) && isSafe(r + 1, c, -1)) {
                ans[r][c] = 1; ans[r + 1][c] = -1;
                if (solve(nr, nc)) return true;
                ans[r][c] = ans[r + 1][c] = 0;
            }
            if (isSafe(r, c, -1) && isSafe(r + 1, c, 1)) {
                ans[r][c] = -1; ans[r + 1][c] = 1;
                if (solve(nr, nc)) return true;
                ans[r][c] = ans[r + 1][c] = 0;
            }
            ans[r][c] = ans[r + 1][c] = 0;
            if (solve(nr, nc)) return true;
            ans[r][c] = ans[r + 1][c] = 0;

            return false;
        }
        return solve(nr, nc);
    }

    public static void main(String[] args) {
        grid = new char[][] {
            {'L','R','T','B'},
            {'L','R','T','B'}
        };

        left   = new int[]{1, 1};          
        right  = new int[]{1, 1};          
        top    = new int[]{1, 1, 1, 1};     
        bottom = new int[]{1, 1, 1, 1};    

        R = grid.length;
        C = grid[0].length;
        ans = new int[R][C]; 

        boolean solved = solve(0, 0);

        if (!solved) {
            System.out.println("No solution found.");
            return;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ans[i][j] == 1) System.out.print("+ ");
                else if (ans[i][j] == -1) System.out.print("- ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }
}

