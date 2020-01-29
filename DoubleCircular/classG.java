import java.util.*;
public class classG{
	static class Node{
	Node prev;
	Node next;
	int data;
		Node(int data){
		
		this.data=data;}
	}
	
	public static Node insertAtEnd(Node head,int data)
	{	
	
		Node q=new Node(data);
		q.prev=null;
		q.next=null;
		if(head==null) {q.prev=q;q.next=q;return q;}
		Node t=head.prev;
		head.prev=q;
		q.prev=t;
		t.next=q;
		q.next=head;
	//System.out.print(q.data);
		return head;
	
	
	}
	
	public static Node insertAtBeg(Node head,int data)
	{	
	
		Node q=new Node(data);
		q.prev=null;
		q.next=null;
		if(head==null) {q.prev=q;q.next=q;return q;}
		Node t=head.prev;
		t.next=q;
		q.prev=t;
		q.next=head;
		head.prev=q;
	//System.out.print(q.data);
		return q;
	
	
	}
	
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
	
	public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Node head=null;
		while(n-->0){
		head=insertAtBeg(head,scan.nextInt());
		//
		}
			
		
	print(head);/*
	int t=scan.nextInt();
	if(t==1)
		head=CinsertAtBeg(head,scan.nextInt());
	
	if(t==2)
		head=CinsertAtEnd(head,scan.nextInt());
	print(head);*/
	
	}

}
