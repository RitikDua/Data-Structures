import java.util.*;
public class Graph{
	private static void DFS(int src,HashMap<Integer,ArrayList<Integer>> h,boolean[] visit)
	{
		System.out.print(src+" ");
		visit[src]=true;
	//	System.out.print(src+" ");
		for(Integer p:h.get(src)){
			if(!visit[p])
			{
				visit[p]=true;
				DFS(p,h,visit);
			}
		}
	}
	private static void DFS(int src,HashMap<Integer,ArrayList<Integer>> h){
		boolean[] visit=new boolean[10000];
		visit[src]=true;
		Stack<Integer> st=new Stack<Integer>();
		st.push(src);
		while(!st.empty()){
			Integer p=st.pop();
			System.out.print(p+" ");
			visit[p]=true;
			for(Integer i:h.get(p))
			{
				if(!visit[i])
				{
					st.push(i);
			//		visit[i]=true;
				}
			}
		}
	}
	private static void BFS(int src,HashMap<Integer,ArrayList<Integer>> h,boolean[] visit){
	System.out.println();
		
	}
	private static void BFS(int src,HashMap<Integer,ArrayList<Integer>> h){
		boolean[] visit=new boolean[10000];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(src);
		visit[src]=true;
		System.out.print(src+" ");
		while(!q.isEmpty())
		{Integer p=q.remove();
			if(!visit[p])
				System.out.print(p+" ");
			visit[p]=true;
			
		
			for(Integer i:h.get(p)){
				if(!visit[i])
				{
				q.add(i);
				}
			}
		}
	}
	public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	int nQ;//no. of Edges
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<>();
//	nQ=scan.nextInt();
	while(true){
		int x=scan.nextInt(),y=scan.nextInt();
		if(x==-1||y==-1) break;
		if(h.containsKey(x)){
			ArrayList<Integer> l=h.get(x);
			l.add(y);
			h.put(x,l);
		}
		else{
			ArrayList<Integer> l=new ArrayList<Integer>();
			l.add(y);
			h.put(x,l);
		}
	}       

	        for (Map.Entry<Integer,ArrayList<Integer>> p: h.entrySet())
		{System.out.println();
			System.out.print("head: "+p.getKey()+" ");
			ArrayList<Integer> l=p.getValue();
			l.forEach((x)->System.out.print(x+" "));
		}
		System.out.println("BREAK");	
		int x=scan.nextInt();
		if(x==1)
		{DFS(1,h,new boolean[10000]);//for sake of simplicity take 1 as root
			System.out.println();
			DFS(1,h);
		}
		else if(x==2){
		BFS(1,h,new boolean[10000]);
			BFS(1,h);//new boolean[10000]);
		
		}
	}

}
