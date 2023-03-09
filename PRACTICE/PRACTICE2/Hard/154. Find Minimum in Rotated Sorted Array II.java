/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/*/

class Solution {
    public int findMin(int[] a) {
        int n=a.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]>a[right]){
                left=mid+1;
            }
            else if(a[mid]<a[right]){
                right=mid;
            }
            else{
                right--;
            }
        }
        return a[left];
    }
}
