#include <stdio.h>
#include <math.h>
#include <malloc.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <stdbool.h>

#define MAXIMUN INT_MAX
#include "estrutura.h"
#include "geodist.h"

Fila * CriaFila(){
     Fila * f = (Fila *) malloc (sizeof(Fila));
     f->inicio = NULL;
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

Grafo * CriaGrafo(int NMaxVertices){
      Grafo * g = (Grafo *) malloc (sizeof (Grafo)); 
      g->vertices = (Vertice *) malloc (NMaxVertices * sizeof(Vertice));
      g->Nver = 0;
      g->Nar = 0;      
}
  
void GrafoIni(Grafo * g, int i){
     int x;
     for(x=0;x<i;x++)
                           g->vertices[x].visto = false;                           
}
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

void FilaImprimir(Fila * f, bool cod){
     No * atual = f->inicio;
     while(atual){
                  if(cod){
                          printf("%s -- ",atual->vertice->cod);
                        
                  }else
                          printf("%d -- ",atual->vertice->id);
                  atual = atual->prox;
     }
     printf("Fim<\n\n");
}

bool VerificaAresta(Grafo *g, int idOrigem, int idDestino){
     if(g->vertices[idOrigem].id < 0 || g->vertices[idOrigem].cod == NULL)    return true;
     int achou = 0;
     Vertice *u = &g->vertices[idOrigem]; 
     Aresta *a = u->arestas;     
     while(a && (achou == 0)){
                     if(a->destino->id == idDestino){
                                       achou = 1; 
                                       return true;
                                       break;               
                     }
                     a = a->prox;
     }
     if(achou == 0)
            return false;
}


void AddVertice(Grafo *g, char * line){
     
     int i;
     bool ativo = false;
     char * delim = "*,";
     for(i= 0; i <  strlen(line) ; i++)
            if(line[i] == '"')
                       line[i] = '*';
            else if(line[i] == ',' && line[i+1] == ' '){
                  line[i] = '@';
                  ativo = true;
            }
     
     int id = atoi(strtok(line, ",*"));
     g->vertices[id].id = id;

     strtok(NULL, delim);

     strcpy(g->vertices[id].city,strtok(NULL, delim));
     strcpy(g->vertices[id].country,strtok(NULL, delim));
     strcpy(g->vertices[id].cod,strtok(NULL, delim));
  
     strtok(NULL, delim);
     if(strlen(g->vertices[id].cod) != 3){                           //serve para tratar o caso de cod ser nulo.
                            g->vertices[id].id = -1;
                            return;        
     }
    
     g->vertices[id].latitude = strtod(strtok(NULL, delim), NULL);
     g->vertices[id].longitude = strtod(strtok(NULL, delim), NULL);
     
     g->vertices[id].arestas = NULL;
     g->vertices[id].distancia = MAXIMUN;
     g->vertices[id].ant = NULL;
     g->Nver++;

     if(ativo)
               for(i = 0; i < strlen(g->vertices[id].city); i++)
                     if(g->vertices[id].city[i] == '@') 
                                 g->vertices[id].city[i] = ',';
}

void AddAresta(Grafo *g, char *linha, double earth_radius){
     
          
   char * delim = ",";  
    strtok(linha,delim);
    strtok(NULL,delim);
    strtok(NULL,delim); 

    int idOrigem = atoi(strtok(NULL,delim));                //ids = idorigem
    strtok(NULL,delim);    
   int idDestino = atoi(strtok(NULL,delim));  
      
    if(g->vertices[idOrigem].id < 1 || g->vertices[idDestino].id < 1)
             return;
                 
    if(VerificaAresta(g, idOrigem, idDestino))
             return;
    else
    {
          Aresta *a = (Aresta *) malloc (sizeof(Aresta));
          Vertice *u = &g->vertices[idOrigem];
          Vertice *v = &g->vertices[idDestino];
     
          a->destino = v; 
          a->prox = u->arestas; 
          a->distancia =  distance(coordinate(v->latitude, v->longitude), coordinate(u->latitude,u->longitude), earth_radius);
          g->vertices[idOrigem].arestas = a;
          g->Nar++;
   
     }
}    

Vertice * AchaVertice(Grafo * g, char * cod, int nVertices){
        int i;
        char * codaux;
        for(i = 0; i < nVertices; i++){
             if(g->vertices[i].id != -1){
                      codaux = g->vertices[i].cod;
                      if(strcmp(codaux, cod) == 0){
                                        return &g->vertices[i];
                      }
             } 
        }
        printf("Nao tem vertice com esse cod\n");
        return NULL;
}



void PegaLinha(char* aux, FILE *f){
    fgets(aux, 20, f);
    if(strlen(aux) > 3)
                   aux[strlen(aux)-1] =0;
}

No * retornaMenor(Fila *fila){
   int menor = MAXIMUN;
   No * aux = NULL;
   No * atual = fila->inicio;
   while(atual){
                if(atual->vertice->distancia < menor){
                                             menor = atual->vertice->distancia;
                                             aux = atual;
                }
                atual = atual->prox;
   }
   return aux;
}
