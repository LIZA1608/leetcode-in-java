#include <bits/stdc++.h>
using namespace std;
int main() {
    int n, s;
    cin >> n >> s;

    vector<int> size(n+1), value(n+1);
    for (int i = 1; i <= n; i++) {
        cin >> size[i];
    }
    for (int i = 1; i <= n; i++) {
        cin >> value[i];
    }

    vector<vector<int>> dp(n+1, vector<int>(s+1, 0));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= s; j++) {
            if (j >= size[i]) {
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-size[i]] + value[i]);
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    cout << dp[n][s] << endl;

    return 0;
}
