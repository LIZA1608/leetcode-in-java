#include <bits/stdc++.h>
using namespace std;

int dp[2005][2005][6];

int main() {
    int n, m, k;
    cin >> n >> m >> k;

    int a[n], b[m];
    for(int i=0; i<n; i++)
        cin >> a[i];
    for(int i=0; i<m; i++)
        cin >> b[i];

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            for(int p=0; p<=k; p++) {
                dp[i][j][p] = max(dp[i-1][j][p], dp[i][j-1][p]);
                if(a[i-1] == b[j-1])
                    dp[i][j][p] = max(dp[i][j][p], dp[i-1][j-1][p] + 1);
                else if(p > 0)
                    dp[i][j][p] = max(dp[i][j][p], dp[i-1][j-1][p-1] + 1);
            }
        }
    }

    cout << dp[n][m][k] << endl;
    return 0;
}
