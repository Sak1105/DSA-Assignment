class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
         int[] indegree =new int[n];
        int[] outdegree =new int[n];
        int[][] adj=new int[n][n];
        int len=prerequisites.length;
       for(int i = 0; i < prerequisites.length; i++) {
    int course = prerequisites[i][0];
    int prerequisite = prerequisites[i][1];

    adj[prerequisite][course] = 1;
}
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
            if(adj[i][j]==1){
                indegree[j]++;
                outdegree[i]++;
            }
           }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
        int temp=q.poll();
        ans.add(temp);
        for(int j=0;j<n;j++){
            if(adj[temp][j]!=0){
                indegree[j]--;
             if(indegree[j]==0){
                q.add(j);
            }
            }
        }
        
        }
        boolean flag=false;
         if(ans.size()!=n){
            return false;
         }
        return true;
        
    }
    private static boolean allZero(int[] indegree){
        int n=indegree.length;
        for(int i=0;i<n;i++){
            if(indegree[i]!=0){
                return false;
            }
        }
        return true;
    }   
}