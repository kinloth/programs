package ep3_2012;

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

public abstract class Colorir {
	// pode ser bastante util criar atributos estaticos, mas nao esqueca de zera-los quando necessario
	// para resolver o problema usando backtracking pode ser util criar um metodo auxiliar recursivo (e estatico)
	
	/* Este metodo deve mudar o atributo cor de cada cidade do mapa
	 * de forma que cidades vizinhas tenham cores diferentes e
	 * usando o menor numero de cores possivel (comecando com cor=1).
	 */
	public static Cidade[] caminhores; //caminho que sera utilizado para clonar a resposta.
	public static Cidade[] caminhoaux;	//caminho auxiliar que vai armazenando as cidades para dps calcular a distancia.
	
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
	 
	public static void encontrarColoracaoBackTracking(Mapa mapa){
		
		int x = mapa.numeroDeCidades();
		caminhores = new Cidade[x];
		caminhoaux = new Cidade[x];
		backtrack(mapa, mapa.cidadesDoMapa, 0);
	}

	public static void backtrack(Mapa mapa, Cidade cidades[], int visitadas)
	{
		int menor = 0;
		int x = 0;
		for(int i = 0; i < cidades.length ; i++)		
		{		
			if(cidades[i].cidadeVisitada == false && visitadas != cidades.length-1)
			{
				caminhoaux[visitadas] = cidades[i];
				cidades[i].cidadeVisitada = true;
				backtrack(mapa, cidades, visitadas+1);										
				cidades[i].cidadeVisitada = false;
			}
			if(visitadas == cidades.length-1 && cidades[i].cidadeVisitada == false)
			{
				caminhoaux[visitadas] = cidades[i];
				guloso(caminhoaux);
				x = qntcor(caminhoaux);			
				if(menor <= x)
				{	
					clona(caminhores, caminhoaux);
					menor = x;
				}
				zerar(caminhoaux);
			}
		}
		guloso(caminhores);
	}
	public static void encontrarColoracaoGuloso(Mapa mapa){

		guloso(mapa.cidadesDoMapa);	
	}
	
	public static void zerar(Cidade cidades[])
	{
		for(int i = 0; i < cidades.length ; i++)
		cidades[i].cor = 0;
	}
	
	public static void guloso(Cidade cids[])
	{
		int menor = 0;
		int x = 0;
		for(int i = 0; i < cids.length; i++)
		{
			x = menorCor(cids[i]);
			if(menor < x){			menor = x;}
			cids[i].cor = x;
			cids[i].cidadeVisitada = true;
		}
	}
	
	public static int qntcor(Cidade cids[])
	{
		int x = 0;
		for(int i = 0; i< cids.length ; i++)
		{
			if(cids[i].cor > x)
			x = cids[i].cor;
		}
		return x;
	}
	
	public static int menorCor(Cidade cidade)
	{
		int y = 1;
		int menor = 0;
		int cont = 0;
		while(menor == 0)
		{
			for(int i = 0; i < cidade.vizinhas.length; i++)
			{
				if(cidade.vizinhas[i].cidadeVisitada == false || cidade.vizinhas[i].cor != y)
				{
					cont++;
				}else
					{
						y++;
						cont = 0;
						break;
					}
			}
			if(cont == cidade.vizinhas.length)
			menor = y;
		}
		return menor;
	}
}