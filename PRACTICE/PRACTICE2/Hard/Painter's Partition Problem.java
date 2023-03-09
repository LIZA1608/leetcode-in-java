/*https://www.codingninjas.com/codestudio/problems/painter-s-partition-problem_1089557*/

import java.util.ArrayList;

public class Solution 
{ 
    public static boolean isPossible(ArrayList<Integer>a,int n,int m,int mid){
        int paintercount=1;
        int boardcount=0;
        for(int i=0;i<n;i++){
            if(boardcount+a.get(i)<=mid){
                boardcount+=a.get(i);
            }
            else{
                paintercount++;
                if(paintercount>m || a.get(i)>mid){
                    return false;
                }
                boardcount=a.get(i);
            }
        }
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
       int total=0;
       int n=boards.size();
       for(int i=0;i<n;i++){
           total+=boards.get(i);
       }
       int start=0;
       int end=total;
       int ans=-1;
       int mid=start+(end-start)/2;
       while(start<=end){
           for(int i=0;i<n;i++){
               if(isPossible(boards,n,k,mid)){
                   ans=mid;
                   end=mid-1;
               }
               else{
                   start=mid+1;
               }
               mid=start+(end-start)/2;
           }
       }
       return ans;
    }

}
