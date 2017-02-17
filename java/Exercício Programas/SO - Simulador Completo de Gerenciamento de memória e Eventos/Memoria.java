import java.util.LinkedList;

public class Memoria extends Estrutura{

	static int memoTotal = 36;
	static int frame = 8;
	static final LinkedList<Evento> Mem = new LinkedList<Evento>();		//lista de eventos em espera para a CM.
	static int memoFisica[];
	static int tabelaPagina[];
	static int pagLivres = 0;
	static int tipo = 1;
	/* 0 = best-fit
	 * 1 = paginacao
	 * */
	
	static void inicializarVetores(){
		if(tipo == 0)
			frame = 1;
			pagLivres = memoTotal/frame;
			tabelaPagina = memoFisica = new int[pagLivres];
			for(int i=0; i<memoFisica.length;i++)
				tabelaPagina[i] = memoFisica[i] = -1;
	}
	
	static boolean requisita(int IDprocesso, Evento evento){

		System.out.println("processo "+IDprocesso);
		int paginas = jobtable[IDprocesso-1][4]/frame;
		if(jobtable[IDprocesso-1][4]%frame >= 1) paginas++;
		if(paginas > pagLivres){
			Mem.add(evento);
			return false;
		}
		int posicao = -1;
		if(tipo == 0){
			posicao = menorBuraco(tabelaPagina, paginas);
			if(posicao >= 0){
				pagLivres = pagLivres - paginas;			
				for(int i=posicao; i < posicao+paginas; i++){
					tabelaPagina[i] = IDprocesso;
				}
				return true;	
			}else{
				Mem.add(evento);
				return false;
			}
				
		}else{
			for(int i=0;i < tabelaPagina.length; i++){
				if(tabelaPagina[i] == -1){
					tabelaPagina[i] = IDprocesso;
					paginas--;
				}
				if(paginas == 0)
					break;
			}
			return true;
		}
	}
	
	
	static void libera(int IDprocesso){
		int paginas = jobtable[IDprocesso-1][4]/frame;
		if(jobtable[IDprocesso-1][4]%frame >= 1) paginas++;
	
		pagLivres += paginas;
		for(int i=0; i<tabelaPagina.length; i++){
			if(tabelaPagina[i] == IDprocesso)
				tabelaPagina[i] = -1;
		}
		jobtable[IDprocesso-1][4] = paginas;
		escreve("Liberando a CM...CM liberada.");
		if(!Mem.isEmpty()){
			for(Evento ev : Mem){
				if(jobtable[ev.getProcesso()-1][4]/frame <= pagLivres){
						lista.addFirst(ev);
						Mem.remove(ev);
						break;
				}						
			}
		}
	}
	
	static int menorBuraco(int[] vetor, int paginas){
		int menor=10000;
		int atual=0;
		for(int i=0; i<vetor.length;i++){
			if(vetor[i] == -1){
				atual++;
			}else{
				if(atual >= paginas)
					if(atual < menor)
						menor = atual;
				atual =0;
			}
		}
		if(atual >= paginas)
			if(atual < menor)
				menor = atual;
		
		if(paginas > menor){
			return -1;
		}else
			atual=0;
			for(int i=0; i<vetor.length;i++){
				if(vetor[i] == -1){
					atual++;
					if(atual == menor)
						return i-menor+1;
				}
			}			
		return -1;
	}
}
