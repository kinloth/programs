import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Estrutura {

	static int tempoEspera = 0;										//tempo de espera.
	static int tempoGeral = 0;										//tempo geral.
	static boolean CPUlivre = true;									//controlador sobre o uso da CPU.
	static LinkedList<Evento> lista = new LinkedList<Evento>();		//lista de eventos.
	static LinkedList<Evento> CPU = new LinkedList<Evento>();		//fila de espera da CPU.
	static LinkedList<Evento> lista1 = new LinkedList<Evento>();	//segunda fila das multiplas filas 
	static LinkedList<Evento> lista2 = new LinkedList<Evento>();	//terceira fila das multiplas filas.
	static int jobtable[][];										//tabela de processos.
	static int numeroProcessos;										//controla o numero de processos ativos.
	static int quantum = 8;											//utilizado nas multiplas filas e RoundRobin, para preempcao por tempo.
	static int quantum2 = 16;										//utilizado no algoritmo de multiplas filas por feedback.
	static int prioridade1 = 3;										//primeira prioridade utilizada nas multiplas filas.
	static int prioridade2 = 6;										//segunda prioridade das multiplas filas.
	
	static int escalonador = 1;											//qual escalonador devera ser utilizado.
	
		/* escalonador 1 = FCFS;
		 * escalonador 2 = SJF nao preemptivo; 
		 * escalonador 3 = SJF preemptivo; 
		 * escalonador 4 = Round Robin ;
		 * escalanador 5 = Multiplas filas Prioridade;
		 * escalonador 6 = Multiplas filas Realimentacao.
		 */
	static PrintWriter log = null;
	static boolean logTotal = true;;
	
	public static void CriaListaEventos(int jobtable[][]) {			//esse evento adiciona eventos na lista de processos conforme o tempo de chegada.

		for (int i = 0; i < jobtable.length; i++) {
			if (jobtable[i][1] == tempoGeral) {
				Evento evento = new Evento(1, jobtable[i][1], jobtable[i][0]);
				lista.add(evento);									//adiciona no final da lista
				escreve("(Processo " + jobtable[i][0]+ " chegou. Novo evento na lista!)");
			}
		}
	}

	public static void CriaJobTable(Scanner leitura) {				//esse metodo eh utilizado pra criar uma tabela correspondete aos processos.
	
		int numeroP = leitura.nextInt();							//numero de processo que tem no arquivo.
		leitura.nextLine();											//desconsidera as duas primeiras linhas.
		leitura.nextLine();
		jobtable = new int[numeroP][7];								//cria a jobtable conforme o numero de processos.
		int j = 0;
		while (leitura.hasNextLine()) { 							// coloca todo o arquivo de entrada na jobtable.
			for (int i = 0; i < 5; i++)				
				jobtable[j][i] = leitura.nextInt();
			jobtable[j][5] = 0;										//esse eh o tempo de espera.
			if(escalonador == 6)		jobtable[j][3] = 1;			//seta a prioridade inicial como 1.
			j++;													//incrementador
		}
		numeroProcessos = j;										//coloca em uma variavel o numero de processos para o controle da finalizacao
	}

	void Preempta(Evento ev) {										//esse metodo preempta o processo que esta na CPU.

		if(escalonador != 5 && escalonador != 6){					//se o metodo de escalonamento nao for o de multiplas filas...
			ev.setID(3);
			CPU.add(ev);
			lista.addFirst(CPU.pop());	
			
		}else if(escalonador == 5){									//agora se for, preempta a partir da prioridade.
			ev.setID(3);
			if(jobtable[ev.getProcesso()-1][3] <= prioridade1){		//se a prioridade do processo for menor ou igual a previamente estabelecida.
				CPU.add(ev);
				adicionaPrimeiroFilas();
			}else if(jobtable[ev.getProcesso()-1][3] <= prioridade2){//idem a segunda prioridade.
				lista1.add(ev);
				adicionaPrimeiroFilas();
			}else{													//para maiores que a segunda prioridade.
				lista2.add(ev);
				adicionaPrimeiroFilas();
			}
			
		}else if(escalonador == 6){
			ev.setID(3);
			if(jobtable[ev.getProcesso()-1][3] == 1){				//se a prioridade do processo esta como 1.
				jobtable[ev.getProcesso()-1][3] = 2;				//muda essa prioridade para 2.
				lista1.add(ev);										//adiciona ele na segunda lista.
				adicionaPrimeiroFilas();
			}else if(jobtable[ev.getProcesso()-1][3] == 2){	
				jobtable[ev.getProcesso()-1][3] = 3;				//muda essa prioridade para 3.
				lista2.add(ev);										//adiciona ele na segunda lista.
				adicionaPrimeiroFilas();
			}else if(jobtable[ev.getProcesso()-1][3] == 3){			//faz a mesma coisa soh que sem alterar a prioridade.
				lista2.add(ev);
				adicionaPrimeiroFilas();
			}
		}
		CPUlivre = true;
		escreve("Processo " + ev.getProcesso()+ "foi preemptado. CPU esta livre.");
	}
		
	static void adicionaPrimeiroFilas(){							//certificar que somente os processos de filas.
																	//superiores executem antes que os de filas inferiores.
		if(!CPU.isEmpty())				lista.addFirst(CPU.pop());
		else if(!lista1.isEmpty())		lista.addFirst(lista1.pop());
		else if(!lista2.isEmpty())		lista.addFirst(lista2.pop());
	}
	
	static void escreve(String st){									//metodo utilizado para facilitar a escrita no arquivo.
			if(logTotal)											//controla o log total ou resumido.
				log.println(st);
	}
	static void inicializaLog(){									//serve para abrir o arquivo de log e inicializa-lo.
		Arquivo arq = new Arquivo();
		try {
			log = new PrintWriter(arq.escrita());					//utiliza o metodo escrita da classe Arquivo.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void finalizaLog(){										//simplesmente para facilitar a vizualizacao.
		int tempoTemp=0;
		log.println("\nResumindo:");
		log.println();
		if(Memoria.tipo == 1)
			log.println("ID, T.Chegada, Prioridade, Qnt.Paginas,T.Espera CPU,T.finalizado");
		else
			log.println("ID, T.Chegada, Prioridade,Tamanho(KB),T.Espera CPU,T.finalizado");
		for(int i=0;i<jobtable.length;i++){
			for(int j=0;j<jobtable[0].length;j++){
				if(j != 2){
					if(j == 3){
						log.printf("  ");
					}else if(j == 4)
						log.printf("\t");
					else if(j == 5)
						log.printf("        ");
					log.printf(Integer.toString(jobtable[i][j])+"\t");
				}
			}
			log.println();
			tempoTemp += jobtable[i][5];
		}
		log.println();
		log.println("Tempo medio de espera = "+(tempoTemp/jobtable.length));
	}
}