/*https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/*/

//use kmp 

class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int []lps=new int [m];
        int len=0;
        int i=1;
        while(i<m){
            if(needle.charAt(len)==needle.charAt(i)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }
                else{
                    len=lps[len-1];
                }
            }
        }
        int s1=0;
        int s2=0;
        while(s1<n){
          if(haystack.charAt(s1)==needle.charAt(s2)){
              s1++;
              s2++;
         if(s2==m){
               return s1-m;
         }
          }
          else{
              if(s2==0){
                  s1++;
              }
              else{
                s2= lps[s2-1];
              }
          }
        }
        return -1;
    }
}
