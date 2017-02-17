#define BLOCK_SIZE 4096
#define RECORDS_PER_BLOCK (BLOCK_SIZE/sizeof(Registro))
#define INDEX_PER_BLOCK (BLOCK_SIZE/sizeof(EntradaIndice))
#define TRUE 1
#define FALSE 0

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

typedef struct {
	
	int id;
	char content[124];

} Registro;

typedef struct {
int id; int offset;
} EntradaIndice;

void set_Registro(Registro * r);
void print_Registro(Registro * r);
int read_block(FILE * in, char * block_buffer);
void write_block(FILE * out, char * block_buffer);
void get_Registro_from_block(Registro * Registro, char * block_buffer, int Registro_number);
void copy_Registro_to_block(Registro * Registro, char * block_buffer, int Registro_number);
void create_file(int number_of_blocks, char * file_name);
void read_file(int number_of_blocks, char * file_name);
void read_index(int number_of_blocks, char * file_name);
void print_index(EntradaIndice * i);
void get_index_from_block(EntradaIndice * index, char * block_buffer, int index_number);
void copy_index_to_block(EntradaIndice * index, char * block_buffer, int index_number);
