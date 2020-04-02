import java.util.*;
//AVL TREE
//balance is balance factor
//if bf is in order
// 2 1 perform rr rotation
// -2 -1 perform ll rotation
// -2 1 first perform rr rotation and then ll rotation
// 2 -1 first perform ll rotation and then rr rotation
public class Tree{
	static class Node{
		int data;
		int height;//height of a node (a new attribute ,other than used in BST)
		Node left,right;
		Node(int data){
			this.height=0;
			this.data=data;
			this.left=this.right=null;
		}
	
	}
	private static int height(Node x){
		if(x==null) return -1;
		return  x.height;//here x.height is used as during insertion we call height function recursively so it compute height at every hence we dont requre to reqrite the whole logic like this -----> //1+Math.max(height(x.left),height(x.right));
	}
	private static int bal(Node p)//balance Factor
	{
		if(p==null) return 0;
		return (height(p.left)-height(p.right));
	}
	private static Node ll(Node p){
		Node a=p.right;
		p.right=a.left;
		a.left=p;
		p.height=1+Math.max(height(p.left),height(p.right));
		a.height=1+Math.max(height(a.left),height(a.right));
		return a;
	}
	private static Node rr(Node p){
		Node a=p.left;
		p.left=a.right;
		a.right=p;
		p.height=1+Math.max(height(p.left),height(p.right));
		a.height=1+Math.max(height(a.left),height(a.right));
		return a;
	}
	private static Node insert(Node root,int data){
		Node p=new Node(data);
		p.height=0;
		if(root==null)	 return p;
		else if(root.data<data) root.right=insert(root.right,data);
		else if(root.data>data) root.left=insert(root.left,data);
		else  return root;
		root.height=1+Math.max(height(root.left),height(root.right));
		int bf=bal(root);
		if((root.right!=null) && (bf==-2 && bal(root.right)==-1)) //here ll rotation 
			return ll(root);
		else if((root.left!=null) && (bf==2 && bal(root.left)==1)) //here r  rotation 
			return rr(root);
		else if((root.left!=null) && (bf==2 && bal(root.left)==-1))//here ll first then rr
		{	root.left=rr(root.left);
			return ll(root);
			}
		else if((root.right!=null) && (bf==-2 && bal(root.right)==1)) //here rr first then ll
		{
			root.right=ll(root.right);
			return rr(root);
		}
		return root;
	}
        private static void levelOrderTraversal(Node p)
	    {
	    if(p==null) return;
		ArrayList<Integer> a=new ArrayList<>();
		Queue<Node> q=new LinkedList<Node>();
		q.add(p);q.add(null);
		while(!q.isEmpty()){
		p=q.poll();
			if(p==null&&!q.isEmpty()){
			q.add(null);
			a.forEach((x)->System.out.print(" "+x));
			a.clear();
			System.out.println();
			}
			else if(p!=null){
				a.add(p.data);
				if(p.left!=null) q.add(p.left);
				if(p.right!=null) q.add(p.right);
			}
		
		}
		a.forEach((x)->System.out.print(" "+x));
	    
	    }
	  
	private static void inorder(Node p){
	    if(p==null) return;
	    inorder(p.left);
	    System.out.println(""+p.data+" "+p.height);
	    inorder(p.right);
	    } 
 	private static int heightTree(Node root){
		if(root==null) return 0;
		else return 1+(int)Math.max(height(root.left),height(root.right));
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		Node root=null;
		int c=0;
		int n=scan.nextInt();
		while(n!=-1){ /// this -1 is only for to terminate input at any fixed value
			root=insert(root,n);
			c++;//to count nodes
			n=scan.nextInt();
		}
		System.out.println("INORDER: ");
		inorder(root);
		System.out.println("LEVEL ORDER TRAVERSAL");
		levelOrderTraversal(root);
		System.out.println("NODES: "+c+"  height: "+((Math.log10(c)/Math.log10(2))));
		System.out.println("Actual Height: "+heightTree(root));
	}



}
