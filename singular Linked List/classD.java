import java.util.*;
import java.io.*;
public class classD{

	public static class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
		}
	}
	public static Node middle(Node head)
	{
	if(head==null) return head;
	
	Node s=head,f=head,y=head;
	while(f!=null&&f.next!=null)
	{	y=s;
		s=s.next;
		f=f.next.next;
	}
	Node x=y.next;
	Node org=y.next;
	y.next=null;
	System.out.println(y.data);
	//Node p=head;
	while(x.next!=null)
	x=x.next;
	
	x.next=head;	
	return org;
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
	
	public static void print(Node head)
	{
		while(head!=null){
		System.out.print(head.data+" ");
		head=head.next;}System.out.println();
	}
	
	
	public static Node insertAfter(Node head,int data,int value)
	{
		if(head==null) return insertAtEnd(head,data);
		if(head.next==null) return insertAtEnd(head,data);
		
		Node p=head;
		while(p!=null&&p.data!=value)
		p=p.next;
		if(p!=null){
		Node q=new Node(data);
		q.next=null;
		Node t=p.next;
		p.next=q;
		q.next=t;
		}
		return head;
	}
	public static Node rev(Node head)
	{
		Node current,next,prev;
		prev=null;
		current=head;
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
		return head;
	}
	public static Node middle1(Node head)
	{
	
	Node p=head,s=head,f=head,q=head;
	while(f!=null&&f.next!=null)
	{q=s;
		s=s.next;
		f=f.next.next;
	}
	Node m1=q.next;
	q.next=null;
	m1=rev(m1);
	Node m2=head;
	m2=rev(m2);
	p=m2;
	while(p.next!=null)
	p=p.next;
	p.next=m1;
	//print(m1);
	//print(m2);
	
	return m2;
	}
	public static Node insertBefore(Node head,int data,int value)
	{	if(head.data==value) { Node q=new Node(data);q.next=head; return q;}
		if(head==null) return insertAtEnd(head,data);
		if(head.next==null) return insertAtEnd(head,data);
		
		Node p=head;
		while(p.next!=null&&p.next.data!=value)
		p=p.next;
		if(p!=null){
		Node q=new Node(data);
		q.next=null;
		Node t=p.next;
		p.next=q;
		q.next=t;
		}
		return head;
	}
	
	public static Node insertAtMiddle(Node head,int data)
	{
		if(head==null) return insertAtEnd(head,data);
		if(head.next==null) return insertAtEnd(head,data);
		Node s=head,f=head;
		while(f!=null&&f.next!=null)
		{
			s=s.next;
			f=f.next.next;}
		Node q=new Node(data);
		Node m=s.next;
		s.next=q;
		q.next=m;
		return head;
	}
	public static Node sort(Node head)
	{	head=insertBeg(head,-1);
		head=insertAtEnd(head,-1);
		
		Node p=head,q,n1,min,n2,p1,p2,org=head;
		p1=head;p2=head;
		head=head.next;
		p=head;
		while(p.next!=null)
		{	n1=p.next;
			q=p.next;
			min=p;
			p2=p;
			n2=q.next;
			Node x=p;
			while(q.next!=null)
			{
				if(min.data>q.data)
				{
					min=q;p2=x;n2=q.next;}
				x=q;
				q=q.next;
			}
			if(min!=p)
			{
				Node a=p,b=min;
				p1.next=min;
				min.next=n1;
				
				p2.next=p;
				p.next=n2;
			
			}
			p=n1;
		
		}
		head=deleteBeg(org);
		head=deleteEnd(head);
		
			return head;
	}
	public static Node deleteBeg(Node head)
	{
	if(head==null) return null;
	if(head.next==null) return  null;
	
	return head.next;}

	public static Node fun(Node head,int k)
	{
		Node p=head,x,y=head,org=null,tail=null;
		int i=0;
		x=head;
		while(p!=null)
		{
	i++;	
		y=p;
			if(i==k)
			{p=p.next;
				y.next=null;
				
				x=rev(x);
				print(x);
			//	System.out.println("t : "+(t!=null?t.data:null));
			
				if(org==null) {org=x;}
				if(tail!=null) {tail.next=x;}
				System.out.println("A "+y.data+x.data+(tail!=null?tail.data:tail));
				
				while(x.next!=null)
					x=x.next;
				tail=x;
				x.next=p;
				x=p;
				i=0;
				y=p;
				
			//	p=(y)!=null?y.next:null;
				continue;
			}
			
			p=p.next;
			
		}
		return org;
	}
	public static Node deleteAtMiddle(Node head)
	{
	if(head==null) return null;
	if(head.next==null) return  null;
	Node s=head,f=head.next;

		while(f!=null&&f.next!=null)
		{
			s=s.next;
			f=f.next.next;}
	s.data=s.next.data;
	s.next=s.next.next;
	
	return head;
	}
	public static Node insertBeg(Node head,int data)
	{
	Node q=new Node(data);
	q.next=null;
	if(head==null) return q;
	q.next=head;
	return q;
	}
	public static Node  reverse(Node head)
	{
	Node org=null,p=head,q;
	while(p!=null)
	{
		int t=p.data;
		org=insertBeg(org,t);
	p=p.next;}
	return org;	
	}
	public  static Node deleteEnd(Node head)
	{
	if(head==null) return null;
	if(head.next==null) return  null;
	Node t=head;
	while(t.next.next!=null)
	t=t.next;
	t.next=null;
	return head;
	}
	public static void main(String[] args)
	{Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		Node head=null;
		while(n-->0){
		head=insertAtEnd(head,scan.nextInt());
		
		}
		
		print(head);
		
		/*System.out.println("Make a choice \n1)insert at middle\n2)insert before \n3)insert at after");
		int t=scan.nextInt();
		if(t==1)
		head=insertAtMiddle(head,scan.nextInt());
		else if(t==2)
		{int s=scan.nextInt();head=insertBefore(head,scan.nextInt(),s);}
		
		else if(t==3)
		{int s=scan.nextInt();head=insertAfter(head,scan.nextInt(),s);}-*/
		/*System.out.println("Make a choice \n1)delete at middle\n2)delete beg \n3)delete at end");
		
		int t=scan.nextInt();
		if(t==1)
		head=deleteAtMiddle(head);
		else if(t==2)
		{head=deleteBeg(head);}
		
		else if(t==3)
		{head=deleteEnd(head);}
		*/
	//	int d=scan.nextInt();
print(sort(head));
}	
}
