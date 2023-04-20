/*https://leetcode.com/problems/path-sum/*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
     if(root==null){
         return false;
     }   
          if(root.left==null && root.right==null){
           return  targetSum==root.val;          
            }
          boolean x=hasPathSum(root.left,targetSum-root.val);
          boolean y=hasPathSum(root.right,targetSum-root.val);
          return (x||y);
    }
}
