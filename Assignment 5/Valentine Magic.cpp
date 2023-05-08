#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

const int MAXN = 5005;
const int INF = 1e9;

int dp[MAXN][MAXN];

int main() {
    int n, m;
    cin >> n >> m;

    int chocolates[n], candies[m];
    for (int i = 0; i < n; i++) {
        cin >> chocolates[i];
    }
    for (int i = 0; i < m; i++) {
        cin >> candies[i];
    }

    sort(chocolates, chocolates + n);
    sort(candies, candies + m);

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (i == 0) {
                dp[i][j] = 0;
            } else if (j == 0) {
                dp[i][j] = INF;
            } else {
                dp[i][j] = min(dp[i][j-1], abs(chocolates[i-1] - candies[j-1]) + dp[i-1][j-1]);
            }
        }
    }

    cout << dp[n][m] << endl;

    return 0;
}
