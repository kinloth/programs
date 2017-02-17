#include "arvore.h"
// crie neste arquivo as funcoes solicitadas e todas as demais rotinas necessarias para sua execucao
// tendo em mente que apenas o que esta implementado neste arquivo sera avaliado.
// Nao modifique as assinaturas destas funcoes, nem o conteudo de arvore.h, ou seu programa nao passara nos testes.

char *aluno1()  { return ("mimimimi"); } // escreva aqui o seu nome 
char *nrousp1() { return ("xxxxxxx"); }      // escreva aqui o seu nro USP 
char *aluno2()  { return ("blablabla"); } // escreva aqui o seu nome 
char *nrousp2() { return ("-------"); }      // escreva aqui o seu nro USP 
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

// o EP consiste em implementar esta funcao
void excluirSubarvores(NO **raiz, int ch, int max) {
         // seu codigo aqui
         
         
         
}
