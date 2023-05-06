#include <bits/stdc++.h>
using namespace std;

// Function to determine the optimal parenthesization of a product of n matrices
int matrixChainMultiplication(int dims[], int n) {
    // dp[i][j] stores the minimum number of scalar multiplications required to compute the matrix A[i]A[i+1]...A[j]
    int dp[n][n];

    // cost is zero when multiplying one matrix.
    for (int i = 1; i < n; i++) {
        dp[i][i] = 0;
    }

    // L is the chain length.
    for (int L = 2; L < n; L++) {
        for (int i = 1; i < n - L + 1; i++) {
            int j = i + L - 1;
            dp[i][j] = INT_MAX;
            for (int k = i; k <= j - 1; k++) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + dims[i-1]*dims[k]*dims[j]);
            }
        }
    }
    return dp[1][n-1];
}

// Main function
int main() {
    int n;
    cin >> n;

    int dims[n];
    for (int i = 0; i < n; i++) {
        cin >> dims[i];
    }

    int cost = matrixChainMultiplication(dims, n);
    cout << cost << endl;
    return 0;
}
