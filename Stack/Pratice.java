import java.util.*;
public class Pratice{
	public static void main(String[] args)
	{
		Stack<Integer> st=new Stack<>();
		Stack<Integer> st1=new Stack<>();
		Stack<Integer> st2=new Stack<>();
		Scanner scan=new Scanner(System.in);
		int x=scan.nextInt();
		while(x!=-1)
		{
			st.push(x);
			x=scan.nextInt();
		}
		System.out.println("before");
		st.forEach(System.out::print);
		
		while(!st.empty())
			st1.push(st.pop());
		while(!st1.empty())
			st2.push(st1.pop());
		//System.out.println();
		System.out.println("\n After");
		st2.forEach(System.out::print);
		

	}
}
