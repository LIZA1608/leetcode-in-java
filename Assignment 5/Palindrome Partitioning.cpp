#include <iostream>
#include <cstring>
using namespace std;

const int MAX = 1000;

// dp[i][j] stores whether substring from index i to j is palindrome or not
bool dp[MAX][MAX];

// Function to find minimum number of partitions required to make a string palindrome
int minPartitions(string str) {
    int n = str.length();
    memset(dp, false, sizeof(dp));
    
    // Single character substrings are always palindrome
    for (int i = 0; i < n; i++) {
        dp[i][i] = true;
    }
    
    // Check for substrings of length 2 and greater
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i < n - len + 1; i++) {
            int j = i + len - 1;
            
            // If the substring has only 2 characters, check if they are equal
            if (len == 2) {
                dp[i][j] = (str[i] == str[j]);
            }
            // If the substring has more than 2 characters, check if the first and last characters are equal
            // and if the substring between them is also palindrome
            else {
                dp[i][j] = (str[i] == str[j]) && dp[i+1][j-1];
            }
        }
    }
    
    // minPartitions[i] stores minimum number of partitions required to make substring from index i to n-1 palindrome
    int minPartitions[n];
    
    for (int i = n-1; i >= 0; i--) {
        // If the substring from i to n-1 is already palindrome, no partitions are required
        if (dp[i][n-1]) {
            minPartitions[i] = 0;
        }
        else {
            // Initialize minPartitions[i] with maximum possible value
            minPartitions[i] = MAX;
            // Try all possible partition points and choose the one with minimum partitions
            for (int j = i; j < n-1; j++) {
                if (dp[i][j]) {
                    minPartitions[i] = min(minPartitions[i], 1 + minPartitions[j+1]);
                }
            }
        }
    }
    
    // Return the minimum partitions required to make the entire string palindrome
    return minPartitions[0];
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        string str;
        cin >> str;
        cout << minPartitions(str) << endl;
    }
    return 0;
}
