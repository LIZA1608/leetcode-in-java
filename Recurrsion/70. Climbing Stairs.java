/*https://leetcode.com/problems/climbing-stairs/*/

// use recurrsion but all test case not passed

class Solution {
public:
    int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

};
