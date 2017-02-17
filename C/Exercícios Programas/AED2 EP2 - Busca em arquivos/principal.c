#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#include "buscas.h"

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

long calc_blocos(FILE * p){

  long size;
  if (p==NULL) perror ("Error opening file");
  else
  {
    fseek (p, 0, SEEK_END);   // non-portable
    size = ftell (p);
    return size/BLOCK_SIZE;
  }
}

void quicksort(Registro valor[], int esquerda, int direita){

    int i, j;
    Registro y;
    i = esquerda;
    j = direita;
    char ok[10];
    
    long x = valor[(esquerda + direita) / 2].id;
    while(i <= j){

        while(valor[i].id < x && i < direita){
            i++;
        }

        while(valor[j].id > x && j > esquerda){
            j--;
        }

        if(i <= j){
            y = valor[i];
            valor[i] = valor[j];
            valor[j] = y;
            i++;
            j--;
        }
    }

    if(j > esquerda){
        quicksort(valor, esquerda, j);
    }

    if(i < direita){
        quicksort(valor,  i, direita);
    }
}

void escreve_arquivo(char* filename, int number_of_blocks, Registro vetor_reg[]) {

	FILE* in = fopen(filename, "w");
	int i, j, atual = 0;
	char block_buffer[BLOCK_SIZE];

	for(i = 0; i < number_of_blocks; i++){
			
		for(j = 0; j < RECORDS_PER_BLOCK; j++){

			copy_record_to_block(&vetor_reg[atual], block_buffer, j);
			atual++;
		}
		write_block(in, block_buffer);
	}
	fclose(in);
}



void merge(char *filename1, char *filename2, char *saida){

	FILE * arq_tempA = fopen(filename1, "rb");
	FILE * arq_tempB = fopen(filename2, "rb");
	FILE * escrita = fopen(saida, "wb");

	char block1[BLOCK_SIZE];
	char block2[BLOCK_SIZE];
	char block_novo[BLOCK_SIZE];
	Registro reg1;
	Registro reg2;
	int  i, j, n;
	j = i = n = 0;

	if(read_block(arq_tempA, block1)){}
	else{
		printf("falha ao ler o primeiro bloco do primeiro arquivo!");
		getchar();
	}
	if(read_block(arq_tempB, block2)){}
	else{
		printf("falha ao ler o primeiro bloco do segudo arquivo!");
		getchar();
	}

	int blocosA = calc_blocos(arq_tempA);			//numero de blocos que tem no arquivo1
	int blocosB = calc_blocos(arq_tempB);			//numero de blocos que tem no arquivo2
	int a = blocosA+1;
	int b = blocosB+1;

	get_record_from_block(&reg1, block1, i);
	get_record_from_block(&reg2, block2, j);

	while(blocosA >= 0 && blocosB >= 0){						//enquanto houver blocos em A ou B
		
			if(n == 32){						//contator do bloco, se eh 32 eh pq jah tem um bloco inteiro
				write_block(escrita,block_novo);//escreve esse bloco no terceiro arquivo
				n = 0;
			}
			if(i == 32){
				fseek(arq_tempA, (a-blocosA)*BLOCK_SIZE, SEEK_SET);
				if(read_block(arq_tempA, block1)){}
				i = 0;			
				blocosA--;								//decrementa o contador de blocos do primeiro arquivo

			}
			if(j == 32){						//funciona da mesma forma que o anterior
				
				fseek(arq_tempB, (b-blocosB)*BLOCK_SIZE, SEEK_SET);
				if(read_block(arq_tempB, block2)){}
				j = 0;				
				blocosB--;
			}
		
			if(reg1.id <= reg2.id){
				copy_record_to_block(&reg1, block_novo, n);
				i++;
				get_record_from_block(&reg1, block1, i);

			}else{
				copy_record_to_block(&reg2, block_novo, n);
				j++;
				get_record_from_block(&reg2, block2, j);					
			}
			n++;

			if(blocosA == 0 && blocosB >= 0){

				while(blocosB >= 0){
					if(j == BUFFER){
						fseek(arq_tempB, (b-blocosB)*BLOCK_SIZE, SEEK_SET);
						if(read_block(arq_tempB, block1)){}
						j = 0;
						blocosB--;
					}
					if(n == 32){
						write_block(escrita,block_novo);
						n = 0;
					}
					get_record_from_block(&reg2, block2, j);
					copy_record_to_block(&reg2, block_novo, n);
					j++;
										
				}
				printf(". ");
				write_block(escrita,block_novo);
				fclose(arq_tempA);
				fclose(arq_tempB);
				fclose(escrita);
				return;

			}else if(blocosB == 0 && blocosA >= 0){

				while(blocosA >= 0){
					if(i == BUFFER){
						fseek(arq_tempA, (a-blocosA)*BLOCK_SIZE, SEEK_SET);
						if(read_block(arq_tempA, block1)){}
						i = 0;						
						blocosA--;
					}
					if(n == 32){
						write_block(escrita,block_novo);
						n = 0;
					}
					get_record_from_block(&reg1, block1, i);
					copy_record_to_block(&reg1, block_novo, n);
					i++;
										
				}
				write_block(escrita, block_novo);
				printf(". ");
				fclose(arq_tempA);
				fclose(arq_tempB);
				fclose(escrita);
				return;
			}	
	}
	write_block(escrita, block_novo);
	fclose(arq_tempA);
	fclose(arq_tempB);
	fclose(escrita);
	return;

}


void ordena(char *entrada, int N_BLOCOS, char*saida){

	printf("iniciando ordenação\n");
	int i, j, n, atual, contador, w = 0;
	char block_buffer[BLOCK_SIZE];
	Registro r;
	FILE * in = fopen(entrada, "rb");
	Registro vetor_reg[(BUFFER*RECORDS_PER_BLOCK)+1];	

	//--criando os arquivos necessários
		int numfiles = N_BLOCOS/BUFFER;
		if(numfiles == 0) numfiles == 1;
		FILE* files[numfiles];
		char* nomes[numfiles+1][20];

		for (i = 0; i < numfiles; i++) { 
			char filename[20]; 
			sprintf(filename, "arq_temp%d.bin", i);			
			strcpy(nomes[i], filename);
		}
	
	//--arquivos criados!
	printf("começo\n");
	
	for(i = 0; i < N_BLOCOS; i++){

		if(read_block(in, block_buffer)){

			if(contador == BUFFER+1){
					fclose(in);
					in = fopen(entrada, "rb");
					fseek(in, i*BLOCK_SIZE, SEEK_SET);
					atual =	contador = 0;

				quicksort(vetor_reg, 0 , (BUFFER*RECORDS_PER_BLOCK)+1);
				escreve_arquivoIndex(nomes[w],BUFFER+1, vetor_reg);
				w++;
			
			}
			for(j = 0; j < RECORDS_PER_BLOCK; j++){
				get_record_from_block(&vetor_reg[atual], block_buffer, j);
				atual++;
			}			
			contador++;
		}
	}


	quicksort(vetor_reg, 0, atual);
	escreve_arquivoIndex(nomes[w], BUFFER ,vetor_reg);
	i = atual = 1;
	char* aux = "aux.bin";
	char* aux2 = nomes[0];
	char* aux3;

	printf("merge.\n");
	while(numfiles > 1){
		printf(" ");
		merge(aux2, nomes[i], aux);
		aux3 = aux;
		aux = aux2;
		aux2 = aux3;
		remove(nomes[i]);
		i++;
		numfiles--;

	}

	remove(aux);
	rename(aux2, saida);
	printf("\nterminou!\n");
}
void quicksortIndex(EntradaIndice valor[], int esquerda, int direita){

    int i, j;
   	EntradaIndice y;
    i = esquerda;
    j = direita;
    char ok[10];
    
    long x = valor[(esquerda + direita) / 2].id;
    while(i <= j){

        while(valor[i].id < x && i < direita){
            i++;
        }

        while(valor[j].id > x && j > esquerda){
            j--;
        }

        if(i <= j){
            y = valor[i];
            valor[i] = valor[j];
            valor[j] = y;
            i++;
            j--;
        }
    }

    if(j > esquerda){
        quicksortIndex(valor, esquerda, j);
    }

    if(i < direita){
        quicksortIndex(valor,  i, direita);
    }
}
void escreve_arquivoIndex(char* filename, int number_of_blocks, EntradaIndice vetor_reg[]) {

	FILE* in = fopen(filename, "w");
	int i, j, atual = 0;
	char block_buffer[BLOCK_SIZE];

	for(i = 0; i < number_of_blocks; i++){
			
		for(j = 0; j < INDEX_PER_BLOCK; j++){

			copy_index_to_block(&vetor_reg[atual], block_buffer, j);
			atual++;
		}
		write_block(in, block_buffer);
	}
	fclose(in);
}


void mergeIndice(char *filename1, char *filename2, char *saida){

	FILE * arq_tempA = fopen(filename1, "rb");
	FILE * arq_tempB = fopen(filename2, "rb");
	FILE * escrita = fopen(saida, "wb");

	char block1[BLOCK_SIZE];
	char block2[BLOCK_SIZE];
	char block_novo[BLOCK_SIZE];
	EntradaIndice ind1;
	EntradaIndice ind2;
	int  i, j, n;
	j = i = n = 0;
	printf("(merge!)\n");

	if(read_block(arq_tempA, block1)){}
	else{
		printf("falha ao ler o primeiro bloco do primeiro arquivo!");
		getchar();
	}
	if(read_block(arq_tempB, block2)){}
	else{
		printf("falha ao ler o primeiro bloco do segudo arquivo!");
		getchar();
	}

	int blocosA = calc_blocos(arq_tempA);			//numero de blocos que tem no arquivo1
	int blocosB = calc_blocos(arq_tempB);			//numero de blocos que tem no arquivo2
	int a = blocosA+1;
	int b = blocosB+1;

	get_index_from_block(&ind1, block1, i);
	get_index_from_block(&ind2, block2, j);

	while(blocosA >= 0 && blocosB >= 0){						//enquanto houver blocos em A ou B
		


			if(n == 32){						//contator do bloco, se eh 32 eh pq jah tem um bloco inteiro
				write_block(escrita,block_novo);//escreve esse bloco no terceiro arquivo
				n = 0;
			}
			if(i == 32){
				fseek(arq_tempA, (a-blocosA)*BLOCK_SIZE, SEEK_SET);
				if(read_block(arq_tempA, block1)){}
				i = 0;			
				blocosA--;								//decrementa o contador de blocos do primeiro arquivo

			}
			if(j == 32){						//funciona da mesma forma que o anterior
				fseek(arq_tempB, (b-blocosB)*BLOCK_SIZE, SEEK_SET);
				if(read_block(arq_tempB, block2)){}
				j = 0;				
				blocosB--;
			}
		
			get_index_from_block(&ind1, block1, i);
			get_index_from_block(&ind2, block2, j);

			if(ind1.id <= ind2.id){
				copy_index_to_block(&ind1, block_novo, n);
				i++;
			}else if(ind1.id > ind2.id){
				copy_index_to_block(&ind2, block_novo, n);
				j++;					
			}

			n++;
			if(blocosA == 0 && blocosB >= 0){
				getchar();
				while(blocosB >= 0){
					if(j == BUFFER){
						fseek(arq_tempB, (b-blocosB)*BLOCK_SIZE, SEEK_SET);
						if(read_block(arq_tempB, block1)){}
						j = 0;
						blocosB--;
					}
					if(n == 32){
						write_block(escrita,block_novo);
						n = 0;
					}
					get_index_from_block(&ind2, block2, j);
					copy_index_to_block(&ind2, block_novo, n);
					j++;
										
				}
				printf(". ");
				write_block(escrita,block_novo);
				fclose(arq_tempA);
				fclose(arq_tempB);
				fclose(escrita);
				return;

			}else if(blocosB == 0 && blocosA >= 0){
				getchar();
				while(blocosA >= 0){
					if(i == BUFFER){
						fseek(arq_tempA, (a-blocosA)*BLOCK_SIZE, SEEK_SET);
						if(read_block(arq_tempA, block1)){}
						i = 0;						
						blocosA--;
					}
					if(n == 32){
						write_block(escrita,block_novo);
						n = 0;
					}
					get_index_from_block(&ind1, block1, i);
					copy_index_to_block(&ind1, block_novo, n);
					i++;
										
				}
				write_block(escrita, block_novo);
				printf(". ");
				fclose(arq_tempA);
				fclose(arq_tempB);
				fclose(escrita);
				return;
			}	
	}
	write_block(escrita, block_novo);
	fclose(arq_tempA);
	fclose(arq_tempB);
	fclose(escrita);
	return;

}


void ordenaIndice(char *entrada, int N_BLOCOS, char *base_saida){

	printf("iniciando ordenação\n");
	int i, j, n, atual, contador, w = 0;
	char block_buffer[BLOCK_SIZE];
	EntradaIndice ind;
	FILE * in = fopen(entrada, "rb");
	EntradaIndice vetor_reg[(BUFFER*INDEX_PER_BLOCK)+1];	

	//--criando os arquivos necessários
		int numfiles = N_BLOCOS/BUFFER;
		if(numfiles == 0) numfiles == 1;
		FILE* files[numfiles];
		char* nomes[numfiles+1][20];

		for (i = 0; i <= numfiles; i++) { 
			char filename[20]; 
			sprintf(filename, "arq_temp%d.bin", i);			
			strcpy(nomes[i], filename);
		}
	
	//--arquivos criados!
	printf("começo\n");
	getchar();
	
	for(i = 0; i < N_BLOCOS; i++){

		if(read_block(in, block_buffer)){

			if(contador == BUFFER){
					fclose(in);
					in = fopen(entrada, "rb");
					fseek(in, i, SEEK_SET);
					atual =	contador = 0;

				printf("antes de ordenar\n");
				quicksortIndex(vetor_reg, 0 ,BUFFER*RECORDS_PER_BLOCK);
				printf("ordenado com sucesso!\n");
				escreve_arquivoIndex(nomes[w],BUFFER, vetor_reg);
				w++;
				printf("ordenado com sucesso e escrito no arquivo '%s'\n", nomes[w]);
				//getchar();
			
			}
			for(j = 0; j < INDEX_PER_BLOCK; j++){
				get_index_from_block(&vetor_reg[atual], block_buffer, j);
				atual++;
			}			
			contador++;
		}else
			getchar();

	}

	i = atual = 1;
	char* aux = "aux.bin";
	char* aux2 = nomes[0];
	char* aux3;

	printf("merge.\n");
	getchar();
	while(numfiles > 1){
		printf(" ");
		mergeIndice(aux2, nomes[i], aux);
		aux3 = aux;
		aux = aux2;
		aux2 = aux3;
		remove(nomes[i]);
		i++;
		numfiles--;

	}

	remove(aux);
	rename(aux2, base_saida);
	printf("\nterminou!\n");
}

void gera_indice(int n_blocks, char * entrada, char*topo_saida, char*base_saida){

	create_dense(n_blocks,entrada,base_saida);
	ordenaIndice(base_saida, n_blocks, base_saida);

	FILE * indice = fopen(base_saida, "rb");
	long qtd=calc_blocos(indice);
	fclose(indice);

	create_sparse(qtd,base_saida,topo_saida);
	printf("terminou de gerar o indice!\n");
}



int main(char **argv){

	srand(12);
	int id;
	char linha[100];
	char arquivos[20] = "";
	char tipo[20];	

	char registros[20];
	FILE* entrada;
	char topo_entrada[20];
	char base_entrada[20];
	FILE * config = fopen("config.txt", "r");

	fgets(tipo, 20, config); 							//pega blocosAprimeira linha do config: tipo de busca
	tipo[strlen(tipo)-1] =0;							//isso serve para tirar o \n do final da string
	printf("Tipo eh |%s|\n\n",tipo);


	//--tratamento dos arquivos de entrada
		fgets(linha, 100, config);				
		strcpy(arquivos, strtok(linha, ",\t \n;"));
		if(strlen(arquivos) > 2){
			 strcpy(registros,arquivos);	
			 entrada = fopen(registros, "rb");							//arquivo de entrada normal
			 printf("arquivo de entrada eh: |%s|\n",arquivos);
		}else{		 				 printf("sem arquivo de entrada especificado!"); 	return 0;}


		if(strcmp(tipo, "busca_indice") == 0){
			strcpy(arquivos, strtok(NULL, ",\t \n;"));
			strcpy(topo_entrada, arquivos);						//entrada topo
				printf("segundo arquivo de entrada eh |%s|\n", arquivos );

			strcpy(arquivos, strtok(NULL, ",\t \n"));			
			strcpy(base_entrada, arquivos);							//arquivo base
				printf("terceiro arquivo de entrada eh |%s|\n", arquivos);
		}

		const int N_BLOCOS = calc_blocos(entrada);
		fclose(entrada);
		
	//fim --entrada
   
	/*--tratamento dos arquivos de base_saida */
		char saida[20];
		fgets(linha, 100, config);
		strcpy(arquivos, strtok(linha, ",\t \n;"));
		if(strlen(arquivos) > 2){
			 strcpy(saida,arquivos);							//arquivo de saida normal
			 printf("\narquivo de saida deve ser |%s|\n",arquivos);
		}else{		printf("sem arquivo de saida especificado!"); 	return 0;}

		if(strcmp(tipo, "gera_indice") == 0){
			strcpy(arquivos, strtok(NULL, ",\t \n;"));
			printf("segundo arquivo de saida deve ser |%s|\n", arquivos );
		}		
	/* fim --saida */

		if(strcmp(tipo, "ordena") == 0){
			ordena(registros, N_BLOCOS, saida);
			printf("ordenado com sucesso!\n");
			return 0;
		}else if(strcmp(tipo, "gera_indice") == 0){
			gera_indice(N_BLOCOS, registros, saida, base_saida);
			return 0;
		}


	fgets(linha, 100, config);
	linha[strlen(linha)-1] =0;
	int vezes = atoi(linha);
	printf("\n%d vezes:\n\n",vezes);

	for(;vezes > 0; vezes --){
		fgets(linha, 100, config);
		linha[strlen(linha)-1] =0;
		id = atoi(linha);
		printf("id a ser pesquisado eh %d\n",id);

		if(strcmp(tipo, "busca_seq") == 0){

			printf("--iniciando busca sequencial\n");
			busca_seq(registros ,N_BLOCOS, id, saida);

		}else if(strcmp(tipo, "busca_bin") == 0){

			printf("--iniciando busca binaria\n");
			busca_bin(registros, N_BLOCOS, id, saida);
			fprintf(saida, "\n");

		}else if(strcmp(tipo, "busca_indice") == 0){
			
			printf("--iniciando busca por indice\n");
			busca_indice(registros, N_BLOCOS, id, saida,base_entrada, topo_entrada);

		}else
			printf("opção invalida : '%s'.", tipo);	
		printf("-------------------------------------------\n");
	}

	printf("\nfim!\n");
	
	return 0;
}