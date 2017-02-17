#include "arvore.h"

//====================================================================
int main() {

    NO *raiz = NULL;
    int ch, max;
    
    // use esta area para inserir elementos em *raiz e testar seu EP

    // o EP será testado como no laco abaixo
    for(int i=1;i<=5;i++) {

         // crie valores de teste para int ch e int max aqui

         excluirSubarvores(&raiz, ch, max);
         
    }

    getch();
} // end main
