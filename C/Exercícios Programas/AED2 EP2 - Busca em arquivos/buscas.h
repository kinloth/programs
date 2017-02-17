#define BUFFER 2000
#define BLOCK_SIZE 4096
#define RECORDS_PER_BLOCK (BLOCK_SIZE/sizeof(Registro))

/***************************************************** 
** ACH2024 - Algoritmos e Estruturas de Dados II ** 
** 2o Semestre de 2013 ** 
** Turma 02 ** 
** Prof. Flavio Luiz Coutinho ** 
** Felipe Brigatto - No USP: 7972602 ** 
** Marcelo Werneck - No USP: 8061963 ** 
** José Roberto    - No USP: 7972290 **
** Igor Borges     - No USP: 8122442 **
*****************************************************/
#include "create_data.h"


void busca_seq(char* entrada, int n_blocos, int id, FILE * saida);
void busca_bin(char *entrada, int n_blocos, int id, FILE*saida);

void busca_indice(char *entrada, int n_blocos, int id, FILE* saida, char* topo, char* base);
Registro dense_search(int posicao, int id, char * file_name, char * base_name, int* n);
EntradaIndice sparse_search(int number_of_blocks, int id, char * file_name, int* n);
//incluir aqui os metodos adicionais no buscas.c

