/*https://leetcode.com/problems/palindromic-substrings/*/

class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        //axis orbit approch
        //odd length
        for(int i=0;i<s.length();i++){
            for(int j=0;i-j>=0 && i+j<s.length();j++){
                if(s.charAt(i-j)==s.charAt(i+j)){
                    ans++;
                }
                else{
                    break;
                }
            }
        }
        //even length
for(int l=0,r=1;r<s.length();l++,r++){
    for(int orbit=0;l-orbit>=0&&r+orbit<s.length();orbit++){
        if(s.charAt(l-orbit)==s.charAt(r+orbit)){
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
