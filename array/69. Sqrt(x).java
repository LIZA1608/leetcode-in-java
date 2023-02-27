/*https://leetcode.com/problems/sqrtx/*/

class Solution {
    public int mySqrt(int x) {
        int  l=1;
        int e=x;
        int mid=0;
        while(l<=e){
             mid=l+(e-l)/2;
            if(x/mid==mid){
                return mid;
            }
            else if(mid>x/mid){
                e=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return e;
    }
}
