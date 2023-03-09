/*The coding blocks members went to the success party of their first ever online boot-camp at Murthal. 
They ordered P number of paranthas. The stall has L cooks and each cook has a rank R.
A cook with a rank R can cook 1 parantha in the first R minutes 1 more parantha in the next 2R minutes, 
1 more parantha in 3R minutes and so on(he can only cook a complete parantha) ( For example if a cook is ranked 2.. 
he will cook one parantha in 2 minutes one more parantha in the next 4 mins and one more in the next 6 minutes 
hence in total 12 minutes he cooks 3 paranthas. In 13 minutes also he can cook only 3 paranthas as he does not have enough time for the 4th parantha). 
Calculate the minimum time needed to cook all the paranthas.

Input Format
First line contains P, the number of pratha ordered. 
In the next line the first integer denotes the number of cooks L and L integers follow in the Next line each denoting the rank of a cook*/


import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int l=sc.nextInt();
        int cook[]=new int [l];
        for(int i=0;i<l;i++){
            cook[i]=sc.nextInt();
        }
        int left=0;
        int right=Integer.MAX_VALUE;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int i=0;i<l;i++){
int time=0;
int rank=cook[i];
int j=1;
while(time<=mid){
    time+=rank*j;
    if(time<=mid){
        count++;
        j++;
    }
}
            }
            if(count>=p){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.print(ans);
    }
}
