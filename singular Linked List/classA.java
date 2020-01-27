import java.util.*;
public class classA{
public static void main(String[] args)
{Scanner scan=new Scanner(System.in);
int m=scan.nextInt();
int n=scan.nextInt();
int []a=new int[n];
for(int i=0;i<n;i++)
a[i]=scan.nextInt();

int max1=a[0],max2=a[0];
int[] f1=new int[100000];
Arrays.fill(f1,0);
int count1,count2;
count1=count2=0;
for(int i=0;i<n;i++)
{
	{max1=max1>(1*a[i])?max1:(1*a[i]);f1[a[i]]++;}

}
int y=0;
int[] x=new int[10*max1+1];
int[] d=new int[10*max1+1];
for(int i=0;i<=max1;i++)
	if(f1[i]!=0)
	{int v=(int)Math.floor(Math.log10(i)+1);
	d[y]=v;
	x[y++]=f1[i]*((int)Math.pow(10,v))+i;
	}
	m=y-m;
for(int i=0;i<y;i++)
if(i==m-1)
{System.out.println((int)x[i]/(Math.pow(10,d[i]))+" "+(int)x[i]%(Math.pow(10,d[i])));}

}

}
