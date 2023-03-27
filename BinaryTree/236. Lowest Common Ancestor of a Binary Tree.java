/*https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     if(root==null){
         return root;
     }   
     if(root.val==p.val || root.val==q.val){
         return root;
     }
     TreeNode leftpart=lowestCommonAncestor(root.left,p,q);
     TreeNode rightpart=lowestCommonAncestor(root.right,p,q);
     if(leftpart!=null && rightpart!=null ){
         return root;
     }
     if(leftpart==null || rightpart!=null){
         return rightpart;
     }
     if(leftpart!=null || rightpart==null){
         return leftpart;
     }
     return null;
    }
}
