/*https://leetcode.com/problems/search-in-rotated-sorted-array/*/

import java.util.*;
public class Main {
    public static void main(String args[]) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int a[]=new int [n];
       for(int i=0;i<n;i++){
           a[i]=sc.nextInt();
       }
       int k=sc.nextInt();
       int x=-1;
       int l=0;
       int e=n-1;
       while(l<=e){
           int mid=l+(e-l)/2;
           if(a[mid]==k){
               x=mid;
           }
           if(a[l]<=a[mid]){
               if(k<=a[mid] && k>=a[l]){
                   e=mid-1;
               }
               else{
                   l=mid+1;
               }
           }
           else{
               if(k>=a[mid] && k<=a[e]){
                   l=mid+1;
               }
               else{
                   e=mid-1;
               }
           }
       }
       System.out.print(x);
    }
}
