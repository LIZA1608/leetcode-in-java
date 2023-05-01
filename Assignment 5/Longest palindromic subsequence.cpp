#include <iostream>
#include <cstring>
using namespace std;

int longest_palindromic_subsequence(string s) {
    int n = s.length();
    int dp[n][n];
    
    // Subsequence of length 1 is always a palindrome
    for(int i=0; i<n; i++) {
        dp[i][i] = 1;
    }
    
    // Build the table in bottom-up manner
    for(int cl=2; cl<=n; cl++) {
        for(int i=0; i<n-cl+1; i++) {
            int j = i + cl - 1;
            if(s[i] == s[j] && cl == 2) {
                dp[i][j] = 2;
            } else if(s[i] == s[j]) {
                dp[i][j] = dp[i+1][j-1] + 2;
            } else {
                dp[i][j] = max(dp[i][j-1], dp[i+1][j]);
            }
        }
    }
    
    return dp[0][n-1];
}

int main() {
    string s;
    cin >> s;
    
    int ans = longest_palindromic_subsequence(s);
    cout << ans << endl;
    
    return 0;
}
