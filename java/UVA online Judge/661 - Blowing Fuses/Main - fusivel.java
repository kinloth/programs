import java.util.*;

class Main
{		
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sequence = 1;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		while(n!= 0 && m!= 0 && c!= 0)
		{
			int ci[] = new int[n];
			for(int i = 0; i< n; i++)
				ci[i] = sc.nextInt();
			int aux = sc.nextInt();
			int co = 0;
			int cot = 0;
			int p = 0;

			for(int i = 0; i < m; i++)
			{
				for(int a = 0; a <ci.length; a++)
				{
					if(aux == a+1)
					{
						ci[a] = ci[a]*-1;
						co += ci[a];
						if(co < cot)
							cot = co;
						if((co + c) < 0)
							p = 1;
					}
				}
				if(i < m-1)
					aux = sc.nextInt();				
			}
			if(p != 1)
			{
			System.out.println("Sequence "+sequence);
			System.out.println("Fuse was not blown.");
			System.out.println("Maximal power consumption was "+ (cot*-1) +" amperes.\n");
			}
			if(p == 1)
			{
				System.out.println("Sequence "+sequence);
				System.out.println("Fuse was blown.\n");
			}
			sequence ++;
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
		}	
	}
}