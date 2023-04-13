import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root)[2];
    }

    // Helper method to calculate sum, min, and max for each sub-tree rooted at a node
    private static int[] helper(TreeNode node) {
        if (node == null) {
            // Base case: empty node has sum 0 and is considered BST
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        // Recursively calculate sum, min, and max for left and right subtrees
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        if (node.val > left[1] && node.val < right[0]) {
            // If the node is BST, update the sum, min, and max
            int sum = node.val + left[2] + right[2];
            int min = Math.min(node.val, left[0]);
            int max = Math.max(node.val, right[1]);
            return new int[]{min, max, sum};
        } else {
            // If the node is not BST, return invalid values
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Test with an example binary tree
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] values = input.split(" ");
        int[] levelOrder = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            levelOrder[i] = Integer.parseInt(values[i]);
        }
        TreeNode root = buildTreeFromLevelOrder(levelOrder);
        int maxSum = maxSumBST(root);
        System.out.println(maxSum);
    }

    // Helper method to build a binary tree from level order traversal array
    private static TreeNode buildTreeFromLevelOrder(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder[0]);
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode node = queue.poll();
            if (levelOrder[i] != -1) {
                node.left = new TreeNode(levelOrder[i]);
                queue.add(node.left);
            }
            i++;
            if (i < levelOrder.length && levelOrder[i] != -1) {
                node.right = new TreeNode(levelOrder[i]);
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }
}
