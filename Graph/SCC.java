import java.util.*;
class Graph{
	HashMap<Integer,ArrayList<Integer>> h=new HashMap<>();
	void addEdge(int src,int dest){
		ArrayList<Integer> l;
		if(h.containsKey(src)){
		l=h.get(src);
		l.add(dest);
		h.put(src,l);
		}
		else{
		l=new ArrayList<Integer>();
		l.add(dest);
		h.put(src,l);
		}	
	}
	void DFSutil(int src,boolean visit[])
	{
			visit[src]=true;
			System.out.print(src+" ");
			for(Integer p:h.get(src)){
				if(!visit[p])
					DFSutil(p,visit);
			}
	}
	void DFSutil(int src,boolean visit[],Stack<Integer> st)
	{ 
			visit[src]=true;
	if(h.get(src)!=null){ 		
			//	System.out.print(src+" ");
			for(Integer p:h.get(src)){
				if(!visit[p])
					DFSutil(p,visit,st);
			}
	}
		st.push(src);
	}



}
public class SCC{
	static int V;
	private static Graph transpose(Graph g)
	{	Graph gp=new Graph();
		for(Map.Entry<Integer,ArrayList<Integer>> p:g.h.entrySet())	{
			int key=p.getKey();
			for(Integer i: p.getValue())
				gp.addEdge(i,key);
			
		}
		return gp;
	}
	private static void print(Graph g){
		for(Map.Entry<Integer,ArrayList<Integer>> m : g.h.entrySet()){
			System.out.println();
			System.out.print("head: "+m.getKey()+" ");
			m.getValue().forEach((x)->System.out.print(x+" "));
		}
	}
	/***Useful in Undirected GRAPHS***/
	private static void connectedComponents(Graph g)
	{
		boolean[] visit=new boolean[999983];
		for(Map.Entry<Integer,ArrayList<Integer>> p:g.h.entrySet()){
			if(!visit[p.getKey()])
			{
				g.DFSutil(p.getKey(),visit);
				System.out.println();
			}
		}
	}
	/***Useful in Directed graphs ***/
	private static void printSCC(Graph g)
	{
		Stack<Integer> St=new Stack<Integer>();
		boolean[] visit=new boolean[999983];

		for(Map.Entry<Integer,ArrayList<Integer>> p:g.h.entrySet())
			if(!visit[p.getKey()])
				g.DFSutil(p.getKey(),visit,St);
		Graph gr=transpose(g);
		visit=new boolean[999983];
		while(!St.empty())
		{
			int v=(int)St.pop();
	//			System.out.println("{"+v+"}");
				
			if(!visit[v])
			{
			gr.DFSutil(v,visit);
				System.out.println();
			}
		}
	print(gr);
	}	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=999983;
		Graph graph=new Graph();
		while(n!=-1)
		{
			int x=scan.nextInt(),y=scan.nextInt();
			if(x==-1||y==-1) break;
			graph.addEdge(x,y);
		}
		print(graph);
		//graph.DFSutil(0,new boolean[10000]);
	//	System.out.println("Transpose");
	//	print(transpose(graph));
		int choice=scan.nextInt();//1 for undirected else 0
		if(choice==1)
			connectedComponents(graph);
		else
			printSCC(graph);
	
	}
}
