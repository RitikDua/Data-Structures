import java.util.*;
public class Pratice2{
	public static boolean check(Stack<Integer> st1,Stack<Integer> st2)
	{
			while(((!st1.empty())&&(!st2.empty())))
			if(st1.pop()!=st2.pop())
				return false;
	if(!st1.empty()) return false;
	
	if(!st2.empty()) return false;
	return true;
}
	public static void main(String[] args)
	{Scanner scan=new Scanner(System.in);
		Stack<Integer> st1=new Stack<>();
		Stack<Integer> st2=new Stack<>();
		int x=scan.nextInt();
		while(x!=-1)
		{
			st1.push(x);
			x=scan.nextInt();
		}
		x=scan.nextInt();
		while(x!=-1)
		{
			st2.push(x);
			x=scan.nextInt();
		}
		System.out.println(check(st1,st2));
		
	}
}
