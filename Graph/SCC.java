import java.util.*;
class Graph{
	public 	HashMap<Integer,ArrayList<Integer>> h=new HashMap<>();
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
			for(Integer p:h.get(src)){
				if(!visit[src])
					DFSutil(p,visit);
			}
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
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=9;
		Graph graph=new Graph();
		while(n!=-1)
		{
			int x=scan.nextInt(),y=scan.nextInt();
			if(x==-1||y==-1) break;
			graph.addEdge(x,y);
		}
		print(graph);
		print(transpose(graph));
	}
}
