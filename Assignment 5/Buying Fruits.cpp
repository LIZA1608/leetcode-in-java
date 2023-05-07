
#include <iostream>
#include <climits>
using namespace std;

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        int arr[n][3]; // 2D array to store the cost of each fruit at each shop
        for (int i = 0; i < n; i++) {
            cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
        }

        int dp[n][3]; // 2D array to store the minimum cost of buying fruit up to each shop
        dp[0][0] = arr[0][0]; // buying apples from first shop
        dp[0][1] = arr[0][1]; // buying mangoes from first shop
        dp[0][2] = arr[0][2]; // buying oranges from first shop

        for (int i = 1; i < n; i++) {
            // buying apples from current shop, so cannot buy from previous shop
            dp[i][0] = arr[i][0] + min(dp[i-1][1], dp[i-1][2]);

            // buying mangoes from current shop, so cannot buy from previous shop
            dp[i][1] = arr[i][1] + min(dp[i-1][0], dp[i-1][2]);

            // buying oranges from current shop, so cannot buy from previous shop
            dp[i][2] = arr[i][2] + min(dp[i-1][0], dp[i-1][1]);
        }

        // minimum cost of buying fruit after visiting all shops
        int ans = min(dp[n-1][0], min(dp[n-1][1], dp[n-1][2]));
        cout << ans << endl;
    }

    return 0;
}
