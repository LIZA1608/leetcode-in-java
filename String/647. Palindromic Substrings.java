/*https://leetcode.com/problems/palindromic-substrings/*/

class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        //odd length
        for(int i=0;i<s.length();i++){
            for(int j=0;i-j>=0 && i+j<s.length();j++){
                if(s.charAt((int)(i-j))==s.charAt((int)(i+j))){
                    ans++;
                }
                else{
                    break;
                }
            }
        }
        //even length
        for(double i=0.5;i<s.length();i++){
            for(double j=0.5 ;i-j>=0 && i+j<s.length();j++){
                if(s.charAt((int)(i-j))==s.charAt((int)(i+j))){
                    ans++;
                }
                else{
                    break;
                }
            }
        }
        return ans;
    }
}
