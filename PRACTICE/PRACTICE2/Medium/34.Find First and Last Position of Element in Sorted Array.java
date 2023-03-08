/*https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
    int res[]=new int [2];
    res[0]=binary(nums,target,true);
    res[1]=binary(nums,target,false);
    return res;
    }

public int binary(int []a,int target,boolean isFind){
     int n=a.length;
     int l=0;
     int e=n-1;
     int ans=-1;
     while(l<=e){
         int mid=l+(e-l)/2;
         if(a[mid]==target){
             ans=mid;
           if(isFind){
               e=mid-1;
           }
           else{
               l=mid+1;
           }
         }
         else if(a[mid]<target){
             l=mid+1;
         }
         else{
             e=mid-1;
         }
     }
     return ans;   
    }
}
