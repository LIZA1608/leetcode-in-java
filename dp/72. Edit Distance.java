class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
       int dp[][]=new int [n+1][m+1];
       return solve(word1,word2,n,m,dp);
    }
    int solve(String word1,String word2,int n,int m,int [][]dp){
        if(dp[n][m]>0){
            return dp[n][m];
        }
        if(n==0){
            dp[n][m]=m;
            return m;
        }
        if(m==0){
            dp[n][m]=n;
            return n;
        }
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            dp[n][m]=solve(word1,word2,n-1,m-1,dp);
        }
        else{
            int replace=1+solve(word1,word2,n-1,m-1,dp);
            int insert=1+solve(word1,word2,n,m-1,dp);
            int delete=1+solve(word1,word2,n-1,m,dp);
            dp[n][m]=Math.min(replace,Math.min(insert,delete));
        }
    return dp[n][m];
    }
}
