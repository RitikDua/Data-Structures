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
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		HashMap<Integer,ArrayList<Integer>> h=new HashMap<>();

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
		}
		int src=scan.nextInt();//src from were to path is need to be measure
		HashMap<Integer,Integer> dist=new HashMap<>();
		bfsPath(h,src,dist);
		int dest=scan.nextInt();//to where dist needs to be measured
		System.out.println(dist);


	}
}
