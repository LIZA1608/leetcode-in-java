


class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
         PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
      for(int i=0;i<n;i++){
          pq.add(stones[i]);
      }  
      while(pq.size()>1){
          int a=pq.poll();
          int b=pq.poll();
          if(a==b){
              continue;
          }
          pq.add(a-b);
    }
    if(pq.size()==1){
           return pq.poll();
    }
    return 0;
}
}
