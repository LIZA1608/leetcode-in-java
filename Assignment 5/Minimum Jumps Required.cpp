#include<bits/stdc++.h>
using namespace std;
int main() {
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        int jumps = 0, current_end = 0, farthest_end = 0;
        for(int i = 0; i < n-1; i++) {
            farthest_end = max(farthest_end, i + arr[i]);
            if(i == current_end) {
                jumps++;
                current_end = farthest_end;
            }
        }
        if(current_end < n-1) {
            jumps = INT_MAX;
        }
        cout << jumps << endl;
    }
    return 0;
}

