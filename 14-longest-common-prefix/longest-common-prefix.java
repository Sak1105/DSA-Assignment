class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str="";
        for(int i=0;i<strs[0].length();i++)
        {
            char first=strs[0].charAt(i);
        char last=strs[strs.length-1].charAt(i);
            if(first!=last)
            {
                return str;
            }
            else
            {
                str=str+strs[0].charAt(i);
            }

        }
        return str;
        
        
    }
}