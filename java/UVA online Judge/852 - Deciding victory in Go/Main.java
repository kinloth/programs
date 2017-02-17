import java.util.LinkedList;
import java.util.Scanner;

class Ponto{
	int i, j;
	Ponto(int i, int j){
		this.i = i;
		this.j = j;
	}
}
public class Main {
	
	static LinkedList<Ponto> territorio = new LinkedList<Ponto>();
	static LinkedList<Integer> adjacentes = new LinkedList<Integer>(); 
	public static String[] direcao = {"acima","abaixo","esquerda","direita"};
	static int[][] matriz = new int[9][9];

	public static void ajusta(){
		if(adjacentes.size() > 1)
			for (Ponto p : territorio)
				matriz[p.i][p.j] = 10;
		else
			for (Ponto p : territorio)
				matriz[p.i][p.j] = adjacentes.getFirst();
		
		territorio.clear();
		adjacentes.clear();	
	}
	
	public static void conta(){
		int b = 0;
		int w = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(matriz[i][j] == 0) w++;
				else if(matriz[i][j] == 1) b++; 
			}
		}
		System.out.println("Black "+b+" White "+w);
	}
	
	public static void verificaAdj(int i, int j){
		matriz[i][j] = -2;
		Ponto p = new Ponto(i,j);
		territorio.add(p);
		for (String dir : direcao) {
			if(adjValido(i,j,dir)){
				int valor = matriz[direcaoAdj(i,"i",dir)][direcaoAdj(j,"j",dir)];
				if(valor >= 0){
					if(!adjacentes.contains(valor))
						adjacentes.add(valor);
				}else if(valor == -1)
					verificaAdj(direcaoAdj(i,"i",dir), direcaoAdj(j,"j",dir));
			}
				
		}			
	}
	
	public static int direcaoAdj(int valor, String coordenada, String direcao){
		if(direcao.equals("acima") && coordenada.equals("i") ||
				direcao.equals("esquerda") && coordenada.equals("j"))
			return valor-1;
		else if(direcao.equals("abaixo") && coordenada.equals("i")|| 
				direcao.equals("direita") && coordenada.equals("j")) 
			return valor+1;
		
		return valor;
	}
	
	public static boolean adjValido(int i, int j, String posicao){
		if(posicao.equals("acima") && i == 0) return false;
		else if(posicao.equals("abaixo") && i == 8) return false;
		else if(posicao.equals("esquerda") && j == 0) return false;
		else if(posicao.equals("direita") && j == 8) return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int it = sc.nextInt(); it > 0; it--){
			for (int i = 0; i < matriz.length; i++) {
				String linha = sc.next();
				for (int j = 0; j < matriz.length; j++) {
					if(linha.charAt(j) == 'O')
						matriz[i][j] = 0;
					else if(linha.charAt(j) == 'X')
						matriz[i][j] = 1;
					else
						matriz[i][j] = -1;
				}
			}
			
			for (int i = 0; i < matriz.length; i++) 
				for (int j = 0; j < matriz.length; j++) 
					if(matriz[i][j] == -1){
						verificaAdj(i,j);
						ajusta();
					}
			conta();
			
		}
		sc.close();
	}	
}