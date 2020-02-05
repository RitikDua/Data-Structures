import java.util.*;
public class IToPre{
	static int[] p=new int[300];
	public static StringBuffer fun(char ch,Stack<Character> s,StringBuffer o)
		
	{
		p[(int)'^']=3;
		p[(int)'*']=p[(int)'/']=2;
		p[(int)'+']=p[(int)'-']=1;
		if(ch==')')
		{
			s.push(ch);return o;}
		if(ch=='(')
		{
			char x=s.pop();
			while(!s.empty()&&x!=')')
			{
				o.append(x);
				x=s.pop();
			}
			return o;
		}
		if(ch=='^'&&s.peek()=='^')
		{
			char x=s.peek();
			while(s.peek()=='^')
			{
				o.append(s.pop());}
						s.push(ch);
			return o;
		}
		if((p[(int)ch]>=p[(int)s.peek()])||p[(int)s.peek()]==')')
		{
			s.push(ch); return o;}
		char temp=s.pop();
		while((temp!='('||s.empty())&&p[(int)temp]<p[(int)ch])
		{
			o.append(temp);
			temp=s.pop();
		}
		s.push(ch);
		return o;


	}
	public static String itopre(Stack<Character> st,String expr)
	{
		StringBuffer str=new StringBuffer(expr);
		StringBuffer o=new StringBuffer("");
		int i=expr.length()-1;
		while(i>=0)
		{
			if(str.charAt(i)>='a'&&str.charAt(i)<='z')
				o.append(str.charAt(i));
			else o=fun(str.charAt(i),st,o);
			i--;
		}
		while(!st.empty())
			o.append(st.pop());
		List<Character> l=Arrays.asList(o.toCharArray());
		 Collections.reverse(l);
		return l.stream().map(Character::valueOf);
	}
	public static void main(String[] args)
	{
		Stack<Character> st=new Stack<Character>();
		String expr=(new Scanner(System.in)).nextLine();
		System.out.println(itopre(st,expr));
	}
}
