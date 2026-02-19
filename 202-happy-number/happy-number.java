class Solution {
    public boolean isHappy(int n) {
         int num=n;
         int sum=0;
         Set<Integer> s=new HashSet<>();
    while(num!=1){
       sum=0;
        if(s.contains(num)){
            return false;
        }
        else{
             s.add(num);
        }
        while(num>0){
            int digit=num%10;
             sum=sum+digit*digit;
            num=num/10;
        }
        
        num=sum;
        if(num==1){
            return true;
        }
    }
    if(num!=1)
    return false;
    
    return true;
    }
}