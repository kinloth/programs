#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <sys/time.h>

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

struct timeval tv1, tv2;

void busca_seq(char *entrada, int n_blocos, int id, FILE* saida){


	fprintf(saida, "<%d>\t", id);	
	gettimeofday(&tv1, NULL);
	int i, j, n;
	FILE * in = fopen(entrada, "r");
	char block_buffer[BLOCK_SIZE];
	Registro r;
	int contador = BUFFER;
	n = 0 ;

	for(i = 0; i < n_blocos; i++){

		if(read_block(in, block_buffer)){

			for(j = 0; j < RECORDS_PER_BLOCK; j++){

				get_record_from_block(&r, block_buffer, j);
				if(r.id == id){

					gettimeofday(&tv2, NULL);
					fprintf(saida, "<SIM>\t<%s>\t<%d>\t", r.content,n);
					fprintf(saida, "<%fs>\n", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));
					return;
					
				}
				n++;					
			}
		}
		contador--;
		if(contador == 0){
			fclose(in);
			in = fopen(entrada, "r");
			fseek(in, i, SEEK_SET);			
			printf(".");
			contador = BUFFER;
		}

	}
	gettimeofday(&tv2, NULL);
	fprintf(saida, "<NAO>\t< >\t<%d>\t", n);
	fprintf(saida, "<%fs>\n", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));
}

	



void busca_bin(char* entrada, int n_blocos, int id, FILE* saida){

	gettimeofday(&tv1, NULL);
	fprintf(saida, "<%d>\t", id);
	int i, j, n, cont;
	i = j = n  = 0;
	FILE * in = fopen(entrada, "r");
	char block_buffer[BLOCK_SIZE];
	Registro r;
	int contador = BUFFER;
	int base = 0;
	int topo = n_blocos;
	int meio = n_blocos/2;
	int ant = n_blocos;

	cont = 0;
	while(n_blocos > 0){
		fseek(in, meio*BLOCK_SIZE, 0);
		if(read_block(in, block_buffer)){

				for(j = 0; j < RECORDS_PER_BLOCK; j++){

					get_record_from_block(&r, block_buffer, j);
					if(r.id == id){
						gettimeofday(&tv2, NULL);
						fprintf(saida, "<SIM>\t<%s>\t<%d>\t", r.content,n);
						fprintf(saida, "<%fs>", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));
						return;
					}
					n++;					
				}
			contador--;
		}

		if(cont == 0){
			ant = meio;
			cont = 1;
		}else{
			cont = cont-1; 
		}
		if(r.id > id){
			topo = meio;
			meio = topo/2;
		}else{
			base = meio;			
			meio = meio + (topo-meio)/2;
		}
			
		if(meio == topo || meio == ant){
			gettimeofday(&tv2, NULL);
			fprintf(saida, "<NAO>\t< >\t<%d>\t", n);
			fprintf(saida, "<%fs>", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));
			return;
		}

		if(contador == 0){
			fclose(in);
			fopen(entrada, "r");
			printf("...\n");
		}
	}

}


EntradaIndice sparse_search(int number_of_blocks, int id, char * file_name, int* n){
	int i, j;
	char block_buffer[BLOCK_SIZE];
	FILE * in = fopen(file_name, "rb");
	EntradaIndice indice;
	EntradaIndice best;
	best.id=99999999;
	best.offset=-1;
	printf("file_name = %s\n", file_name);
	for(i = 0; i < number_of_blocks; i++){
		if(read_block(in, block_buffer)){
			for(j = 0; j < INDEX_PER_BLOCK; j++){
				get_index_from_block(&indice, block_buffer, j);
				if(indice.id==id){
					best=indice;
					return best;
				}
				//if(j%64==0)getchar();
				if(indice.offset!=-1 && indice.id<=id && best.id!=id){
					best=indice;
				}
				//if(indice.offset==-1) return best;
				n++;
			}
		}

	}
	return best;
	fclose(in);
}

Registro dense_search(int posicao, int id, char * file_name, char * base_name, int* n){

	int i, j;
	char index_buffer[BLOCK_SIZE];
	char register_buffer[sizeof(Registro)];	
	FILE * in = fopen(file_name, "rb");
	FILE * base = fopen(base_name, "rb");	
	EntradaIndice indice;
	EntradaIndice * element=NULL;
	Registro r;
	
	if(fseek(in, posicao,SEEK_SET)==0){
			if(read_block(in, index_buffer)){
			for(j = 0; j < INDEX_PER_BLOCK; j++){
				get_index_from_block(&indice, index_buffer, j);
				if(indice.id==id){
					if(fseek(base, indice.offset,SEEK_SET)==0){
						fread(register_buffer, sizeof(char), sizeof(Registro), base); 
						memcpy(&r, register_buffer, sizeof(Registro));	
						return r;
						}
					}
				}
				n = n+1;
			}

	}
	r.id=0;
	n = 1;
	char * msg="Register not found. Invalid Return!";
	strcpy (r.content,msg);
	return r;
}

void busca_indice(char *entrada, int n_blocos, int id, FILE* saida, char*topo, char* base){
	
	gettimeofday(&tv1, NULL);
	EntradaIndice index;
	Registro r;
	int n = 0;
	FILE * in =  fopen(topo, "rb");
	long size=calc_blocos(in);
	fclose(in);
	printf("buscado elemento no index esparso:\n" );
	fprintf(saida, "<%d>\t", id);
	index = sparse_search(size,id,topo, &n); //busca elemento presente no index esparso

	printf("buscado elemento no index denso:\n" );
	FILE* bs = fopen(base, "rb");
	size = calc_blocos(bs);
	fclose(bs);
	r=dense_search(index.offset,id, base, entrada, &n); //mostra registro

	gettimeofday(&tv2, NULL);
	printf("terminou\n");
	if(r.id == 0){
		fprintf(saida, "<NAO>\t< >\t<%d>\t", n);	
	}else
		fprintf(saida, "<SIM>\t<%s>\t<%d>\t", r.id, n);
	fprintf(saida, "<%fs>\n", (double) (tv2.tv_usec - tv1.tv_usec) / 1000000 + (double) (tv2.tv_sec - tv1.tv_sec));		
}

void create_dense(int number_of_blocks, char * file_entrada, char * file_saida){

	int i, j,cont=1;
	char block_buffer[BLOCK_SIZE];
	char index_buffer[BLOCK_SIZE];
	FILE * in = fopen(file_entrada, "rb");
	FILE * out = fopen(file_saida, "wb");
	Registro r;


	printf("aqui! number_of_blocks = %d\n", number_of_blocks);
	getchar();
	for(i = 0; i < number_of_blocks; i++){

		if(read_block(in, block_buffer)){

			for(j = 0; j < RECORDS_PER_BLOCK; j++){
				get_record_from_block(&r, block_buffer, j);
				EntradaIndice ind;
				ind.id=r.id;
				ind.offset=i*BLOCK_SIZE+j*(sizeof(Registro));
				copy_index_to_block(&ind,index_buffer,cont%512);	
				cont++;				
				if(cont%512==0){
					write_block(out, index_buffer);
				}
			}
		}
	//printf("i = %d\n", i);
	//getchar();
	}
	if(cont%512!=0){
		int div = cont / 512;
		int pot = cont-(div*512);
		getchar();
			printf("%d",pot);
			getchar();
		for(i=pot;i<BLOCK_SIZE/8;i++){
			index_buffer[i]=-1;
			EntradaIndice ind;
			ind.id=0;
			ind.offset=-1;
			copy_index_to_block(&ind,index_buffer,i);
		}
		write_block(out, index_buffer);
	}
	fclose(in);
	fclose(out);

}




void create_sparse(int number_of_blocks, char * file_entrada, char * file_saida){

	int i, j,cont=1;
	char block_buffer[BLOCK_SIZE];
	char index_buffer[BLOCK_SIZE];
	FILE * in = fopen(file_entrada, "rb");
	FILE * out = fopen(file_saida, "wb");
	EntradaIndice indice;
	for(i = 0; i < number_of_blocks; i++){

		if(read_block(in, block_buffer)){

			get_index_from_block(&indice, block_buffer, 0);
			indice.offset=i*BLOCK_SIZE;
			copy_index_to_block(&indice,index_buffer,cont%512);
			printf("%d)",cont);
			print_index(&indice);	
			cont++;				
			
			if(cont%512==0){
				write_block(out, index_buffer);
			}
		}
	}
	if(cont%512!=0){
		int div = cont / 512;
		int pot = cont-(div*512);
		getchar();
		for(i=pot;i<BLOCK_SIZE/8;i++){

			EntradaIndice ind;
			ind.id=0;
			ind.offset=-1;
			copy_index_to_block(&ind,index_buffer,i);
		}
		write_block(out, index_buffer);
	}
	fclose(in);
	fclose(out);
}


