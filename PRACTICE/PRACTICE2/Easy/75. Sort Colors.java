/*https://leetcode.com/problems/sort-colors/description/*/

class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int curr=0;
        while(curr<=right){
            if(nums[curr]==0){
                swap(nums,left,curr);
                left++;
                curr++;
            }
            else if(nums[curr]==2){
                swap(nums,curr,right);
                right--;
            }
            else{
                curr++;
            }
        }
    }
    private void swap(int []nums,int idx,int idx2){
        int t=nums[idx];
        nums[idx]=nums[idx2];
        nums[idx2]=t;
    }
}
