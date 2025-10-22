import java.util.*;

class Solution {
    private static final int MAX = (int) 1e6;
    private static final int LIMIT = 200 * 199 / 2; 

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(hash(b[0], b[1]));
        }
        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] end, Set<Long> blockedSet) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(hash(start[0], start[1]));

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty() && visited.size() <= LIMIT) {
            int[] curr = queue.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) return true;

            for (int[] d : dirs) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                long h = hash(nx, ny);

                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (blockedSet.contains(h) || visited.contains(h)) continue;

                visited.add(h);
                queue.offer(new int[]{nx, ny});
            }
        }
        return visited.size() > LIMIT;
    }

    private long hash(int x, int y) {
        return ((long)x << 20) + y; 
    }
}
