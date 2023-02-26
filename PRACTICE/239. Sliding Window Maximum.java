/*https://leetcode.com/problems/sliding-window-maximum/description/*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
   
        int sizeOfArray = nums.length;
        int[] result = new int[sizeOfArray - k + 1];
        int Index = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for(int i=0; i<sizeOfArray; i++){
            if(!window.isEmpty() && window.peek() == i-k){
                window.poll();
            }
            while(!window.isEmpty() && nums[window.peekLast()] < nums[i]){
                window.pollLast();
            }     
            window.add(i);
            if(i >= k - 1){
                result[Index++] = nums[window.peek()];
            }
        }
        return result;
}
}
