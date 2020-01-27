import java.util.*;
public class classC{

	public static class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
		}
	}
	public static Node insertAtEnd(Node head,int data)
	{	
		Node q=new Node(data);
		
		q.next=null;
		if(head==null) return q; 
		Node p=head;
		while(p.next!=null)
		p=p.next;
		p.next=q;
		return head;
	}
	
	
	public static Node insertAtBegin(Node head,int data)
	{	
		Node q=new Node(data);
		
		q.next=null;
		if(head==null) return q; 
		q.next=head;
		return q;
	}
	public static void print(Node head)
	{
		while(head!=null){
		System.out.print(head.data+" ");
		head=head.next;}System.out.println();
	}		
	public static void main(String[] args)
	{Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Node head=null;
		while(n-->0){
		head=insertAtBegin(head,scan.nextInt());
		
		}
		print(head);
	}
}
