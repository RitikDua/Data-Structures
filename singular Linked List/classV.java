import java.util.*;
public class classV{
public static void main(String[] args)
{Scanner scan=new Scanner(System.in);
//int m=scan.nextInt();
int n=scan.nextInt();
int []a=new int[n];
for(int i=0;i<n;i++)
a[i]=scan.nextInt();
int x,y;
x=y=0;
int sum=0;
int min=0;
for(int i=0;i<n;i++)
{
	int t=i;sum=0,c1=0,c2=1;int j=i+1;
	while(j<n)
	{if(a[j]==0)
		c1++;
	else
	c2++;
	if(c1==c2)
	{
		min=min>(j-i)?min:(j-i);
	j++;
	}
	

}
System.out.println(min);
}}
