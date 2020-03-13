import java.util.*;

public class BST{

  static class Node{
    int data;
    Node left,right;
    Node(int data){
    this.data=data;
    left=null;
    right=null;
    }
  }
  private static Node search(Node root,int data){
    if(root.data==data) {return root;}
   else if (data<root.data){
        if(root.left==null) return root;
        else return search(root.left,data);
    }
    else{
        if(root.right==null) return root;
        else return search(root.right,data);
    
    }
  
  
  }
  private static void inorder(Node root){
  if(root==null) return;
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }

  private static boolean lookup(Node root,int data){
    if(root==null) return false;
    if(root.data==data) return true;
    else if(root.data>data) return lookup(root.left,data);
    else return lookup(root.right,data);
  }
  private static Node insert(Node root,int data){
    Node x=search(root,data);
    Node y=new Node(data);
    if(data<x.data) x.left=y;
    else x.right=y;
    return root;
  }
  private static void delete(Node root,int data){
  }
  public static void main(String[] args){
  Scanner scan=new Scanner(System.in);
  int n=scan.nextInt();
  Node root=null;
  root=new Node(scan.nextInt());
  while(n-->1)  root=insert(root,scan.nextInt());
  inorder(root);
  System.out.println("To delte");
  int data=scan.nextInt();
  if(!lookup(root,data)){
    delete(root,data);
    inorder(root);
  }
  else{
  System.out.printf("There is no %d to delete",data);}
  }
}
