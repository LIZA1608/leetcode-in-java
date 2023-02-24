/*https://leetcode.com/problems/max-consecutive-ones/description/*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int ans=Integer. MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                count=0;
            }
                ans=Math.max(ans,count);
            
        }
        return ans;
    }
}
