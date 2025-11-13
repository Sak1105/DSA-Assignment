public class KBattleships {

    static int N, K;
    static char[][] board;
    static boolean found = false;

    public static void main(String[] args) {
        N = 4;
        K = 3;
        board = new char[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = '.';

        placeShips(0, 0, 0);

        if (!found)
            System.out.println("No valid arrangement possible.");
    }

    static void placeShips(int row, int col, int count) {
        if (count == K) {
            printBoard();
            found = true;
            return;
        }

        if (row >= N) return;

        int nextRow = (col == N - 1) ? row + 1 : row;
        int nextCol = (col == N - 1) ? 0 : col + 1;

        if (isSafe(row, col)) {
            board[row][col] = 'B';
            placeShips(nextRow, nextCol, count + 1);
            board[row][col] = '.'; 
        }

        placeShips(nextRow, nextCol, count);
    }

    static boolean isSafe(int r, int c) {
        if (board[r][c] == 'B') return false;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 'B')
                return false;
        }
        return true;
    }

    static void printBoard() {
        System.out.println("Valid board:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

