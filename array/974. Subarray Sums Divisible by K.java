/*https://leetcode.com/problems/subarray-sums-divisible-by-k/*/

class Solution {
    public int subarraysDivByK(int[] A, int K) {
       int count = 0;
        Map<Integer, Integer> rToFreq = new HashMap<>();
            int accSum = 0;
        for (int num : A) { 
            accSum += num;
            while (accSum < 0) {
                accSum += K;
            }
            
            int r = (accSum % K + K) % K;
            rToFreq.put(r, rToFreq.getOrDefault(r, 0) + 1);
        }
        
        for (int freq : rToFreq.values()) {
            if (freq > 1) {
                count += freq * (freq - 1) / 2;
            }
        }
         count += rToFreq.getOrDefault(0, 0);
        return count;  
    }
}
