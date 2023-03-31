

#include <iostream>
#include <vector>
using namespace std;

bool isPalindrome(string str) {
    int n = str.length();
    for (int i = 0; i < n / 2; i++) {
        if (str[i] != str[n - i - 1])
            return false;
    }
    return true;
}

void partition(string s, vector<string>& temp, vector<vector<string>>& result) {
    if (s.length() == 0) {
        result.push_back(temp);
        return;
    }
    for (int i = 1; i <= s.length(); i++) {
        string prefix = s.substr(0, i);
        if (isPalindrome(prefix)) {
            temp.push_back(prefix);
            partition(s.substr(i), temp, result);
            temp.pop_back();
        }
    }
}

int main() {
    string s;
    cin >> s;
    vector<string> temp;
    vector<vector<string>> result;
    partition(s, temp, result);
    for (int i = 0; i < result.size(); i++) {
        for (int j = 0; j < result[i].size(); j++) {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
