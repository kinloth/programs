//package ep2_2012;

/****************************************************************/ 
/** ACH 2002 - Introducao a Ciencia da Computacao II           **/ 
/** EACH-USP - Segundo Semestre de 2012                        **/ 
/**                                                            **/ 
/** 02 - Fabio Nakano                                          **/ 
/**                                                            **/ 
/** Segundo Exercicio-Programa                                 **/ 
/**                                                            **/ 
/** Marcelo Gaioso Werneck  8061963                            **/ 
/**                                                            **/ 
/****************************************************************/ 

public abstract class Caminho {
	//TODO pode ser bastante util criar atributos estaticos, mas nao esqueca de zera-los quando necessario
	//TODO para resolver o problema, pode ser util criar um metodo auxiliar recursivo (e estatico)
	
	/* Este metodo deve retornar o caminho mais curto que passe por 
	 * todas as cidades do mapa apenas uma vez,
	 * comecando pela Cidade origem e terminando na Cidade destino.
	 * O caminho deve ser retornado na forma de um arranjo de cidade.
	 */
	 public static Cidade[] caminhores; //caminho que sera utilizado para clonar a resposta.
	 public static Cidade[] caminhoaux;	//caminho auxiliar que vai armazenando as cidades para dps calcular a distancia.
	 public static double menor;		//variavel que guarda a menor distancia.
	 
	public static void cria(Mapa mapa, int x, Cidade origem, Cidade destino) //metodo auxiliar que controi os dois arrays.
	{
		caminhores = new Cidade[x]; //cria com tamamanho especificado na assinatura.
		caminhoaux = new Cidade[x];	//idem anterior.
	}	 
	
	public static void clona(Cidade[] caminho, Cidade[] caminho1) //metodo auxiliar para clonar os caminhos se os mesmos tiverem o mesmo tamanho.
	{
		if(caminho.length == caminho1.length)					  //se o tamanho entre eles forem iguais...
		{
			for(int i = 0; i < caminho.length; i++)				  //cada posicao do array recebe o elemento (da respectiva posicao) do outro array.
			caminho[i] = caminho1[i];
		}
		else
		System.out.println("Os arrays não possuem o mesmo tamanho."); //printa caso nao de certo.
	}

	public static Cidade[] encontrarMelhorCaminho(Mapa mapa, Cidade origem, Cidade destino)	//metodo que retorna encontra o melhor caminho utilizando o bt.
	{	
		menor = 0;													//variavel menor inicia como 0.
		int x = mapa.numeroDeCidades();								//cria uma variavel x com o numero de cidades do mapa atual.
		Cidade caminho[] = new Cidade[x];							//cria o caminho de cidades do tamanho da quantidade de cidades.
		cria(mapa, x, origem, destino);								//cria os arrays de acordo com a assinatura.
		bt(mapa, origem, destino, 0);								//invoca o metodo backtrack para encontrar o melhor caminho.
		clona(caminho, caminhores);									//clona o caminho utilizado pelo bt com o caminho do metodo.
		
		return caminho;												//retorna o melhor caminho.
	}
	
	public static void bt(Mapa mapa, Cidade origem, Cidade destino, int visitadas)			//metodo backtrack
	{
		double distancia = 0;										//cria e inicializa com 0 uma variavel distancia.
		
		caminhoaux[visitadas] = origem;								//caminhoaux recebera, conforme aumentara o numero de visitadas, a origem
		origem.cidadeVisitada = true;								//"marca" a cidade como visitada.
		
		for(int i = 0; i < origem.vizinhas.length ; i++)			//para cada cidade vizinha a esta...
		{		
			if((origem.vizinhas[i].cidade != destino) && (origem.vizinhas[i].cidade.cidadeVisitada == false))	//se a vizinha para qual esta olhando for difente de destino
			{                                                                                                   //e nao tiver sido visitada.
				bt(mapa, origem.vizinhas[i].cidade, destino, visitadas+1);										//(recursao)chama o metodo bt incrementando visitadas.
				origem.vizinhas[i].cidade.cidadeVisitada = false;												//"desmarca" a cidade visitada.
			}	
			if(visitadas == (mapa.numeroDeCidades()-2) && (origem.vizinhas[i].cidade == destino))				//se a quantidade de visitadas for numero de cidades -2
			{																									//e pra qual ele estiver olhando for o destino.
				caminhoaux[visitadas+1] = destino;																//a o caminhoaux recece o destino.
				distancia = mapa.calcularDistanciaDoCaminho(caminhoaux); 										//distancia recebe a distancia de todo caminhoaux.
				if(menor > distancia || menor == 0)																//se esta for maior q a menor, ou menor for 0(inicialmente).		
				{
					menor = distancia;																			//menor recebe essa distancia.
					clona(caminhores, caminhoaux);																//clona o caminho-auxiliar no caminho-resposta.
				}
			}
		}
	}
}