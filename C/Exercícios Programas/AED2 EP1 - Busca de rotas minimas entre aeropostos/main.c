#include <stdio.h>
#include <math.h>
#include <malloc.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include <stdbool.h>

#include "geodist.h"
#include "estrutura.h"

//MARCELO GAIOSO WERNECK
//NUSP = 8061963


void relaxa(Vertice * ini, Aresta * are, Vertice * fim){
        if(fim->distancia > (are->distancia + ini->distancia)){
                       fim->distancia = are->distancia + ini->distancia;
                       fim->ant = ini;
     }
    
}

void Dijkstra(Grafo *g, Vertice *vOrigem, Vertice* vDestino,Fila * fila){
     vOrigem->distancia = 0;
     vOrigem->ant = NULL;
     FilaAdd(fila, vOrigem, false);
     Aresta *are = NULL;
     No *atual = fila->inicio;

     
     while(atual){
                  are = atual->vertice->arestas;
                  while(are){
                             relaxa(atual->vertice, are, are->destino);
                             if(are->destino->visto == false){
                                                    FilaAdd(fila, are->destino, false);
                             }    
                             are->destino->visto = true;
                             are = are->prox;
                             
                  }
                  FilaExc(fila, atual->vertice, true);
                  atual = retornaMenor(fila);

     }
     
 
     Exploud(fila);
     FilaAdd(fila, vDestino,false);
     Vertice * antecessor = vDestino->ant;
     while(antecessor){
                FilaAdd(fila,antecessor, false);
                antecessor = antecessor->ant;
     }
     
     if(fila->inicio->prox == NULL)
                            Exploud(fila);
}


void BuscaLargura(Grafo  *g, Vertice *vOrigem, Vertice *vDestino, Fila *fila)
{
     vOrigem->ant = NULL;
     vOrigem->visto = true;
     if(vOrigem->cod != vDestino->cod){
      Aresta * are = NULL;
      Exploud(fila);
      FilaAdd(fila, vOrigem, false);                      //adiciona o vertice origem
      No * atual = fila->inicio;
      printf("no primeiro dij...");
    system("PAUSE");
     
      while(atual)                                               //enquanto atual existir
      {                                                                       
                 are = atual->vertice->arestas;
                 atual->vertice->visto = true;                             
                 FilaExc(fila, atual->vertice,false);  

                 while(are)                                      
                 {                       
                          if(are->destino->visto == false){
                                               are->destino->visto = true;
                                               are->destino->ant = atual->vertice;
                                               
                                               FilaAdd(fila, are->destino, true);                                                   
                           }
                           if(are->destino == vDestino){

                                               Exploud(fila);
                                               FilaAdd(fila, vDestino,false);

                                               Vertice * antecessor = vDestino->ant;
                                               while(antecessor){
                                                     FilaAdd(fila,antecessor, false);
                                                     antecessor = antecessor->ant;
                                               }
                                               
                                               return;                                    
                           }
                           are = are->prox;
                 }
                 atual = fila->inicio;
      }
      }
      return;
}

int main(){
    const double earth_radius=  6371.009;
    const int nVertices = 9097;
    
    char line[100];
    char aux[20]; 
    
    FILE * entrada = fopen("entrada.txt","r");
    Grafo * g =  CriaGrafo(nVertices);
    PegaLinha(aux, entrada);
    FILE * air = fopen(aux,"r");      
         
          while ((fscanf(air, "%[^\n]", line)) != EOF)
         {
          fscanf(air, "%[^\n]", line);
          fgetc(air);   
          AddVertice(g, line); 
          }
      
    PegaLinha(aux, entrada);
    FILE *rot = fopen(aux,"r");
    
        while ((fscanf(rot, "%[^\n]", line)) != EOF)
        {
        fscanf(rot, "%[^\n]", line);
        fgetc(rot);   
        AddAresta(g, line, earth_radius);
        }  
    
   
    char tipo[10];
    PegaLinha(tipo, entrada);
    PegaLinha(aux, entrada);
    Vertice * vOrigem = AchaVertice(g, aux, nVertices);
    
    FILE * saida = fopen("saida.txt", "w");
    printf("comecando...");
    system("PAUSE");
    
   if(strcmp(tipo,"ESCALAS") == 0)        fprintf(saida, "%s %s %d %d\n",aux,"ESCALAS", g->Nver,  g->Nar);
   else if(strcmp(tipo,"DISTANCIA") == 0) fprintf(saida, "%s %s %d %d\n",aux,"DISTANCIA ", g->Nver,  g->Nar);
   else {
        printf("Coloque ESCALAS ou DISTANCIA\n");
        system("PAUSE");
        return;
   }
   
    fprintf(saida, "#O Grafo possui %d vertices e %d arestas.\n\n",g->Nver,g->Nar);

    PegaLinha(aux, entrada);
    int vezes = atoi(aux);
     
    Fila * fila = CriaFila();
    
int i;
for(i = 0; i<vezes; i++){
      
    Exploud(fila);
    GrafoIni(g,nVertices);
    
    PegaLinha(aux, entrada);
    fprintf(saida, "%s ", aux);
   
    Vertice * vDestino = AchaVertice(g, aux, nVertices);
    if(vDestino == NULL || vOrigem == NULL){  
               fprintf(saida, "NAO EXISTE\n");                 
               fprintf(saida, "#Rota nao pode ser encontrada, um dos aeroportos nao existe!\n\n");
               continue;
    }
    
    FilaAdd(fila,vDestino,true);   
   
    if(strcmp(tipo,"ESCALAS") == 0) BuscaLargura(g, vOrigem,vDestino, fila);
    else                            Dijkstra(g, vOrigem,vDestino,fila);

    if(fila->inicio == NULL){
              fprintf(saida, "NAO EXISTE\n");      
              fprintf(saida, "#Rota nao pode ser encontrada, nao existem caminhos.\n\n");
              continue;      
    }
  
    
    fprintf(saida, "%s ", aux);
    No * atual = fila->inicio;
    
    int quant = 1;
    int distancia = 0;
    Aresta * are = NULL;

    while(atual)    
    {
                 if(atual->prox == NULL) break;                 
                 are = atual->vertice->arestas;
                 quant++;
                 while(are->destino->id!= atual->prox->vertice->id){
                                          are = are->prox;  
                 }

                if(are != NULL) distancia += are->distancia;
                atual = atual->prox;
    }
   
   
    fprintf(saida,"%d %d ",quant, distancia);
    atual = fila->inicio;
    while(atual){
                 fprintf(saida, "%s ", atual->vertice->cod);
                 atual = atual->prox;
    }        
    fprintf(saida,"\n#A rota mais curta passa por %d aeroportos e percorre %d km\n\n",quant, distancia);
    
    }
    fclose(air);
    printf("terminou...");
    system("PAUSE");
                  return 1;
}
