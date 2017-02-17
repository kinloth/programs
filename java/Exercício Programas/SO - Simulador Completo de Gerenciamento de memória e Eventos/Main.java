public class Main extends Estrutura {								//main do simulador.

	public static void main(String[] args) {	
		Grafica.main(args);
	}		

	public static void Agendador() {								//metodo que remove eventos da lista e chama a rotina de eventos.
		Evento evento = lista.removeFirst();
		evento.executa();										 	// rotina de evento
	}
	
	public static void Executa(){
		
		Arquivo arq = new Arquivo();								//utilizado para a leitura de arquivos.
		CriaJobTable(arq.criarLeitura());							//cria a tabela de processos.
		inicializaLog();	
		Memoria.inicializarVetores();
		
		escreve("Inicio do log.");
		if(escalonador == 1)	   log.println("Ultilizando First Come First Served.");
		else if(escalonador == 2)  log.println("Ultilizando Shorted Job First Nao Preemptivo.");
		else if(escalonador == 3)  log.println("Ultilizando Shorted Job First Preemptivo.");
		else if(escalonador == 4)  log.println("Ultilizando Round Robin.      Com Quantum = "+quantum+".");
		else if(escalonador == 5){ log.println("Ultilizando Multiplas Filas (com Round Robin).   ");
		log.println(	"Com Quantum = "+quantum+". ; Prioridade1 = "+prioridade1+" ; Prioridade2 = "+prioridade2+".");}
		else if(escalonador == 6){ log.println("Ultilizando Multiplas Filas (com Round Robin) - Feedback.  ");
		log.println(	"Com Quantum 1 = "+quantum+". ; Quantum 2 = "+quantum2+".");}
		if(Memoria.tipo == 0){
			log.println("--Segmentacao Best-fit - Com memoria de "+Memoria.memoTotal+"KB");
		}else
			log.println("--Paginacao - Com memoria de "+Memoria.memoTotal+"KB e Frame de "+Memoria.frame+"KB.");
		log.println("");
		
		while (numeroProcessos > 0) {									//enquanto houver processos...
			escreve("Tempo "+tempoGeral);
			escreve("");
			CriaListaEventos(jobtable);			
				
			if(lista.isEmpty()){										//se a lista de eventos estiver vazia...
				if(numeroProcessos != jobtable.length)
					break;				
				escreve("Lista de eventos e de CPU vazia, aguardando novo evento...");
			}else														//se a lista de eventos nao estiver vazia.
				Agendador();											//chama o metodo agendador.
			tempoGeral++;												//incrementa +1 em um tempo geral.
			if(tempoGeral > 3000)										//caso seja muito grande o arquivo de entrada, alterar esse valor.
				System.exit(0);										
		}
		finalizaLog();
		escreve("");
		escreve("Termino do Programa.");
		log.close();
		
	}
}
