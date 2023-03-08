/*https://leetcode.com/problems/maximum-product-subarray/*/

class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
   if(n==0){
       return 0;
   }
        int u=nums[0];
        int min=u;
        int max=u;
        for(int i=1;i<n;i++){
            if(nums[i]>=0){
            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);
        }
        else{
            int temp=max;
            max=Math.max(nums[i],min*nums[i]);
            min=Math.min(nums[i],temp*nums[i]);
        }
        u=Math.max(u,max);
        }
        return u;
    }
}
