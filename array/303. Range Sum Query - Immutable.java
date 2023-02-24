/*https://leetcode.com/problems/range-sum-query-immutable/*/

class NumArray {
int sum[];
    public NumArray(int[] nums) {
        sum=new int [nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=nums[i]+sum[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return sum[right+1]-sum[left];
    }
}
