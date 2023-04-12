import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(pre, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree(int[] pre, int[] in) {
			this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		}

         private int search(int[] in,int x,int y,int c ){
  for(int i=x;i<=y;i++){
      if(in[i]==c){
          return i;
      }
  }
  return -1;
    }

		private Node construct(int[] post, int a, int b, int[] in, int x, int y) {
if(a>b || x>y){
            return null;
        }
         Node n = new Node();
    n.data = post[b];
        int z=search(in,x,y,post[b]);
        n.left=construct(post,a,a+z-x-1,in,x,z-1);
        n.right=construct(post,a+z-x,b-1,in,z+1,y);
        return n;
			// write your code here
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}

}
