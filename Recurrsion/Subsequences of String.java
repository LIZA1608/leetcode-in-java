/*https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087*/

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution {
    public static void solve(String s,ArrayList<String> ans,String out,int i){
     if(i>=s.length()){
		if(out.length()>0)
		ans.add(out);
		return;
	}
	String x=out+s.charAt(i++);
	solve(s,ans,out,i);
	solve(s,ans,x,i);
    }
    public static ArrayList<String> subsequences(String str) {
        // Write your code here

        ArrayList<String>ans=new ArrayList<>();
    String output="";
    int i=0;
    solve(str,ans,output,i);
    return ans;
    }
}
