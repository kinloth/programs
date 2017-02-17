#include <stdio.h>
#include <math.h>

//#include "estrutura.h"
//#include "estrutura.c"

void FilaAdd(Fila *f, Vertice *v, bool final)
{
     if(v == NULL) return;
     No * novo = (No*) malloc (sizeof (No));
     novo->vertice = v;
     
     No * aux = f->inicio;
     if(aux == NULL)
     {
            novo->prox = NULL;
            f->inicio = novo;
            
            
     }else if(final)
     {
                     while(aux->prox != NULL)
                     {
                                     aux = aux->prox;                        
                     }
                     novo->prox = NULL;
                     aux->prox = novo;
                     
     }else{
           novo->prox = f->inicio;
           f->inicio = novo;
     }
}

void FilaExc(Fila *f, Vertice *v, bool totalmente)
{
                       No * atual = f->inicio;
                       No * ant = NULL;
                       if(atual == NULL || v == NULL || v->id<1 || v->id>10000)
                       {
                                return;
                       }                       
                       while(atual)
                       {
                                 if(atual->vertice->id == v->id) break;
                                 ant = atual;
                                 atual = atual->prox;
                       }
                       if(ant)
                       {
                             ant->prox = atual->prox;                  
                       }else
                       {
                            f->inicio =  atual->prox;
                       }
                       if(totalmente){
                         atual->vertice = NULL;                                 
                         free(atual);                                    
                       }                                      
}


void Exploud(Fila *f){
     No * aux = NULL;
     while(f->inicio){
                f->inicio->vertice->visto = false;
                aux = f->inicio;
                f->inicio = f->inicio->prox;
                
                free(aux);
     }
}


