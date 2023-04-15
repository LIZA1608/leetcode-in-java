#include <bits/stdc++.h>
using namespace std;
class Solution{
public:
string longest(vector<string>&words){
    unordered_set<string>wordSet;
    string result="";
    for(const string&word:words){
        if(word.length()==1 || wordSet.count(word.substr(0,word.length()-1))){
            if(word.length()>result.length()){
            result=word;
            }
            wordSet.insert(word);
        }
    }
    return result;
}
};
int main() {
   int n;
   cin>>n;
   cin.ignore();
   string input;
   getline(cin,input);
   istringstream iss(input);
   string word;
   vector<string>words;
while(iss>>word){
    words.push_back(word);
}
Solution sol;
string longest=sol.longest(words);
cout<<longest<<endl;
   return 0;

}
