/*https://hack.codingblocks.com/app/contests/4047/3904/problem*/

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res=0;
        long curr=0;
        for(int i=0,j=0;i<nums.length;i++){
            curr+=nums[i];
            while(curr*(i-j+1)>=k){
                curr-=nums[j++];
            }
                res+=i-j+1;

            
        }
        return res;
    }
}
