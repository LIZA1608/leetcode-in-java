import java.util.*;
public class Main {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Main m = new Main();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderZigzag();
    }
    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }
        private Node root;
        private int size;
        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }
        public Node takeInput(Node parent, boolean ilc) {
            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;
            // left
            boolean hlc = scn.nextBoolean();
            if (hlc) {
                child.left = this.takeInput(child, true);
            }
            // right
            boolean hrc = scn.nextBoolean();
            if (hrc) {
                child.right = this.takeInput(child, false);
            }
            return child;
        }
        public void levelOrderZigzag() {
            if (root == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            boolean leftToRight = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelValues = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    levelValues.add(node.data);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                if (!leftToRight) {
                    Collections.reverse(levelValues);
                }
                for (int i = 0; i < levelValues.size(); i++) {
                    System.out.print(levelValues.get(i) + " ");
                }
                leftToRight = !leftToRight;
            }
        }
    }
}
