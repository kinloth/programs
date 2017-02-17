public class Escalonador extends Estrutura{
	
	void FCFS(int IDprocesso){								//first come first served.
		
		escreve("------------->> Executando FCFS ***");
		escreve("...Executando processo "+IDprocesso+" na CPU.....");
		while(jobtable[IDprocesso-1][2] > 0){				//decrementa do burst ate a finalizacao do processo.
			jobtable[IDprocesso-1][2]--;			
			for(Evento ev : CPU)
				jobtable[ev.getProcesso()-1][5]++;
			tempoEspera++;
		}
		
		jobtable[IDprocesso-1][6] = tempoEspera;
		CPUlivre = true;
		Memoria.libera(IDprocesso);
	}	
	
	void SJFnaoPreemptivo(int IDprocesso){					//eh como o FSFC mas utiliza o ultiliza o tempo de burst como criterio
		
		escreve("------------->> Executando SJFNaoPreemptivo ***");			
		escreve("...Executando processo "+IDprocesso+" na CPU.....");
		while(jobtable[IDprocesso-1][2] > 0){			
			jobtable[IDprocesso-1][2]--;
			for(Evento ev : CPU)
				jobtable[ev.getProcesso()-1][5]++;
			tempoEspera++;
		}			
		jobtable[IDprocesso-1][6] = tempoEspera;
		escreve("Processo terminou a execução da CPU. Finalizando...");		
		escreve("Liberando a CPU...CPU liberada.");
		CPUlivre = true;
		Memoria.libera(IDprocesso);
		escreve("Retirando entrada da jobtable...Entrada retirada.");
		numeroProcessos--;											//finalizado oficialmente o processo.
		
		if (!CPU.isEmpty()){										//para determinar o proximo processo a utilizar a CPU.
			int menorTempo = jobtable[CPU.get(0).getProcesso()-1][2];
			for(Evento evento : CPU){				
				if(menorTempo > jobtable[evento.getProcesso()-1][2])
					menorTempo = jobtable[evento.getProcesso()-1][2];
			}
			for(int i=0;i<CPU.size();i++){
				if(menorTempo == jobtable[CPU.get(i).getProcesso()-1][2]){
					lista.addFirst(CPU.get(i));
					CPU.remove(i);
				}				
			}
			escreve("menorTempo = "+menorTempo);			//menor tempo de CPUBurst
		}
		escreve("> Processo  finalizado! <" );
	}
		
	
	void SJFPreempitivoEntrada(Evento evento){				//utilizado para realizar a preempcao por tempo de Burst do processo.
		Evento eventoCPU;
		for(int i=0;i<lista.size();i++){					//percorre a lista de espera para a CPU
			eventoCPU = lista.get(i);						//eventoCPU eh auxiliar para achar o evento especifico
			if(eventoCPU.getID() == 5){						//se este evento for oque estiver na CPU...
				if(jobtable[evento.getProcesso()-1][2] < jobtable[eventoCPU.getProcesso()-1][2]){			//se ele for menor do que estiver na CPU...
	
					CPU.add(eventoCPU);						//adiciona ele a lista de espera da CPU
					lista.remove(eventoCPU);				//remove o evento que ele estaria
					
					evento.setID(5);						//coloca o ID dele como o de finalizaçãp
					lista.add(evento);						//adiciona esse evento na lista de eventos
					escreve("Processo "+eventoCPU.getProcesso()+" foi preemptado e esta agora na lista da CPU.");
					escreve("Processo "+evento.getProcesso()+" tomou o controle da CPU.");
				}else										//se ele nao foi para a CPU
					CPU.add(evento);						//entao ele entra para a lista de esperar para a CPU
				break;										//uma vez que achou o evento do processo que esta na CPU, nao precisa mais percorrer
			}				
		}
	}	
	
	void SJFPreemptivo(int IDprocesso){						//uma vez q preempcao esta correta.
															//o processo restante eh igual ao do SJFnao preemptivo.
		this.SJFnaoPreemptivo(IDprocesso);
	}
	
	boolean RoundRobin(int IDprocesso){						//escalonador por fatias iguais de tempo(quantum).
		
		escreve("------------->> Executando RoundRobin ***");	
		escreve("...Executando processo "+IDprocesso+" na CPU.....");
		
		for(int j=0; j< quantum; j++){						//para cada quantum pre-estabelecido.
			jobtable[IDprocesso-1][2]--;					//decrementa no CPUBurst do processo.
			for(Evento ev : CPU)
				jobtable[ev.getProcesso()-1][5]++;
			tempoEspera++;
			if(jobtable[IDprocesso-1][2] == 0){				//eh porque terminou o processo no meio do quantum.
				escreve("O processo "+IDprocesso+" terminou sua execução na CPU. Finalizando...");
				jobtable[IDprocesso-1][6] = tempoEspera;
				Memoria.libera(IDprocesso);
				return true;								//retorna que nao ha necessidade de preemptacao. Foi finalizado.
			}				
		}		
		escreve("Processo "+IDprocesso+" foi preemptado pelo tempo estabelecido.");
		return false;										//retorna que nao foi finalizado, entao deve-se preemptar.
	}
	
	boolean MultiplasFilasPrioridade(int IDprocesso){										//metodo de escalonamento por multiplas filas pro prioridade.
		
		escreve("------------->> Executando MultiplasFilas - Prioridade ***");		
		escreve("...Executando processo "+IDprocesso+" na CPU.....");		
		for(int j=0; j< quantum;){															//como para cada fila o metodo é o RR, eh necessario o quantum.
			jobtable[IDprocesso-1][2]--;													//decrementa o burst.
			for(Evento ev : CPU)				jobtable[ev.getProcesso()-1][5]++;			//incrementa o tempo de espera dos processos nas 3 filas.
			for(Evento ev : lista1)				jobtable[ev.getProcesso()-1][5]++;
			for(Evento ev : lista2)				jobtable[ev.getProcesso()-1][5]++;
			tempoEspera++;
			if(jobtable[IDprocesso-1][2] == 0){												//terminou a execução do processo.
				escreve("O processo "+IDprocesso+" terminou sua execução na CPU. Finalizando...");				
				escreve("Liberando a CPU...CPU liberada.");
				CPUlivre = true;															//libera a CPU.
				Memoria.libera(IDprocesso);
				escreve("Retirando entrada da jobtable...Entrada retirada.");
				numeroProcessos--;
				adicionaPrimeiroFilas();													//certificar que somente os processos de filas 
																							//superiores executem antes que os de filas inferiores.
				
				escreve("> Processo "+IDprocesso+" finalizado! <" );
				jobtable[IDprocesso-1][6] = tempoEspera;
				return true;																//Processo foi finalizado, nao necessita de preempcao.
			}else{
				escreve("Processo "+IDprocesso+" foi preemptado pelo tempo estabelecido.");
				return false;																//Processo nao foi finalizado, necessita de preempcao.
			}			
		}
		return true;
	}
	
	boolean MultiplasFilasFeedback(int IDprocesso){											//metodo de multiplas filas, por feedback.
		int x = 0;
		escreve("------------->> Executando MultiplasFilas -  FeedBack ***");		
		escreve("...Executando processo "+IDprocesso+" na CPU.....");
		if(jobtable[IDprocesso-1][3] == 1)			x = quantum;							//esta da fila 0 de espera a CPU.
		else if(jobtable[IDprocesso-1][3] == 2)		x = quantum2;							//esta na fila 1 de espera a CPU.
		
		if(jobtable[IDprocesso-1][3] != 3)													//se ele nao estiver na ultima fila...
		for(int j=0; j< x;){																//eh necessario um quantum  para cada fila.
			jobtable[IDprocesso-1][2]--;													//decrementa o burst.
			for(Evento ev : CPU)				jobtable[ev.getProcesso()-1][5]++;			//incrementa o tempo de espera dos processos nas 3 filas.
			for(Evento ev : lista1)				jobtable[ev.getProcesso()-1][5]++;
			for(Evento ev : lista2)				jobtable[ev.getProcesso()-1][5]++;
			tempoEspera++;
			if(jobtable[IDprocesso-1][2] == 0){												//terminou a execução do processo.
				escreve("O processo "+IDprocesso+" terminou sua execução na CPU. Finalizando...");				
				escreve("Liberando a CPU...CPU liberada.");
				CPUlivre = true;															//libera a CPU.
				Memoria.libera(IDprocesso);
				escreve("Retirando entrada da jobtable...Entrada retirada.");
				numeroProcessos--;
				adicionaPrimeiroFilas();													//certificar que somente os processos de filas 
																							//superiores executem antes que os de filas inferiores.
				
				escreve("> Processo "+IDprocesso+" finalizado! <" );
				jobtable[IDprocesso-1][6] = tempoEspera;
				return true;																//Processo foi finalizado, nao necessita de preempcao.
			}else{
				escreve("Processo "+IDprocesso+" foi preemptado pelo tempo estabelecido.");
				return false;																//Processo nao foi finalizado, necessita de preempcao.
			}			
		}else{																				//FCFS para a ultima fila.
			while(jobtable[IDprocesso-1][2] > 0){	
				jobtable[IDprocesso-1][2]--;			
				for(Evento ev : lista2)
					jobtable[ev.getProcesso()-1][5]++;
				tempoEspera++;
			}
			escreve("O processo "+IDprocesso+" terminou sua execução na CPU. Finalizando...");				
			escreve("Liberando a CPU...CPU liberada.");
			CPUlivre = true;																//libera a CPU.
			Memoria.libera(IDprocesso);
			escreve("Retirando entrada da jobtable...Entrada retirada.");
			numeroProcessos--;
			adicionaPrimeiroFilas();
			return true;
		}	
		return true;
	}
}