/*https://leetcode.com/problems/count-number-of-nice-subarrays/description/*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
    int n=nums.length;
    for(int i=0;i<n;i++){
        if(nums[i]%2==0){
            nums[i]=0;
        }
        else{
            nums[i]=1;
        }
    }
    HashMap<Integer,Integer>map=new HashMap<>();
    int ans=0;
    int sum=0;
    map.put(0,1);
    for(int i=0;i<n;i++){
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
