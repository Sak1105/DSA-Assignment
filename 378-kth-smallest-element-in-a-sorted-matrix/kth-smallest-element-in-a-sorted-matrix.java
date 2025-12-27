class Solution {
    static class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        for (int i = 0; i < n; i++) {
            minHeap.add(new Node(matrix[i][0], i, 0));
        }
        Node curr = null;
        for (int i = 0; i < k; i++) {
            curr = minHeap.poll();
            int r = curr.row;
            int c = curr.col;
            if (c + 1 < n) {
                minHeap.add(new Node(matrix[r][c + 1], r, c + 1));
            }
        }
        return curr.val;
    }
}
