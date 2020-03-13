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
  private static boolean isLeaf(Node x){
  return x.left==null&&x.right==null;
  }
  private static boolean isOneChild(Node x){
    return ((x.left==null&&x.right!=null)||(x.right==null&&x.left!=null));
  }
  private static Node delete(Node root,int data){

    if(root==null) return null;
    if(root.data>data) root.left=delete(root.left,data);
    else if(root.data<data) root.right= delete(root.right,data);
    else{
        if(isLeaf(root)) root=null;
        else if(isOneChild(root)){
            Node x=root;  
            if(root.right==null){
                  root=root.left;
              }
              else root=root.right;
        x=null;}
        else{
            Node x=search(root.right,data);
            root.data=x.data;
            root.right=delete(root.right,root.data);
        }

    
    }
  return root;
  }
  private static int size(Node root){
    if(root==null) return 0;
    if(isLeaf(root)) return 1;
    else return size(root.left)+1+size(root.right);
  }

  private static int maxDepth(Node root){
    if(root==null) return 0;
    else{
      int x=maxDepth(root.left);
      int y=maxDepth(root.right);
      return 1+(x>y?x:y);
    }
  }
  private static int maxVal(Node root){
  if(root==null) return -1;
  else if(root.right==null) return root.data;
  else if(isLeaf(root)) return root.data;
  else return maxVal(root.right);
  }
  private static int minVal(Node root){
  if(root==null) return -1;
  else if(root.left==null) return root.data;
  else if(isLeaf(root)) return root.data;
  else return minVal(root.left);
  }

  private static boolean hasPathSum(Node root,int sum){
    if(root==null&&sum!=0) return false;
    else if(sum==0&&root==null) return true;
    else if(sum==root.data&&isLeaf(root)) return true;
    else{
      boolean x=hasPathSum(root.left,sum-root.data);
      boolean y=hasPathSum(root.right,sum-root.data);
      return x||y;
    }
  }
  private static void print(int[] a,int x){
    int i=0;
    while(i<x) System.out.print(a[i++]+" ");
    //for(Integer x:a)System.out.print(x+" ");
    System.out.println();
  }
  private static void paths(Node root,int[] a,int index){
   // if(root==null){print(a,index);}
    if(root==null);
    else if(isLeaf(root)){a[index++]=root.data;print(a,index);}
    else{
      a[index++]=root.data;
      paths(root.left,a,index);
      paths(root.right,a,index);
    }
  }
  private static void PrintPaths(Node root){
      int[] a=new int[10000];
      paths(root,a,0);
  }
  public static void main(String[] args){

  Scanner scan=new Scanner(System.in);
  int n=scan.nextInt();
  Node root=null;
  root=new Node(scan.nextInt());
  while(n-->1)  root=insert(root,scan.nextInt());
  inorder(root);
  
  System.out.println("Enter choice\n1.to del\n2.size\n3.maxDepth\n4.min and max Value\n5 Root to leaf path\n6 Print Paths");
  int t=scan.nextInt();


  switch(t){
  case 1: 
          System.out.println("To delte");
          //System.out.println((search(root,3)).data);
          int data=scan.nextInt();
          if(lookup(root,data)){
           root=delete(root,data);
           inorder(root);
           //System.out.println(root.data);
          }
          else{
          System.out.printf("There is no %d to delete",data);}
        //  }
        break;
  case 2:
    //size
          System.out.println(size(root));
        break;
  case 3:
        //max Depth
        System.out.println(maxDepth(root));
        break;
  case 4:
        //min max
        System.out.println(minVal(root)+" "+maxVal(root));
        break;
  case 5:
        //root to leaf path of given sum
        System.out.println(""+hasPathSum(root,scan.nextInt()));
        
        break;
  case 6:
        PrintPaths(root);
        break;
  }




}


  }
