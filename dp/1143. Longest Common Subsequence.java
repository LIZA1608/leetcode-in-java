

class Solution {
    public int lcs(String x,String y,int a,int b,int [][]dp){
        if(a==x.length() || b==y.length()){
            return 0;
        }
        if(dp[a][b]!=-1){
            return dp[a][b];
        }
        if(x.charAt(a)==y.charAt(b)){
            int ans=lcs(x,y,a+1,b+1,dp);
            return dp[a][b]=ans+1;
        }
        else{
            int t= lcs(x,y,a+1,b,dp);
            int h= lcs(x,y,a,b+1,dp);
            return dp[a][b]=Math.max(t,h);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int [text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
         return lcs(text1,text2,0,0,dp);
      
    }
}
