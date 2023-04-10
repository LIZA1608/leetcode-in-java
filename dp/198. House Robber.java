class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int []dp=new int [n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
            }
            public int solve(int []nums,int idx,int []dp){
                int n=nums.length;
                if(idx>=n){
                    return 0;
                }
                if(dp[idx]!=-1){
                    return  dp[idx];
                }
                int inc=nums[idx]+solve(nums,idx+2,dp);
                int exl=solve(nums,idx+1,dp);
               dp[idx]=Math.max(inc,exl);
                return dp[idx];
            }
}
