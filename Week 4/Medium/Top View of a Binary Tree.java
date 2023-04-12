import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public static TreeNode buildTree(String[] values, int index) {
        if (index >= values.length || values[index].equals("-1")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        root.left = buildTree(values, 2 * index + 1);
        root.right = buildTree(values, 2 * index + 2);
        return root;
    }

    public static void printTopView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(root);
        hdQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            int hd = hdQueue.poll();

            if (!map.containsKey(hd)) {
                map.put(hd, front.val);
            }

            if (front.left != null) {
                queue.add(front.left);
                hdQueue.add(hd - 1);
            }

            if (front.right != null) {
                queue.add(front.right);
                hdQueue.add(hd + 1);
            }
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] values = input.split(" ");
        TreeNode root = buildTree(values, 0);
        printTopView(root);
    }
}
