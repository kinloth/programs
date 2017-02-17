#include "listas.h"

// crie neste arquivo as funcoes solicitadas e todas as demais rotinas necessarias para sua execucao
// tendo em mente que apenas o que esta implementado neste arquivo sera testado para fins de avaliacao
// do seu trabalho. Nao modifique as assinaturas destas funcoes, nem o conteudo de listas.h, ou seu
// programa nao passara nos testes.

char *aluno1()  { return ("Felipe Brigatto"); } // escreva aqui o seu nome 
char *nrousp1() { return ("7972602"); }      // escreva aqui o seu nro USP 
char *aluno2()  { return ("Marcelo Gaioso Werneck"); } // escreva aqui o seu nome 
char *nrousp2() { return ("8061963"); }      // escreva aqui o seu nro USP 
char *turma() {return("02");}

// NAO ALTERE ESTA FUNCAO - uso:   NO *p = criar();
NO *criar() {
    NO *aux = (NO*) malloc(sizeof(NO));
    return(aux);
}

// NAO ALTERE ESTA FUNCAO - uso: destruir(p);
void destruir(NO *p) {
     free(p);
}

NO* ElementoExc(NO **inicio, NO **ant, int k){                                  //a lista nao tem como estar vazia, testado anteriormente;
	NO*	p = *inicio;										
	NO* aux = *inicio;
	if(aux){
		int i;
		for(i=0 ; i < k; i++)
		{
			aux = aux->prox;
			if(aux == NULL && i<(k-1))	{			
				return (NULL);				                                    //retorna nulo, pois nao existe o elemento que deseja excluir
			}
		}
		while(aux)									                           	//até o final da lista... e se esta nao estiver no final;
		{
			aux = aux->prox;
			*ant = p; 
			p = p->prox;			
		}
		return (p);										                        //retorna o ponteiro p, que deverá ser excluido.
	}	
}

// O EP CONSISTE EM IMPLEMENTAR ESTA FUNCAO
void removerK(NO **inicio, int k) {
    // implemente a exclusao do K-esimo elemento aqui
    // usando as funcoes criar e destruir se necessario.
    // Nao esqueca de atualizar *inicio apos a exclusao
    // e percorrer a lista resultante em main() para ter
    // certeza de que funciona. 
         if(*inicio == NULL) 
     {
                //printf("lista vazia");
                return;                                                         //lista encontra-se vazia
     }
	NO* ant = NULL;                                                             //anterior ao elemento que deseja excluir;
 	NO* p = ElementoExc(inicio, &ant, k);                                       //elemento da k-esima posicao;
	if(p == *inicio && p != NULL){
        *inicio = p->prox;	
		destruir(p);
	}
	else if (p != NULL){
		ant->prox = p->prox;										
		destruir(p);
	}
}
