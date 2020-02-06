import java.util.*;
public class evaluate{
	private static int eval(String str,Stack<Integer> st)
	{
		int sum,a,b;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='0'&&str.charAt(i)<='9')
				st.push((int)(str.charAt(i)-48));
			else{
				b=st.pop();
				a=st.pop();
				switch(str.charAt(i)){
					case '+': a=a+b; break;
					case '-': a=a-b; break;
					case '*': a=a*b; break;
					case '/': a=a/b; break;
				}
				st.push(a);
			}
		}
	return st.pop();
	}

	public static void main(String[] args)
	{
		Stack<Integer> st=new Stack<>();
		String str=(new Scanner(System.in)).nextLine();
		System.out.println(eval(str,st));
	}
}
