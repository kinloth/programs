import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int suspeitos;
	static LinkedList<int[]> listaGrupos;
	static LinkedList<Integer> listaSuspeitos;
	
	public static void contaSuspeitos(int suspeito){
		for (int grupo = 0; grupo < listaGrupos.size(); grupo++) 
			for (int aluno : listaGrupos.get(grupo))
				if(listaSuspeitos.contains(aluno)){
					for (int is : listaGrupos.get(grupo)) {
						if(!listaSuspeitos.contains(is))
							listaSuspeitos.add(is);
					}
					listaGrupos.remove(grupo);
					grupo = 0;
					break;
				}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		while(scan.hasNext()){
			listaSuspeitos = new LinkedList<Integer>();
			listaGrupos = new LinkedList<int[]>();			
			listaSuspeitos.add(0);
			int quant = scan.nextInt();
			int tam = scan.nextInt();
			if(quant == 0 && tam == 0) break;
			
			for(int i = 0; i < tam; i++){				
				int[] grupo = new int[scan.nextInt()];
				for(int j = 0 ; j < grupo.length; j++)
					grupo[j] = scan.nextInt();
				listaGrupos.add(grupo);
			}		
			
			long startTime = System.currentTimeMillis();
			long tempo = System.nanoTime();
			contaSuspeitos(0);
			System.out.println(listaSuspeitos.size());
			long stopTime = System.currentTimeMillis();
			long tempo2 = System.nanoTime();
			 long elapsedTime = stopTime - startTime;
		      System.out.println("Tempo = "+elapsedTime+"ms");
		      System.out.println("tempo2 = "+(tempo2 - tempo)+"ns");
		}	
		scan.close();
	}
}