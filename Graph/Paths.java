import java.util.*;

public class Paths{
	static void bfsPath(HashMap<Integer,ArrayList<Integer>> h,int src,HashMap<Integer,Integer> dist){
		int max=Integer.MAX_VALUE;
		for(Map.Entry<Integer,ArrayList<Integer>> p:h.entrySet())
			dist.put(p.getKey(),max);
		System.out.println(dist);
		System.out.println(h);
		Queue<Integer> q=new LinkedList<>();
		q.add(src);
		dist.put(src,0);
		while(!q.isEmpty())
		{
			Integer u=q.remove();
			for(Integer i:h.get(u))
			{
				if(dist.get(i)==max){
				System.out.println(i);
					q.add(i);
					dist.put(i,dist.get(u)+1);
				}
			}
		}
	}
	static void dijkstra(HashMap<Integer,ArrayList<Integer>> h,HashMap<String,Integer> weights,HashMap<Integer,Integer> dist,int src)
	{
		int max=Integer.MAX_VALUE;
		LinkedList<Integer> q=new LinkedList<>();//Treat as Queue
		//add(src);
	
		for(Map.Entry<Integer,ArrayList<Integer>> m:h.entrySet())
		{dist.put(m.getKey(),max);q.add(m.getKey());}
		dist.put(src,0);

		while(!q.isEmpty())
		{
			int min=Collections.min(q);
			int u=q.remove(q.indexOf(min));
			for(Integer p:h.get(u))
			{
				if(dist.get(p)>dist.get(u)+weights.get(""+u+" "+p)){
					dist.put(p,dist.get(u)+weights.get(""+u+" "+p));

				}	
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		HashMap<Integer,ArrayList<Integer>> h=new HashMap<>();
		HashMap<String,Integer> weights=new HashMap<>();
		while(true)
		{
			int x=scan.nextInt(),y=scan.nextInt();
			if(x==-1||y==-1)
				break;
			if(h.containsKey(x))
			{
				ArrayList<Integer> l=h.get(x);
				l.add(y);h.put(x,l);
			}
			else{
				ArrayList<Integer> l=new ArrayList<>();
				l.add(y);
				h.put(x,l);
			}

			int z=scan.nextInt();
			String key=x+" "+y;
			weights.put(key,z);
		}
		int src=scan.nextInt();//src from were to path is need to be measure
		HashMap<Integer,Integer> dist=new HashMap<>();
		dijkstra(h,weights,dist,src);
	//	bfsPath(h,src,dist);
		int dest=scan.nextInt();//to where dist needs to be measured
		System.out.println(dist);


	}
}
