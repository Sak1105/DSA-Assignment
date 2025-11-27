class Solution {
    public String longestPalindrome(String s) {
        String longest="";
        String str="";
        
        for(int i=0;i<s.length();i++)
        {
          str=findPali(s,i,i+1,longest);
          if(str.length()>longest.length())
          {
            longest=str;
    
          }
          str=findPali(s,i,i,longest);
          if(str.length()>longest.length())
          {
            longest=str;
    
          }

        }
        return longest;
    }
    

private String findPali(String s, int left, int right,String longest)
{
    String str="", longestpali="";
 while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) 
 {
     str=s.substring(left,right+1);
           if(longestpali.length()<str.length()){
            longestpali=  str;
           }
            left--;
            right++;
 }  
 return longestpali;
}
}

   