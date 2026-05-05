class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    
    }
        private void bfs(int[][] isConnected,int i, boolean[] visited ){
           Queue<Integer> q=new LinkedList<>();
           int n=isConnected.length;
           visited[i]=true;
           q.add(i);
           while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<n;j++){
                if((isConnected[front][j]==1) && (visited[j]==false)){
                    q.add(j);
                    visited[j]=true;
                }
            }
           }
        }
}