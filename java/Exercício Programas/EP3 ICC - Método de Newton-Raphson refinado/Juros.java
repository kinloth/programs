/*****************************************************************/
/**  ACH2001  - Introdução à Ciência da Computação I            **/
/**  EACH-USP - Terceiro Semestre de 2011                       **/
/**  Turma 02 - Nakano  										**/
/**																**/
/**	 Terceiro Exercício-Programa							    **/
/**	 Arquivo: Juros												**/
/**																**/
/**  Marcelo Gaioso Werneck 					8061963         **/
/**																**/
/**  01/07/2012													**/
/*****************************************************************/

import lista.*;
import depositos.*;

/*
	VOCÊ PODE IMPORTAR AS CLASSES QUE DESEJAR AQUI
*/

class Juros {
	
	/*
		VOCÊ PODE INCLUIR OS MÉTODOS E ATRIBUTOS QUE QUISER, DESDE QUE OS JUROS SEJAM CALCULADOS COM UMA ÚNICA CHAMADA A "juros".
	*/
	
	/**
		Calcula os juros pagos, a partir de uma seqüência de depósitos e um saldo final, com a precisão indicada. Usa o método de Newton-Raphson para tal.
		
		@param depositos Lista de depósitos (não incluindo o saldo final)
		@param saldo Saldo final da aplicação
		@param epsilon Precisão do cálculo (0 < epsilon < 1)
		
		@return Valor dos juros, ou NAN em caso de erro (epsilon fora dos limites, lista de depósitos sem depósitos, saldo null)

	*/
	public static double juros(ListaDepositos depositos, Deposito saldo, double epsilon) {
	
	int cont = depositos.elementos();								
	No inicio = depositos.getInicio();									//Coloca a referencia do inicio da lista em uma variavel.
	Deposito[]D = new Deposito[cont];									//Declara um array D, do tipo Deposito. (tamanho possui o tanto de elementos na lista)
	int M[] = new int[cont];											//Array que armazena os valores das diferenças dos meses.
		
	if (epsilon > 0 && epsilon < 1 && depositos != null && saldo != null){	//condiçãos para realizar o calculo do juros.
		for (int i = 0; i < cont ; i++){									//Referencia cada elemento da lista em uma posição do array.
			D[i] = inicio.getDeposito();
			inicio = inicio.getProx();		
		}			
			
		for(int i = 0; i < cont -1; i++){ 							//Ordena o array de acordo com as Datas usando Bubble Sort(da mais antiga para a mais nova.
			for (int j = 0; j < cont -1; j++){
				if(D[j].getData().maior(D[j+1].getData()) == 1){
					Deposito aux = D[j];
					D[j]=D[j+1];
					D[j+1]=aux;
				}
			}
		}	
	for(int i = 0; i < cont; i++)
	M[i] = saldo.getData().mesesEntre(D[i].getData());					//Calcula os meses e armazena no array M[].	
		
	double jk;
	double j = 0.5;
	double fj = 0; 						
	double Dfj = 0;						
			
	for(int i = 0; i < cont; i++){
		fj += D[i].getValor() * Math.pow((1+j) , (M[i]));				//Calcula os valores da funcao de j e armazena no array ja[].			
		Dfj += M[i] * D[i].getValor() * Math.pow((1+j) , (M[i]-1));		//Calcula os valores da derivada da funcao de j e armazena no array jb[].
	}		
	jk = j - ((fj- saldo.getValor())/Dfj);								//calcula jk.
		
	while (Math.abs(jk-j) >= epsilon){									//condição que indica a precisao.	
		fj = 0;															//faz a funcao se tornar 0 para poder calcula-la novamente.
		Dfj = 0;
		j = jk;
		for(int i = 0; i < cont; i++){									//calcula novamente a função de j e a derivada dela.
			fj += D[i].getValor() * Math.pow((1+j) , (M[i]));			
			Dfj += M[i] * D[i].getValor() * Math.pow((1+j) , (M[i]-1));
		}			
		jk = j - ((fj- saldo.getValor())/Dfj);			
	}
		return jk;
	}
	return Double.NaN;													//retorna NaN caso nao tenho obedecido as condicoes para o calculo.
	}
		
	public static void main(String[] args) { 
	}
}

