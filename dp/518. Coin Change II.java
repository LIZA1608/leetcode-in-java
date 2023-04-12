class Solution {
    public int change(int amount, int[] coins) {
    int [][]dp=new int [amount+1][coins.length];
    for(int []x:dp){
        Arrays.fill(x,-1);
    }
        return solve(amount,coins,0,dp);
    }
public int solve(int amount,int coins[],int idx,int [][]dp){
    if(idx>=coins.length){
        return 0;
    }
    if(amount==0){
        return 1;
    }
    if(dp[amount][idx]!=-1){
        return dp[amount][idx];
    }
    int inc=0;
 if(amount>=coins[idx]){
     inc=solve(amount-coins[idx],coins,idx,dp);
 }
    int exc=solve(amount,coins,idx+1,dp);
    dp[amount][idx]=inc+exc;
    return dp[amount][idx];
}
}
