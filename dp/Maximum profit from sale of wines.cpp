

// Online C++ compiler to run C++ program online
#include <bits/stdc++.h>
using namespace std;
// int solve(int a[],int n,int s,int e, vector<vector<int>dp ){
//     if(s>e){
//         return 0;
//     }
//     if(s==e){
//       return a[s]*n-(e-s); 
//     }
//     int head=a[s]*(n-(e-s))+solve(a,n,s+1,e,dp);
//     int last=a[e]*(n-(e-s))+solve(a,n,s,e-1,dp);
//     return max(head,last);
    
// }
int main() {
   int n;
   cin>>n;
   int a[n];
   for(int i=0;i<n;i++){
       cin>>a[i];
   }
   vector<vector<int>> dp(n+1,vector<int>(n+1,0));
   for(int w=0;w<n;w++){
       dp[w][w]=a[w]*n;
   }
   for(int i=n-1;i>=0;i--){
        for(int j=0;j<n;j++){
            if(i==j){
                continue;
            }
            int front=a[i]*(n-(j-i))+dp[i+1][j];
            int back=a[j]*(n-(j-i))+dp[i][j-1];
            dp[i][j]=max(front,back);
        }
   }
   //int ans=solve(a,n,i,j,dp);
   //cout<<ans;
cout<<dp[0][n-1];
    return 0;
}
