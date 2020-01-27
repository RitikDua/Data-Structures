import java.util.*;
public class classF{
	static class Node{
	int data;
	Node next;
	Node prev;
	public Node (int data){
	this.data=data;
	}
	}
	public static Node insertBefore(Node head,int data,int value)
	{	if(head==null) return null;
		
		Node p=head,q=new Node(value);
		q.prev=null;
		q.next=null;
		if(head.data==data) return insertAtBeg(head,value);
		while(p!=null&&p.data!=data) p=p.next;
		Node t=p;
		p.prev.next=q;
		q.prev=p.prev;
		q.next=p;
		p.prev=q;
		return head;
	}
	public static Node insertAfter(Node head,int data,int value)
	{
		if(head==null) return null;
		Node p=head,q=new Node(value);
		q.prev=null;
		q.next=null;
		while(p!=null&&p.data!=data) p=p.next;
		if(p.next==null) return insertAtEnd(head,value);
		p.next=q;
		q.next=p.next.next;
		q.prev=p;
		p.next.next.prev=q;
		return head;
	}
	public static Node insertAtPos(Node head,int pos,int data){
		if(head==null) return null;
		if(pos==1) return insertAtBeg(head,data);
		Node p=head;
		Node q=new Node(data);
		q.prev=null;
		q.next=null;
		int i=0;
		pos--;
		while(p!=null&&i++!=pos) p=p.next;
		
		if(p==null) return insertAtEnd(head,data);
		p.prev.next=q;
		q.prev=p.prev;
		q.next=p;
		p.prev=q;
		return head;
	}


	public static Node insertAtEnd(Node head,int data){
	Node q=new Node(data);
	q.prev=null;
	q.next=null;
	if(head==null) return q;
	Node p=head;
	while(p.next!=null) p=p.next;
	p.next=q;
	q.prev=p;
	return head;
	}
	
	public static Node insertAtBeg(Node head,int data){
	Node q=new Node(data);
	q.prev=null;
	q.next=null;
	if(head==null) return q;
	Node p=head;
	q.next=p;
	p.prev=q;
	return q;
	}
	public static  void print(Node head){
	Node p=head;
	while(p!=null)
	{
	System.out.print(p.data+" ");
	p=p.next;
	}
	}
	public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	Node head=null;
	
	int choice=scan.nextInt();
	if(choice!=1){
	int n=scan.nextInt();
	while(n-->0)
	head=insertAtBeg(head,scan.nextInt());
	}
	else{
	int n=scan.nextInt();
	while(n-->0)
	head=insertAtEnd(head,scan.nextInt());
	}
	int t=scan.nextInt();
	if(t==1)
	head=insertBefore(head,scan.nextInt(),scan.nextInt());
	else if(t==2)
	head=insertAfter(head,scan.nextInt(),scan.nextInt());
	else
		head=insertAtPos(head,scan.nextInt(),scan.nextInt());
	print(head);
	
	}
	
	

}
