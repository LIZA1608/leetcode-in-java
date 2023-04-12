import java.util.*;
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BST {
    Node root;

    public BST() {
        root = null;
    }

    // Method to insert a node in BST
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    // Method to find the Lowest Common Ancestor (LCA) of two elements in BST
    public Node findLCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        if (n1 < node.data && n2 < node.data) {
            return findLCA(node.left, n1, n2);
        } else if (n1 > node.data && n2 > node.data) {
            return findLCA(node.right, n1, n2);
        }

        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Input the number of nodes in BST
        int n;
        Scanner scanner = new Scanner(System.in);
    
        n = scanner.nextInt();

        // Input the nodes of BST
      
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            bst.root = bst.insert(bst.root, data);
        }

        // Input the two numbers whose LCA is to be found
  
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        // Find the LCA of two numbers in BST
        Node lca = bst.findLCA(bst.root, n1, n2);

        // Display the LCA value
        System.out.println( lca.data);
    }
}
