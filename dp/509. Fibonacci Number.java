class Solution {
    public int fib(int n) {
        return fibo(n,new int [n+1]);
    }
    public int fibo(int n,int []dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
        return dp[n];
    }
}
