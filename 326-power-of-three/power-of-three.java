class Solution {
    public boolean isPowerOfThree(int n) {
         return check(n,0);


        
    }
    private boolean check(int n, int i){
        if(n<Math.pow(3,i))
        {
            return false;
        }
        if(n==Math.pow(3,i))
        {
            return true;
        }
        return check(n,i+1);
    }
}