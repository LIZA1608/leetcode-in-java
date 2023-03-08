/*https://leetcode.com/problems/subarray-product-less-than-k/*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0;
        int count=0;
        int pro=1;
        for(int i=0;i<nums.length;i++){
            pro=pro*nums[i];
            while(start<=i && pro>=k){
                pro=pro/nums[start];
                start++;
            }
            count=count+i-start+1;
        }
        return count;
    }
}
