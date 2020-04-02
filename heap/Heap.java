//HEAP is typically an array representation of a complete binary tree.
//here parent is arr[(i-1)/2];
//left child of node is arr[(2*i)+1];
//right child of node is arr[(2*i)+2];
//It is of two types first is min and max.Here I will do max heap;
//Min heap is analogus to max heap
//There is also important property to consider that 
//try to heapify by following bottom to top Approach 
//Here is a formula that , to count leaf nodes to heapify i.e.
//number of leaf nodes = (floor(heap.lenght)+1)
//leaf nodes are already max/min heaps so we will work from bottom to top
import java.util.*;
public class Heap{
	static int length;
	private static void MaxHeapify(int[] a,int i){
		int l=2*i+1;//left child
		int r=2*i+2;//right child
		int max=0;
		if(l<length && a[l]>a[i]) 
			max=l;
		else    max=i;
		if(r<length && a[r]>a[max])
			max=r;
		if(max!=i){
			int t=a[i];
			a[i]=a[max];
			a[max]=t;
			MaxHeapify(a,max);}
	}
	private static int find(int[] a,int data){
		int i=0;
		try{
			while(a[i++]!=data);
		       	return i-1;	
		}
		catch(ArrayIndexOutOfBoundsException e){
			return -1;
		}
	}
	private static int[] delete(int[] a,int del){
		int index=find(a,del);
		if(index==-1) return a;
		a[index]=a[length-1];
		length=length-1;
		return buildMaxHeap(a);
	}
	private static int[] buildMaxHeap(int[] a){
		for(int i=length/2-1;i>=0;i--)
			MaxHeapify(a,i);
		return a;
	}
	public static void main(String[] args){
		int[] Heap;
		Scanner scan=new Scanner(System.in);
		length=scan.nextInt();//length of heap
		Heap=new int[length];
		int i=0;
		while(i<length) Heap[i++]=scan.nextInt(); 
		Heap=buildMaxHeap(Heap);
		for(i=0;i<length;i++)
			System.out.print(Heap[i]+" ");
		Heap=delete(Heap,scan.nextInt());
		for(i=0;i<length;i++)
			System.out.print(Heap[i]+" ");
	
	}


}

