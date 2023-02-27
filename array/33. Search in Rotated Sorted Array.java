/*https://leetcode.com/problems/search-in-rotated-sorted-array/*/

class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int e=n-1;
        while(l<=e){
            int mid=(l+(e-l)/2);
            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]<=nums[mid]){
                if(target<=nums[mid] && target>=nums[l]){
                    e=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(target>=nums[mid] &&target<=nums[e]){
                    l=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }
}
