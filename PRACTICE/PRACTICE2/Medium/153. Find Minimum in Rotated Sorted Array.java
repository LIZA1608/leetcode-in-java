/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/*/

class Solution {
    public int findMin(int[]a) {
        int n=a.length;
        int l=0;
        int e=n-1;
        while(l<e){
            int mid=l+(e-l)/2;
            if(a[l]<a[e]){
                return a[l];
            }
            if(a[mid]>=a[l]){
                l=mid+1;
            }
            else{
                e=mid;
            }
        }
        return a[l];
    }
}
