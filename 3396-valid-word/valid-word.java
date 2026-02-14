class Solution {
    public boolean isValid(String word) {
        int noOfChars=0;
        int vowels=0;
        int cons=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
            {
                noOfChars++;
                 ch = Character.toLowerCase(ch);
                  if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
        vowels++;
    } else {
         cons++;
    }
            }
            else if(Character.isDigit(ch)){
                noOfChars++;

            }
            else{
                return false;
            }

        }
        if(noOfChars>=3 && vowels>=1 && cons>=1){
            return true;
        }
        return false;
         
    }
}