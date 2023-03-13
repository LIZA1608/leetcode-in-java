/*https://leetcode.com/problems/missing-number/*/

class Solution {
    public int missingNumber(int[] nums) {
     int n=nums.length;
     int sum=0;
     for(int i=0;i<n;i++){
         sum+=nums[i];
     }   
     int ap=n*(n+1)/2;
 int ans=ap-sum;
 return ans;
    }
}
