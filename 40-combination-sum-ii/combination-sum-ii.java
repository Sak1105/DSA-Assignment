class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        Arrays.sort(candidates);
        findSolution( candidates,0,target, ans, ds);
        return ans;
    }
    private void findSolution(int[] candidates,int index,int target, List<List<Integer>> ans, List<Integer> ds){
        
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
          
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target<candidates[i]){
                break;
            }
            ds.add(candidates[i]);
            findSolution(candidates,i+1,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }

    }
}