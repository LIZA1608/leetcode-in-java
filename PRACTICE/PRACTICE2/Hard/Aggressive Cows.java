/*https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?leftPanelTab=0*/


import java.util.*;
public class Solution {
   public static boolean ispossible(int []a,int n,int k,int mid){
        int cowcount=1;
        int lastpos=a[0];
        for(int i=1;i<n;i++){
            if(a[i]-lastpos>=mid){
                cowcount++;
                if(cowcount==k){
                    return true;
                }
                lastpos=a[i];
            }
        }
        return false;
    }
    public static int aggressiveCows(int []talls, int k) {
        //    Write your code here.
        Arrays.sort(talls);
        int n=talls.length;
    int maxi=-1;
    for(int i=0;i<n;i++){
        maxi=Math.max(maxi,talls[i]);
    }
        int start=0;
        int end=maxi;
        int ans=1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(talls,n,k,mid)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}
