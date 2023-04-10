import java.util.*;
public class Main {
    public static void main (String args[]) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int stones[]=new int [n];
         for(int i=0;i<n;i++){
             stones[i]=sc.nextInt();
         }
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
           System.out.print(pq.poll());
    }
    }
}
