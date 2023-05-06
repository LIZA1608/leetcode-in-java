#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    int prices[n];
    for(int i=0; i<n; i++){
        cin >> prices[i];
    }
    int rodLength;
    cin >> rodLength;

    int dp[rodLength+1] = {0}; // Initialize all elements of dp to 0
    for(int i=1; i<=rodLength; i++){
        for(int j=0; j<i; j++){
            dp[i] = max(dp[i], prices[j] + dp[i-j-1]);
        }
    }
    cout << dp[rodLength] << endl;

    return 0;
}
