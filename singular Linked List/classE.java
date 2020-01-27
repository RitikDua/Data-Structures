import java.util.*;
import java.io.*;
public class classE{

	public static class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
		}
	}
	static Node deleteAtEnd(Node head){
	if(head.next==head) return null;
	Node p=head;
	Node x=head;
	while(p.next!=head)
		{x=p;p=p.next;}
	x.next=head;
	return head;
	
	}
	
	static Node deleteAtBeg(Node head){
	Node p=head.next,x=head;
	while(p!=head)
		{
			x=p;
			p=p.next;}
		x.next=head.next;
		return x.next;
	
	}
	static boolean 
	static void print(Node head)
	{
		Node p=head.next;
		System.out.print(head.data+" ");
		while(p!=head)
		{
			System.out.print(p.data+" ");
			p=p.next;
		}
		//System.out.print(p.data);
		
	
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
	static Node insertAtBeg(Node head,int data)
	{
		Node a=new Node(data);
		a.next=null;
		Node p=head;
		while(p.next!=head)
		p=p.next;
		p.next=a;
		a.next=head;
		return a;
	
	}
	
	static Node CinsertAtEnd(Node head,int data)
	{
		Node a=new Node(data);
		a.next=null;
		Node p=head;
		while(p.next!=head)
		p=p.next;
		p.next=a;
		a.next=head;
		return head;
	
	}
	static int loop(Node head)
	{
		Node s=head,f=head;
		while(true)
		{
			s=s.next;
			f=f.next.next;
			if(s==f)
			return 1;
		
		}
		return 0;
	
	}
public static void main(String[] args)
	{Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Node head=null;
		while(n-->0){
		head=insertAtEnd(head,scan.nextInt());
		
		}
			
		Node p=head;
		while(p.next!=null)
		p=p.next;
		p.next=head;
		
		
		System.out.println(loop(head));
		/*int t=scan.nextInt();
		//head=insertAtBeg(head,t);
		int t1=scan.nextInt();
		
		
		/*
		head=CinsertAtEnd(head,t1);
		
		print(head);
		System.out.println();
		head=deleteAtBeg(head);
		print(head);
		System.out.println();
		head=deleteAtEnd(head);
		*/
		print(head);
	}
}
