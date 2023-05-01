

class Solution {
    int i=0;
     int solve(Node root,int k){
        if(root==null){
            return -1;
        }
        int left=solve(root.left,k);
        if(left!=-1){
            return left;
        }
        i++;
        if(i==k){
            return root.data;
        }
        return solve(root.right,k);
    }
    int KthSmallestElement(Node root, int K) {
       
        int ans=solve(root,K);
        return ans;
    }
}
