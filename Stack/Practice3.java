import java.util.*;
public class Practice3{
	public static boolean fun(Stack<Character> st,String str)
	{
	
for(int i=0;i<str.length();i++)
{
	if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='[')
		st.push(str.charAt(i));
	else	
		{if(st.empty()) return false;char x=st.pop();}
}
return  (st.empty());
	
	}
public static void main(String[] args)
{
Stack<Character> st=new Stack<Character>();
String str=(new Scanner(System.in)).next();
System.out.println(fun(st,str));
}}
