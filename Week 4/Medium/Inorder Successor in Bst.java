import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Main {
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    public static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return find(root.left, val);
        } else {
            return find(root.right, val);
        }
    }
    
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return root;
        }
        TreeNode temp=root;
        TreeNode suc=new TreeNode(-1);
        while(temp!=null){
            if(temp.val>p.val){
                suc=temp;
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }
        }
        return suc;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            root = insert(root, arr[i]);
        }
        int p = sc.nextInt();
        TreeNode node = find(root, p);
        TreeNode successor = inorderSuccessor(root, node);
        if (successor != null) {
            System.out.println( successor.val);
        } 
        sc.close();
    }
}
