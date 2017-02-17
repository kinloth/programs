/*********************************************************************/
/** ACH2001 - Introdução à Ciência da Computação I  				**/
/** EACH-USP - Primeiro Semestre de 2011 							**/
/** 42 - Fábio Nakano 												**/
/** 																**/
/** Segundo Exercício-Programa 										**/
/** Arquivo: Matriz.java 											**/
/** 																**/
/** Marcelo Gaioso Werneck 				8061963 					**/
/** 																**/
/** 27/05/2012														**/
/*********************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class Matriz {
	protected double M[][];
	/** Este método lê a matriz armazenada no arquivo (espera-se que
	  * ela seja única). Esta tem que 
	  * começar com dois inteiros que informam o número de linhas e
	  * o número de colunas da matriz. Os números que se seguem são
	  * são os elementos da matriz, do tipo double, cujo separador de
	  * casa decimal é o ponto.
	  * @param nomeArquivo nome do arquivo que contém a matriz (única).
	  */
	void le(String nomeArquivo) {
		int[] dim = new int[2];
		File arquivo = new File(nomeArquivo);
		try {

			Scanner sc = new Scanner(arquivo);
			sc.useLocale ( new Locale ("US"));
			int i=0;
			while (sc.hasNextInt() && (i<2)) {
				dim[i++] = sc.nextInt();
            }

			int contador=0;
			M = new double[dim[0]][dim[1]];
			while (sc.hasNextDouble() && (contador<(dim[0]*dim[1]))) {
				M[contador/dim[1]][contador%dim[1]] = sc.nextDouble();
				contador++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
        }
	}
	public double[] resolve () {
		double [] r= new double[M.length];   				//Inicializa, para este dummy rodar.
		double p;											//p é uma variavel q multiplicara todos os elementos das linhas e colunas afim de escalonar a matriz.
		int i = 0;											//i é uma variável refetente as linhas.
		for(int w = 0; w < M[0].length-2; w++){				//w é uma variável independente da matriz, foi ultilizada apenas para fazer os outros for's até chagar na penúltima coluna.
			for(int k = 1; k < M.length - i; k++){			//k é uma variável auxiliar das linhas, com ela é possivel fazer um looping com a linhas em função de i.
			
				p = M[i+k][i] / M[i][i]; 					//Fórmula para calcular p.
			
				for(int j = 0; j < M[0].length; j++){		//Esse é um for que multiplica o valor de p em cada coluna.
					M[i+k][j] = M[i+k][j] - M[i][j]*p;		//A partir dessa equação que é calculado o novo valor para cada elemento na coluna.
				}				
			}
			i++;											//Adiciona mais 1 ao valor da linha, fazendo com que os elementos menores da coluna i sejam conservados.
		}		
		
		for (i = M.length-1; i >= 0; i--){ 							//Calcula os valores de x de um sistema linear(no caso r[i], onde i é a quantidade de incógnitas).
			r[i] = (M[i][M[0].length-1] - somatoria(r,i))/M[i][i]; //Fórmula para calcular cada x(no caso, cada r[i]).
		}
		return r;
	}
	
	public double somatoria(double r[],int i){ 			//Método que calcula a somatória.
		double soma = 0; 								//A soma inicial deve ser 0 por que ela iria somar um valor a ela mesma.
			for(int j= M[0].length-2; j != i; j--){		//A soma é realizada de trás pra frente, somando todos os valores enquanto j for diferente de i.
				soma += M[i][j]*r[j]; 					//Fórmula para calcular a soma.
			}			
	return soma;
	} 
	
	
	/** Este método imprime a matriz armazenada em M no mesmo formato como é lida do arquivo. */
	public void imprime () {
		if ((M!=null) && (M.length>0) && (M[0].length>0)) {
			System.out.println (M.length + " " + M[0].length);
			for (int i=0;i<M.length;i++) {
				for (int j=0;j<M[i].length;j++) {
					System.out.print (M[i][j] + " ");
				}
			}
		}
		else {
			System.out.println ("Matriz inexistente ou de tamanho zero.");
		}
	}

	public static void main (String[] args) {
		Matriz M= new Matriz ();
		double[] r;
		M.le ("teste7.m");
		M.imprime ();
		System.out.println ("Solucao para teste7.m");
		r= M.resolve ();             
		if (r!=null) {
			for (int i=0;i<r.length;i++) {
				System.out.println (r[i]);
			}
		}
	}
}

