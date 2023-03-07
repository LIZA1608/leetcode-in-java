/*https://leetcode.com/problems/longest-palindromic-substring/*/

class Solution {
    public String longestPalindrome(String s) {
     if(s.length()==0){
         return "";
     }   
     int left=0,right=0,max_len=0;
     for(int i=0;i<s.length()-1;i++){
         for(int j=0;i-j>-1 && i+j<s.length();j++){
            if(s.charAt(i-j)==s.charAt(i+j)){
                if(max_len<2*j+1){
                    max_len=2*j+1;
                    left=i-j;
                    right=i+j;
                }
            }
                else{
                    break;
                }
            }
             for(int j=0;i+j+1<s.length()&&i-j>-1;j++){
                 if(s.charAt(i+j+1)==s.charAt(i-j)){
                     if(max_len<2*j+2){
                         max_len=2*j+2;
                         left=i-j;
                         right=i+j+1;
                     }
                 }
                 else{
                     break;
                 }
             }
         }
         if(max_len==0){
             return ""+s.charAt(0);
         }
         return s.substring(left,right+1);
     }
}
