#include <iostream>
#include <cstring>
#include <climits>

using namespace std;

int main() {
    int n, w;
    cin >> n >> w;

    int val[w+1];
    for (int i = 1; i <= w; i++) {
        cin >> val[i];
    }

    int dp[w+1];
    memset(dp, -1, sizeof(dp));  // Initialize dp table to -1

    dp[0] = 0;  // Base case

    for (int i = 1; i <= w; i++) {
        for (int j = i; j <= w; j++) {
            if (val[i] != -1 && dp[j-i] != -1) {  // Check if i-kg packet is available and j-i kg of oranges can be bought
                if (dp[j] == -1 || dp[j] > dp[j-i] + val[i]) {  // Update dp table if it's the first valid option or the current option is cheaper
                    dp[j] = dp[j-i] + val[i];
                }
            }
        }
    }

    cout << dp[w] << endl;  // Print the minimum price to buy exactly w kg of oranges

    return 0;
}
