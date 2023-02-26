/*https://hack.codingblocks.com/app/contests/4047/3909/problem*/

class Solution {
    public int minMovesToMakePalindrome(String s) {
        int len = s.length();
int ans = 0;
for(int i=0; i<len/2; i++){
int j = s.length()-1;
int count = 0;
while(s.charAt(j) != s.charAt(0)){
j--;
count++;
}
if(j==0){
s = s.substring(1);
ans += (s.length()/2);
}
else{
s = s.substring(1, j)+s.substring(j+1);
ans += count;
}
}

    return ans;
    }
}
