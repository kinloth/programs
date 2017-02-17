#include <stdio.h>
#include <stdlib.h>

// nome = Marcelo Gaioso Werneck
// numero UPS = 8061963

typedef struct Vertice{

    int id;	
    char city[20];
    char country[20];
    char cod[10];
    double latitude;
    double longitude;
    int distancia;
    bool visto;
    
    struct Vertice * ant;
    struct ArestaStruct * arestas;
    
} Vertice;

typedef struct ArestaStruct{
        
        Vertice *destino;
        int  distancia;
        struct ArestaStruct * prox; 
        
} Aresta;

typedef struct Grafo{

	Vertice * vertices;
    int Nver;
    int Nar;
    
} Grafo;

typedef struct No{
        Vertice * vertice;
        struct No * prox;       
}No;

typedef struct Fila{
        No * inicio;                
} Fila;

Fila * CriaFila();
void Exploud(Fila *f);
Grafo * CriaGrafo(int NMaxVertices);
void GrafoIni(Grafo * g, int i);
void FilaAdd(Fila *f, Vertice *v, bool final);
void FilaExc(Fila *f, Vertice *v, bool totalmente);
void FilaImprimir(Fila * f, bool cod);
bool VerificaAresta(Grafo *g, int idOrigem, int idDestino);
void AddVertice(Grafo *g, char * line);
void AddAresta(Grafo *g, char *linha, double earth_radius);
Vertice * AchaVertice(Grafo * g, char * cod, int nVertices);
void PegaLinha(char* aux, FILE *f);
No * retornaMenor(Fila *fila);
