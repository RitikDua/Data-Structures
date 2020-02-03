import java.util.*;
public class classH{
	static class Node{
	int data;
	Node next;
	Node (){
	next=null;
	}
	Node(int data)
	{
		this.data=data;
	}
	}
	public static Node push(Node head,int data)
	{	if(head==null)
		{	Node q=new Node(data);
			q.next=head;
			head=q;
			return head;
		}
		Node q=new Node(data);
		q.next=head;
		return q;

	}
	public static Node pop(Node head)
	{	if(head==null) return null;
		System.out.println("Pop "+head.data);
		return head.next;
	}
	public static void print(Node head)
	{Node p=head;
		while(p!=null)
		{
			System.out.print(p.data+" ");
			p=p.next;}
	
	}
	public static void main(String[] args)
	{Scanner scan=new Scanner(System.in);
		Node head=null;//new Node();
		int x=scan.nextInt();
		while(x!=-1)
		{	if(x==1)
			head=push(head,scan.nextInt());
			else if(x==2)
			{head=pop(head);
			//	System.out.println("pop "+t);
			}
		//	System.out.println();
			x=scan.nextInt();
		}
		print(head);
	}
	


}
