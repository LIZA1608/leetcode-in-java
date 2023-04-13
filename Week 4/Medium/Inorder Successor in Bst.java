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
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            // Case 1: Node p has a right child
            // The inorder successor is the leftmost node in p's right subtree
            TreeNode current = p.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            // Case 2: Node p does not have a right child
            // The inorder successor is the first ancestor whose left child is also an ancestor of p
            TreeNode successor = null;
            TreeNode ancestor = root;
            while (ancestor != null && ancestor.val != p.val) {
                if (p.val < ancestor.val) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
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
		else {
            System.out.println("null");
        }
        sc.close();
    }
}
