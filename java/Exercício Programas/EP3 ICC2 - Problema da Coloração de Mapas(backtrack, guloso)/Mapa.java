// package ep3_2012;

import java.util.Random;

public class Mapa {
	Cidade[] cidadesDoMapa;  // arranjo com todas as cidades do mapa

	/* construtor da classe Mapa */
	Mapa (Cidade[] cids){
		cidadesDoMapa = cids;
	}
	
	/* metodo para retornar o numero de cidades do mapa atual */
	public int numeroDeCidades(){
		return cidadesDoMapa.length;
	}
	
	/* dado um mapa, verifica se existem problemas com a coloracao */
	static boolean verificarSolucao(Mapa mapa){
		Cidade[] cidades = mapa.cidadesDoMapa;
		for (int i=0;i<cidades.length;i++){
			if (cidades[i].cor<=0){
				System.err.println("A cidade "+cidades[i].nome+" esta colorida com uma cor invalida: " + cidades[i].cor + ".");
				return false;
			}else{
				Cidade[] vizinhas = cidades[i].vizinhas;				
				for (int c=0;c<vizinhas.length;c++){
					if (cidades[i].cor==vizinhas[c].cor){
						System.err.println("Duas cidades vizinhas estao com a mesma cor: " + cidades[i] + " e " + vizinhas[c] + "; cor destas cidades: " + cidades[i].cor + ".");
						return false;
					}
				}
			}
		}
		return true;
	}

	/* verifica se duas cidades sao vizinhas
	 * Dica: eh possivel (e recomendavel) implementar uma boa solucao sem utilizar este metodo 
	 */
	static boolean duasCidadesSaoVizinhas(Cidade cidade1, Cidade cidade2){
		Cidade temp;
		for (int i=0;i<cidade1.vizinhas.length;i++){
			temp = cidade1.vizinhas[i];
			if (temp == cidade2) return true;
		}
		return false;
	}
	
	/* retorno o valor da maior cor usada no mapa */
	static int maiorCorDoArranjo(Mapa mapa){
		int max = 0;
		Cidade[] cidades = mapa.cidadesDoMapa;
		for (int i=0;i<cidades.length;i++){
			if (cidades[i].cor>max) max = cidades[i].cor;
		}
		return max;
	}
	
	/* metodo que imprime as cidades de um mapa e sua coloracao */ 
	static void imprimirColoracao(Mapa mapa){
		Cidade[] cidades = mapa.cidadesDoMapa;
		System.out.println("Imprimindo coloracao ("+cidades.length+" cidades):");
		for (int i=0;i<cidades.length;i++){
			if (cidades[i].cor <= 0){
				System.err.println("Ha cores negativas ou nulas na solucao.");
			}else{
				System.out.println("Cidade: " + mapa.cidadesDoMapa[i].nome + ", cor: "+ cidades[i].cor+".");
			}
		}
	}

	/* coloca a cor 'zero' em todas as cidades do mapa */
	static void zerarColoracaoMapa(Mapa mapa){
		for (int i=0;i<mapa.cidadesDoMapa.length;i++){
			mapa.cidadesDoMapa[i].cor = 0;
		}
	}
	
	/* metodo gerador de mapas aleatorios */
	static Mapa geradorDeMapa(int cidades, int ligacoes){
		Mapa mapa = new Mapa(new Cidade[cidades]);
		for (int c=0;c<cidades;c++){
			mapa.cidadesDoMapa[c] = new Cidade("cidade" + (c+1));
		}
		int cont=0;
		if (ligacoes > (cidades-1)*(cidades-1)/2) ligacoes = (cidades-1)*(cidades-1)/2;
		int[] numVizinhas = new int[cidades];
		int[][] ads = new int[cidades][cidades];
		Random r = new Random();
		while (cont<ligacoes){
			int id1 = r.nextInt(cidades);
			int id2 = r.nextInt(cidades);
			if (id1 != id2 && ads[id1][id2]==0){
				cont++;
				ads[id1][id2] = 1;
				ads[id2][id1] = 1;
				numVizinhas[id1]++;
				numVizinhas[id2]++;
			}
		}
		int indice;
		for (int c=0;c<cidades;c++){
			indice = 0;
			mapa.cidadesDoMapa[c].vizinhas = new Cidade[numVizinhas[c]];
			for (int v=0;v<cidades;v++){
				if (ads[c][v]>0){
					mapa.cidadesDoMapa[c].vizinhas[indice] = mapa.cidadesDoMapa[v];
					indice++;
				}
			}
		}
		return mapa;
	}
	
}
