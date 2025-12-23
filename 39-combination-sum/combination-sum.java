class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ds= new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
         findSolution(candidates, target,0,ans, ds );
        return ans;
    
        
    }
    private void findSolution(int[] candidates, int target,int index,List<List<Integer>> ans, List<Integer> ds )
    {
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){
            ds.add(candidates[index]);
            findSolution( candidates,target-candidates[index],index, ans,ds);
        
            ds.remove(ds.size()-1);
        }
            findSolution( candidates,target,index+1, ans,ds);


        }
    }
