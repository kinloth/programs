#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "create_data.h"

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

void get_record_from_block(Registro * record, char * block_buffer, int record_number){

	memcpy(record, block_buffer + (record_number * sizeof(Registro)), sizeof(Registro));	
	
}

void set_record(Registro * r){

	int k, max;
	char random_content[100];

	max = rand() % 100 + 1;

	for(k = 0; k < max; k++){

		random_content[k] = 'a' + (rand() % 26);
	}
	
	random_content[k] = '\0';

	r->id = rand();
	sprintf(r->content, "(%d) %s", r->id, random_content);
}

void print_record(Registro * r){

	printf("record: id = %d, content = '%s'\n", r->id, r->content);
}

int read_block(FILE * in, char * block_buffer){

	if( fread(block_buffer, sizeof(char), BLOCK_SIZE, in) == BLOCK_SIZE) return TRUE;

	//printf("Error during fread!\n");
	
	return FALSE;
}

void write_block(FILE * out, char * block_buffer){

	fwrite(block_buffer, sizeof(char), BLOCK_SIZE, out);
}


/*
 * record_number refere-se a posição do registro dentro de um bloco. O primeiro registro de um bloco
 * tem record_number = 0, o segundo registro tem record_number = 1, e assim sucessivamente, até o último
 * registro que possui record_number = 31 (uma vez que cada bloco é capaz de armazenar até 32 registros). 
 */


void copy_record_to_block(Registro * record, char * block_buffer, int record_number){

	memcpy(block_buffer + (record_number * sizeof(Registro)), record, sizeof(Registro)); 
}

void create_file(int number_of_blocks, char * file_name) {

	int i, j;
	char block_buffer[BLOCK_SIZE];
	FILE * out = fopen(file_name, "w");
	Registro r;

	for(i = 0; i < number_of_blocks; i++){

		for(j = 0; j < RECORDS_PER_BLOCK; j++){

			set_record(&r);
			copy_record_to_block(&r, block_buffer, j);
		}

		write_block(out, block_buffer);
	}

	fclose(out);
}

void read_file(int number_of_blocks, char * file_name){

	int i, j;
	char block_buffer[BLOCK_SIZE];
	FILE * in = fopen(file_name, "r");
	Registro r;

	for(i = 0; i < number_of_blocks; i++){

		if(read_block(in, block_buffer)){

			for(j = 0; j < RECORDS_PER_BLOCK; j++){

				get_record_from_block(&r, block_buffer, j);
				print_record(&r);
			}
		}
	}

	fclose(in);
}

void read_index(int number_of_blocks, char * file_name){

	int i, j,cont=1;
	char block_buffer[BLOCK_SIZE];
	FILE * in = fopen(file_name, "rb");
	EntradaIndice ind;

	for(i = 0; i < number_of_blocks; i++){

		if(read_block(in, block_buffer)){

			for(j = 0; j < INDEX_PER_BLOCK; j++){
if(cont%1024==0){
	getchar();
}
printf("%d)",j*i);
				get_index_from_block(&ind, block_buffer, j);
				print_index(&ind);
				cont++;
			}
		}
	}

	fclose(in);
}
void print_index(EntradaIndice * i){

	printf("index: id = %d, offset = %d\n", i->id, i->offset);
}
void get_index_from_block(EntradaIndice * index, char * block_buffer, int index_number){
	memcpy(index, block_buffer + (index_number * sizeof(EntradaIndice)), sizeof(EntradaIndice));	
}
void copy_index_to_block(EntradaIndice * index, char * block_buffer, int index_number){

	memcpy(block_buffer + (index_number * sizeof(EntradaIndice)), index, sizeof(EntradaIndice)); 
}
