import java.util.*;
public class Main {
    public static int solve(int sum,int []a,int idx,int [][]dp){
        if(idx>=a.length){
            return 0;
        }
        if(sum==0){
            return 1;
        }
        if(dp[sum][idx]!=-1){
            return dp[sum][idx];
        }
        int inc=0;
        if(sum>=a[idx]){
            inc=solve(sum-a[idx],a,idx,dp);
        }
        int exc=solve(sum,a,idx+1,dp);
        dp[sum][idx]=inc+exc;
        return dp[sum][idx];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      int sum=sc.nextInt();
      int n=sc.nextInt();
      int []a=new int [n];
      for(int i=0;i<n;i++){
          a[i]=sc.nextInt();
      }
      int [][]dp=new int [sum+1][n];
      for(int []x:dp){
          Arrays.fill(x,-1);
      }
      int ans=solve(sum,a,0,dp);
      System.out.print(ans);
    }
}
