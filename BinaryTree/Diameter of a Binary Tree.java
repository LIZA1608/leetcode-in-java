/*https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1*/

class Solution {
    // Function to return the diameter of a Binary Tree.
    int res=0;
    int height(Node root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int r=height(root.right);
        int temp=Math.max(l,r)+1;
        res=Math.max(res,1+l+r);
        return temp;
    }
    int diameter(Node root) {
        // Your code here
        height(root);
        return res;
    }
}
