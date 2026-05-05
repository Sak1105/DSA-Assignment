class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        q.add(0);
        visited[0]=true;
        while(q.size()>0){
            int front=q.remove();
            List<Integer> l=rooms.get(front);
            for(int i:l){
                if(!visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        for(boolean i:visited){
            if(!i){
                return false;
            }
        }
        return true;
    }
}