import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    public static void printRightView(TreeNode root) {
       if(root==null){
           return;
       }
       Queue<TreeNode>q=new LinkedList<>();
       q.add(root);
       int f=1;
       while(!q.isEmpty()){
           TreeNode front=q.poll();
           f--;
           if(front.left!=null){
               q.add(front.left);
           }
           if(front.right!=null){
               q.add(front.right);
           }
           if(f==0){
 System.out.print(front.val+" ");
 f=q.size();
           }
          
       }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] values = input.split(" ");
        TreeNode root = buildTree(values, 0);
        printRightView(root);
    }
}
