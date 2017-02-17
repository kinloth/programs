import java.util.*;

class Main
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f;
		double s, a, e;
		int premium = 0;
		for(int i = 0; i < n; i++)
		{
			f = sc.nextInt();
			for(int j = 0; j < f; j++)
			{
				s = sc.nextInt();
				a = sc.nextInt();
				e = sc.nextInt();
				premium +=  Math.ceil(((s/a)*e)*a);
			}
			System.out.println(premium);
			premium = 0;
		}
	}
}