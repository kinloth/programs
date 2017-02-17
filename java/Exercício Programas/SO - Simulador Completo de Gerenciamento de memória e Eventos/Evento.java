import java.util.LinkedList;

public class Evento extends Estrutura {

	private int ID;
	/* ID = 1 > evento "inciailizacao" 
	 * ID = 2 > evento "requisitando memoria" 
	 * ID = 3 > evento "requisitando processador" 
	 * ID = 4 > evento "saida da CPU para a finalizacao"
	 *  */
	private int time;
	private int processo;											//numero do processo correspondente
	public Evento(int ID, int time, int processo) {
		this.ID = ID;
		this.time = time;
		this.processo = processo;
	}
	public int getID() {
		return ID;
	}
	public int getTime() {
		return time;
	}
	public int getProcesso() {
		return processo;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void executa() {											//realiza a rotina padrao do evento.
		if (ID == 1)
			inicio();												//inicializacao do processo.
		else if (ID == 2)
			requisitaCM();											//requisitando a Memoria Central.
		else if (ID == 3)
			requisitaCPU();											//requisitando a CPU.
		else if (ID == 4)
			escalonador(Estrutura.escalonador);						//a depender do escalonador.
		else{
			finalizacaoPadrao();									//finalizacao comum entre os escalonadores.
		}
		escreve("-------------------------------------------");
	}

	public void inicio() {											//inicia o processo ficticiamente.
		escreve("Processo " + processo + " inicializado.");
		escreve("(Proximo evento sera : Requisitando CM).");
		setID(2);
		lista.add(this);
	}

	public void requisitaCM() {										//requisita e da a memoria central ficticiamente para o processo.
		int processoM = jobtable[processo-1][4]/Memoria.frame;
		if(jobtable[processo-1][4]%Memoria.frame > 1) processoM++;
		if(Memoria.tipo == 1){
			escreve("Processo " + processo + " (de "+processoM+" paginas) esta requisitando a CM...");	
			escreve("Atualmente tem "+Memoria.pagLivres+ " quadros livres.");
		}else{
			escreve("Processo " + processo + " (de "+processoM+"KB) esta requisitando a CM...");	
			escreve("Atualmente tem "+Memoria.pagLivres+ "KB livres.");
		}
			
		if(Memoria.requisita(processo, this)){
			setID(3);
			escreve("Processo " + processo + " recebeu memoria central!");
			escreve("(Proximo evento sera : Requisitando CPU).");
			lista.add(this);
		}
		else{
			escreve("Nao ha espaco na CM para esse processo!");
			escreve("Foi inserido na fila da CM.");
		}
	}
	public void requisitaCPU() {									//requisita e da a CPU ou nao a depender da disponibilidade da mesma e do escalonador.
		Escalonador esc = new Escalonador();	
		escreve("Processo " + processo+ " esta requisitando a CPU...");
		if (CPUlivre == true) {										//se a CPU estiver livre ele concede-a livremente.
			CPUlivre = false;
			setID(4);
			lista.add(this);
			escreve("CPU livre esta livre. O Processo esta sendo executado.");
			escreve("(Proximo evento sera : Finalizar execucao por termino).");

		} else if(CPUlivre == false && Estrutura.escalonador == 3){	//caso ela esteja ocupada e o escalonador for SJFPreemptivo.
			esc.SJFPreempitivoEntrada(this);			
		}else if(CPUlivre == false && Estrutura.escalonador == 5){	//caso ela esteja ocupada e o escalonador seja MF Prioridade.
			if(jobtable[processo-1][3] <= prioridade1){
				CPU.add(this);
			}else if(jobtable[processo-1][3] <= prioridade2){
				lista1.add(this);
			}else{
				lista2.add(this);
			}			
		}else{														//se nao for nenhuma dessas opcoes ele adiciona normalmente a fila de espera da CPU.
			escreve("CPU esta ocupada, processo foi adicionado na fila de espera da CPU.");
			CPU.add(this);
		}
	}

	public void escalonador(int esc) {								//controla os processos a partir de um escalonador.
		Escalonador escalonador = new Escalonador();
		switch (esc) {
		case 1:
				escalonador.FCFS(processo);
				finalizacaoPadrao();
			break;
		case 2:
			escalonador.SJFPreemptivo(processo);
			break;
		case 3:
			escalonador.SJFPreemptivo(processo);
			break;
		case 4:
			if(escalonador.RoundRobin(processo))
				finalizacaoPadrao();				
			else
				Preempta(this);												//eh para preemptar o processo.
			break;
		case 5:
			if(escalonador.MultiplasFilasPrioridade(processo)){}
			else
				Preempta(this);												//idem.
			break;
		case 6:
			if(escalonador.MultiplasFilasFeedback(processo)){}
			else
				Preempta(this);												//idem.
			break;
		}
	}

	public void finalizacaoPadrao() {										//finaliza o processo de modo padrao entre os escalonadores.
		escreve("Liberando a CPU...CPU liberada.");
		CPUlivre = true;						
		escreve("Retirando entrada da jobtable...Entrada retirada.");
		numeroProcessos--;													//reduz o contador de processos.
		if (!CPU.isEmpty())													//se a fila de espera para a CPU nao estiver vazia.
			lista.addFirst(CPU.pop());										//retira o primeiro elemento dessa fila e adiciona a lista de eventos. 
		escreve("> Processo "+processo+" finalizado! <" );
	}
}