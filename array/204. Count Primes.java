/*https://leetcode.com/problems/count-primes/*/

class Solution {
       static boolean isPrime(int n){
    if (n <= 1)
        return false;
    for (int i = 2; i < n; i++)
        if (n % i == 0)
            return false;
    return true;
}
    public int countPrimes(int n) {
        int c=0;
        for(int i=2;i<n;i++){
           if(isPrime(i)){
               c++;
           }
        }
        return c;
    }
}
