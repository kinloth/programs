// package ep3_2012;

public class ExecutaTestes {
	static boolean IMPRIMIR_COLORACAO = false;
	static int CONJUNTO_DE_TESTE = 1;
	
	public static void main(String[] args){
		

		if (CONJUNTO_DE_TESTE==1){
			testaExemplo(mapa0());
			testaExemplo(mapa1());
			testaExemplo(mapa2());
			testaExemplo(mapa3());
			testaExemplo(mapa4());
			testaExemplo(mapa5());
			testaExemplo(mapa6());
			testaExemplo(mapa7());
			testaExemplo(mapa8());
		}else if (CONJUNTO_DE_TESTE==2){
			testaExemplo(Mapa.geradorDeMapa(15, 100));
			testaExemplo(Mapa.geradorDeMapa(20, 100));
			testaExemplo(Mapa.geradorDeMapa(25, 100));
			testaExemplo(Mapa.geradorDeMapa(30, 100));
			testaExemplo(Mapa.geradorDeMapa(30, 250));
			testaExemplo(Mapa.geradorDeMapa(40, 200));
			testaExemplo(Mapa.geradorDeMapa(40, 300));
			testaExemplo(Mapa.geradorDeMapa(40, 400));
			testaExemplo(Mapa.geradorDeMapa(100, 100));
		}else if (CONJUNTO_DE_TESTE==3){
			testaExemplo(Mapa.geradorDeMapa(25, 10));
			testaExemplo(Mapa.geradorDeMapa(25, 20));
			testaExemplo(Mapa.geradorDeMapa(25, 30));
			testaExemplo(Mapa.geradorDeMapa(25, 40));
			testaExemplo(Mapa.geradorDeMapa(25, 50));
			testaExemplo(Mapa.geradorDeMapa(25, 100));
			testaExemplo(Mapa.geradorDeMapa(25, 150));
			testaExemplo(Mapa.geradorDeMapa(25, 200));
			testaExemplo(Mapa.geradorDeMapa(25, 300));
		}
	}


	private static void testaExemplo(Mapa mapa) {
		long inicioDaExecucao;
		long tempoTotal1;
		long tempoTotal2;
		int coresBack = 0;
		int coresGuloso = 0;
		Mapa.zerarColoracaoMapa(mapa);
		System.out.println("############ Exemplo: mapa composto por "+mapa.cidadesDoMapa.length+" cidades.");
		System.out.println("####### Solucao BackTracking:");
		inicioDaExecucao = System.currentTimeMillis();
		Colorir.encontrarColoracaoBackTracking(mapa);
		tempoTotal1 = System.currentTimeMillis()-inicioDaExecucao;
		if(IMPRIMIR_COLORACAO) Mapa.imprimirColoracao(mapa);
		coresBack = Mapa.maiorCorDoArranjo(mapa);
		System.out.println("Cores usadas: " + coresBack);
		Mapa.zerarColoracaoMapa(mapa);
		System.out.println("####### Solucao Gulosa:");
		inicioDaExecucao = System.currentTimeMillis();
		Colorir.encontrarColoracaoGuloso(mapa);
		tempoTotal2 = System.currentTimeMillis()-inicioDaExecucao;
		if(IMPRIMIR_COLORACAO) Mapa.imprimirColoracao(mapa);
		coresGuloso = Mapa.maiorCorDoArranjo(mapa);
		System.out.println("Cores usadas: " + coresGuloso);
		System.out.println("Tempo da solucao usando BackTracking: " + tempoTotal1 + " ms [cores: "+coresBack+"]; tempo da solucao gulosa: " + tempoTotal2 + " ms [cores: "+coresGuloso+"].");
	}

	static Mapa mapa0(){
		Cidade[] exemplo0 = new Cidade[2];
		exemplo0[0] = new Cidade("Y");
		exemplo0[1] = new Cidade("X");
		Cidade[] d1 = {};
		Cidade[] d2 = {};
		exemplo0[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo0[1].adicionarArranjoDeCidadesVizinhas(d2);
		return new Mapa(exemplo0);		
	}

	static Mapa mapa1(){
		Cidade[] exemplo1 = new Cidade[2];
		exemplo1[0] = new Cidade("Y");
		exemplo1[1] = new Cidade("X");
		Cidade[] d1 = {exemplo1[1]};
		Cidade[] d2 = {exemplo1[0]};
		exemplo1[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo1[1].adicionarArranjoDeCidadesVizinhas(d2);
		return new Mapa(exemplo1);		
	}

	static Mapa mapa2(){
		Cidade[] exemplo2 = new Cidade[3];
		exemplo2[0] = new Cidade("A");
		exemplo2[1] = new Cidade("B");
		exemplo2[2] = new Cidade("C");
		Cidade[] d1 = {exemplo2[1],exemplo2[2]};
		Cidade[] d2 = {exemplo2[0],exemplo2[2]};
		Cidade[] d3 = {exemplo2[0],exemplo2[1]};
		exemplo2[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo2[1].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo2[2].adicionarArranjoDeCidadesVizinhas(d3);
		return new Mapa(exemplo2);		
	}


	static Mapa mapa3(){
		Cidade[] exemplo3 = new Cidade[4];
		exemplo3[0] = new Cidade("E");
		exemplo3[1] = new Cidade("F");
		exemplo3[2] = new Cidade("G");
		exemplo3[3] = new Cidade("H");
		Cidade[] d1 = {exemplo3[3],exemplo3[1]};
		Cidade[] d2 = {exemplo3[0],exemplo3[2],exemplo3[3]};
		Cidade[] d3 = {exemplo3[1],exemplo3[3]};
		Cidade[] d4 = {exemplo3[2],exemplo3[0],exemplo3[1]};
		exemplo3[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo3[1].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo3[2].adicionarArranjoDeCidadesVizinhas(d3);
		exemplo3[3].adicionarArranjoDeCidadesVizinhas(d4);
		return new Mapa(exemplo3);		
	}

	static Mapa mapa4(){
		Cidade[] exemplo4 = new Cidade[5];
		exemplo4[0] = new Cidade("I");
		exemplo4[1] = new Cidade("J");
		exemplo4[2] = new Cidade("K");
		exemplo4[3] = new Cidade("L");
		exemplo4[4] = new Cidade("M");
		Cidade[] d1 = {exemplo4[1],exemplo4[2],exemplo4[3],exemplo4[4]};
		Cidade[] d2 = {exemplo4[0],exemplo4[2],exemplo4[3],exemplo4[4]};
		Cidade[] d3 = {exemplo4[0],exemplo4[1],exemplo4[3],exemplo4[4]};
		Cidade[] d4 = {exemplo4[0],exemplo4[1],exemplo4[2],exemplo4[4]};
		Cidade[] d5 = {exemplo4[0],exemplo4[1],exemplo4[2],exemplo4[3]};
		exemplo4[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo4[1].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo4[2].adicionarArranjoDeCidadesVizinhas(d3);
		exemplo4[3].adicionarArranjoDeCidadesVizinhas(d4);
		exemplo4[4].adicionarArranjoDeCidadesVizinhas(d5);
		return new Mapa(exemplo4);		
	}

	static Mapa mapa5(){
		Cidade[] exemplo5 = new Cidade[5];
		exemplo5[0] = new Cidade("N");
		exemplo5[1] = new Cidade("O");
		exemplo5[2] = new Cidade("P");
		exemplo5[3] = new Cidade("Q");
		exemplo5[4] = new Cidade("R");
		Cidade[] d0 = {exemplo5[1],exemplo5[3]};
		Cidade[] d1 = {exemplo5[0],exemplo5[2],exemplo5[3]};
		Cidade[] d2 = {exemplo5[1],exemplo5[3],exemplo5[4]};
		Cidade[] d3 = {exemplo5[0],exemplo5[1],exemplo5[2],exemplo5[4]};
		Cidade[] d4 = {exemplo5[2],exemplo5[3]};
		exemplo5[0].adicionarArranjoDeCidadesVizinhas(d0);
		exemplo5[1].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo5[2].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo5[3].adicionarArranjoDeCidadesVizinhas(d3);
		exemplo5[4].adicionarArranjoDeCidadesVizinhas(d4);
		return new Mapa(exemplo5);		
	}

	static Mapa mapa6(){
		Cidade[] exemplo6 = new Cidade[10];
		exemplo6[0] = new Cidade("a");
		exemplo6[1] = new Cidade("b");
		exemplo6[2] = new Cidade("c");
		exemplo6[3] = new Cidade("d");
		exemplo6[4] = new Cidade("e");
		exemplo6[5] = new Cidade("f");
		exemplo6[6] = new Cidade("g");
		exemplo6[7] = new Cidade("h");
		exemplo6[8] = new Cidade("i");
		exemplo6[9] = new Cidade("j");
		Cidade[] d0 = {exemplo6[9],exemplo6[1]};
		Cidade[] d1 = {exemplo6[0],exemplo6[2],exemplo6[5]};
		Cidade[] d2 = {exemplo6[1],exemplo6[3]};
		Cidade[] d3 = {exemplo6[2],exemplo6[4],exemplo6[8]};
		Cidade[] d4 = {exemplo6[3],exemplo6[5]};
		Cidade[] d5 = {exemplo6[4],exemplo6[6],exemplo6[1]};
		Cidade[] d6 = {exemplo6[5],exemplo6[7]};
		Cidade[] d7 = {exemplo6[6],exemplo6[8]};
		Cidade[] d8 = {exemplo6[7],exemplo6[9],exemplo6[3]};
		Cidade[] d9 = {exemplo6[8],exemplo6[0]};

		exemplo6[0].adicionarArranjoDeCidadesVizinhas(d0);
		exemplo6[1].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo6[2].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo6[3].adicionarArranjoDeCidadesVizinhas(d3);
		exemplo6[4].adicionarArranjoDeCidadesVizinhas(d4);
		exemplo6[5].adicionarArranjoDeCidadesVizinhas(d5);
		exemplo6[6].adicionarArranjoDeCidadesVizinhas(d6);
		exemplo6[7].adicionarArranjoDeCidadesVizinhas(d7);
		exemplo6[8].adicionarArranjoDeCidadesVizinhas(d8);
		exemplo6[9].adicionarArranjoDeCidadesVizinhas(d9);
		return new Mapa(exemplo6);		
	}

	static Mapa mapa7(){
		Cidade[] exemplo4 = new Cidade[6];
		exemplo4[0] = new Cidade("S");
		exemplo4[1] = new Cidade("T");
		exemplo4[2] = new Cidade("U");
		exemplo4[3] = new Cidade("V");
		exemplo4[4] = new Cidade("W");
		exemplo4[5] = new Cidade("X");
		Cidade[] d1 = {exemplo4[1],exemplo4[2],exemplo4[3]};
		Cidade[] d2 = {exemplo4[0],exemplo4[2],exemplo4[3],exemplo4[4]};
		Cidade[] d3 = {exemplo4[0],exemplo4[1],exemplo4[3],exemplo4[4]};
		Cidade[] d4 = {exemplo4[0],exemplo4[1],exemplo4[2],exemplo4[4]};
		Cidade[] d5 = {exemplo4[1],exemplo4[2],exemplo4[3]};
		Cidade[] d6 = {};
		exemplo4[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo4[1].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo4[2].adicionarArranjoDeCidadesVizinhas(d3);
		exemplo4[3].adicionarArranjoDeCidadesVizinhas(d4);
		exemplo4[4].adicionarArranjoDeCidadesVizinhas(d5);
		exemplo4[5].adicionarArranjoDeCidadesVizinhas(d6);
		return new Mapa(exemplo4);		
	}

	static Mapa mapa8(){
		Cidade[] exemplo4 = new Cidade[5];
		exemplo4[0] = new Cidade("k");
		exemplo4[1] = new Cidade("l");
		exemplo4[2] = new Cidade("m");
		exemplo4[3] = new Cidade("n");
		exemplo4[4] = new Cidade("o");
		Cidade[] d1 = {exemplo4[1],exemplo4[3]};
		Cidade[] d2 = {exemplo4[0],exemplo4[2],exemplo4[3],exemplo4[4]};
		Cidade[] d3 = {exemplo4[1],exemplo4[4]};
		Cidade[] d4 = {exemplo4[0],exemplo4[1],exemplo4[4]};
		Cidade[] d5 = {exemplo4[1],exemplo4[2],exemplo4[3]};
		exemplo4[0].adicionarArranjoDeCidadesVizinhas(d1);
		exemplo4[1].adicionarArranjoDeCidadesVizinhas(d2);
		exemplo4[2].adicionarArranjoDeCidadesVizinhas(d3);
		exemplo4[3].adicionarArranjoDeCidadesVizinhas(d4);
		exemplo4[4].adicionarArranjoDeCidadesVizinhas(d5);
		return new Mapa(exemplo4);		
	}

}
