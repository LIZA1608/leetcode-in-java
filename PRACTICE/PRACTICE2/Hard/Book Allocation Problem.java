/*https://www.codingninjas.com/codestudio/problems/allocate-books_1090540?leftPanelTab=0*/

import java.util.* ;
import java.io.*; 
public class Solution {

    public static boolean isPossible(ArrayList<Integer>a,int n,int m,int mid){
        int stureq=1;
        int curr=0;
        for(int i=0;i<n;i++){
            if(a.get(i)>mid){
                return false;
            }
            if(curr+a.get(i)>mid){
                stureq++;
                curr=a.get(i);
                if(stureq>m){
                    return false;
                }
            }
            else{
                curr+=a.get(i);
            }
        }
        return true;
    }
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        if(n<m){
            return -1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr.get(i);
        }
        int left=0;
        int end=sum;
        int ans=Integer.MAX_VALUE;
        while(left<=end){
            int mid=left+(end-left)/2;
            if(isPossible(arr,n,m,mid)){
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}
