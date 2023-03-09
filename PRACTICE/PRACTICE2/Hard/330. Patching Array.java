/*https://leetcode.com/problems/patching-array/*/

class Solution {
    public int minPatches(int[] nums, int n) {
         int patches = 0;
    long range_sum = 0;
    int i = 0;
    while (range_sum < n) {
        if (i < nums.length && nums[i] <= range_sum + 1) {
            range_sum += nums[i];
            i++;
        } else {
            range_sum += range_sum + 1;
            patches++;
        }
    }
    return patches;
    }
}
