import java.util.*;

public class Main
{
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		while(K != 0)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			for(int i = 0; i < K; i++)
			{
				int X = sc.nextInt();
				int Y = sc.nextInt();
				if(X > N && Y > M)	 	System.out.println("NE");
				if(X > N && Y < M)		System.out.println("SE");
				if(X < N && Y > M)		System.out.println("NO");
				if(X < N && Y < M)		System.out.println("SO");
				if(X == N || Y == M)	System.out.println("divisa");
			}
			K = sc.nextInt();
		}
	}
}