
import java.util.*;
public class Main{
    public class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;
    Scanner sc=new Scanner(System.in);
    Main(){
        this.root=createTree();
    }
   public Node createTree(){
      int x=sc.nextInt();
      Node n=new Node();
      n.data=x;
      if(sc.nextBoolean()){
        n.left=createTree();
      }
      if(sc.nextBoolean()){
        n.right=createTree();
      }
      return n;
    }
   
public void inorder(){
    inorder(this.root);
}
private void inorder(Node n){
    if(n==null){
        return;
    }
    inorder(n.left);
    System.out.println(n.data+" ");
    inorder(n.right);
}

public static void main(String[] args){
    Main t=new Main();
    t.inorder();
}
}
