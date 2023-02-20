/*https://leetcode.com/problems/di-string-match/description/*/


class Solution {
    public int[] diStringMatch(String s) {
        int[] ans=new int [s.length()+1];
        int start=0;
        int end=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                ans[i]=start;
                start++;
            }
            else{
                ans[i]=end;
                end--;
            }
        }
         ans[s.length()]=start;
        return ans;
    }
}
