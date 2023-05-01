#include <iostream>
#include <cstring>
using namespace std;

int lcs3(string s1, string s2, string s3, int n, int m, int o) {
    int dp[n+1][m+1][o+1];
    memset(dp, 0, sizeof(dp));
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            for(int k=1; k<=o; k++) {
                if(s1[i-1] == s2[j-1] && s1[i-1] == s3[k-1]) {
                    dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                }
                else {
                    dp[i][j][k] = max({dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1]});
                }
            }
        }
    }
    return dp[n][m][o];
}

int main() {
    string s1, s2, s3;
    cin >> s1 >> s2 >> s3;
    int n = s1.length();
    int m = s2.length();
    int o = s3.length();
    int len = lcs3(s1, s2, s3, n, m, o);
    cout << len << endl;
    return 0;
}
