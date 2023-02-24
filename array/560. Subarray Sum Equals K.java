/*https://leetcode.com/problems/subarray-sum-equals-k/*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sum=0;
         map.put(0,1);
        for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           int find=sum-k;
           if(map.containsKey(find)==true){
              ans+=map.get(find);
           }
           if(map.containsKey(sum)==true){
               map.put(sum,map.get(sum)+1);
           }
           else{
                map.put(sum,1);
           }
        }
        return ans;

    }
}
