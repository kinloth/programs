#include <stdio.h>
#include <malloc.h>
#include <string.h>

typedef struct {
	int hora[2];
	int data[3];
	char texto[80];
}DADOS;

typedef struct estrutura {
	DADOS *dados;
	struct estrutura *prox;
}NO;

typedef struct {
	NO* inicio;
}LISTA;
//---------------------

//inicializa a lista
void inicializa(LISTA* l){
	l->inicio = NULL;
}

//cria um no para ser utilizado depois
NO* cria_no(){
	//aloca memoria
	NO* no = malloc(sizeof(NO));
	DADOS* d = malloc(sizeof(DADOS));
	char aux[20];

	printf("Digite o compromisso:\n");
	scanf(" %[^\n]s",d->texto);

	printf("Digite a data (dd/mm/aaaa):\n");
	scanf("%s",aux);

	d->data[0] = atoi(strtok(aux, "/"));
	d->data[1] = atoi(strtok(NULL, "/"));
	d->data[2] = atoi(strtok(NULL, "/"));

	printf("Digite a hora (hh:mm):\n");
	scanf("%s",aux);

	d->hora[0] = atoi(strtok(aux, ":"));
	d->hora[1] = atoi(strtok(NULL, ":"));

	no->prox = NULL;
	no->dados = d;
	return no;
}

void imprime_lista(LISTA l){
	printf("\n.................lista de compromissos..............\n");
	NO* aux = l.inicio;
	DADOS* d;
	int i = 1;
	int data[3];
	while(aux){
		d = aux->dados;
		printf("%dº:\nCompromisso:%s\nData:%02d/%02d/%02d\nHora:%02d:%02d\n\n",
			i,d->texto,d->data[0],d->data[1],d->data[2],d->hora[0],d->hora[1]);
		i++;
		aux = aux->prox;
	}
	printf(".................................................\n");
}

int compara_nos(NO* atual, NO* novo){
	DADOS* d1 = atual->dados;
	DADOS* d2 = novo->dados;
	int i;
	
	for(i = 2; i >= 0; i--){
		if (d1->data[i] > d2->data[i])
			return 1;
		else if(d1->data[i] < d2->data[i])
			return 0;	
	}

	for(i = 0; i <= 1; i++){
		if (d1->hora[i] > d2->hora[i])
			return 1;
		else if(d1->hora[i] < d2->hora[i])
			return 0;	
	}

	return 1;
	//return 1; se atual > novo -> inserir antes do atual
	//return 0; se atual < novo -> continuar buscando...
}


void insere_compromisso(LISTA* l, NO* novo){
	
	if(novo == NULL)	
		novo = cria_no();

	NO* atual;
	NO* ant;
	ant = atual = l->inicio;
	int result = -1;

	//insercao no comeco
	if(atual == NULL || compara_nos(atual,novo) == 1){			
			l->inicio = novo;
			novo->prox = atual;
			return;
	}

	atual = atual->prox;
	

	//insercao no meio
	while(atual){

		//insercao antes do atual
		if(compara_nos(atual,novo) == 1){			
			ant->prox = novo;
			novo->prox = atual;
			return;
		}

		ant = atual;
		atual = atual->prox;
	}

	//insercao no fim
	ant->prox = novo;
	novo->prox = atual;
	return;
}

void salva_compromissos(LISTA l){
	char nome[20];
	printf("Digite o nome do arquivo que deseja salvar:\n");
	scanf("%s",nome);

	FILE *f = fopen(nome,"w");

	if(!f){
		printf("Erro na criacao do arquivo!\n");
		return;
	} 

	NO* aux = l.inicio;
	DADOS* d;
	int i = 1;
	while(aux){
		d = aux->dados;
		fprintf(f ,"%dº:\nCompromisso:%s\nData:%02d/%02d/%02d\nHora:%02d:%02d\n\n",
			i,d->texto,d->data[0],d->data[1],d->data[2],d->hora[0],d->hora[1]);
		
		i++;
		aux = aux->prox;
	}

	printf("O arquivo %s foi salvo com sucesso! :)\n",nome);
	fclose(f);
}



void carrega_compromissos(LISTA* l){
	char nome[20];
	char linha[100];
	char *aux;
	NO* novo;
	DADOS* d;

	printf("Digite o nome do arquivo que deseja abrir?\n");
	scanf("%s",nome);
	FILE *arquivo = fopen(nome,"r");
	if(!arquivo){
		printf("Arquivo nao existe.\n");
		return;
	}
	int i = 1;
	while(fgets(linha,sizeof(linha),arquivo)){
		
		strtok(linha,":");		
		if(i == 2){
			novo = malloc(sizeof(NO));
			d = malloc(sizeof(DADOS));

			aux = strtok(NULL, ":\n");
			strcpy(d->texto,aux);
		}
		else if(i == 3){
			d->data[0] = atoi(strtok(NULL, "/"));
			d->data[1] = atoi(strtok(NULL, "/"));
			d->data[2] = atoi(strtok(NULL, "/"));

		}else if(i == 4){
			d->hora[0] = atoi(strtok(NULL, ":"));
			d->hora[1] = atoi(strtok(NULL, ":"));

			novo->dados = d;
			novo->prox = NULL;
			insere_compromisso(l,novo);

		}else if(i == 5)
			i = 0;
		i++;
	}

	printf("Agenda carregada com sucesso!:)\n");
}


void consulta_compromisso(LISTA l){

	NO*atual = l.inicio;
	DADOS*d;
	int i = 1;
	int data[3];
	char aux[20];

	printf("Digite a data do compromisso a ser buscado (dd/mm/aaaa):\n");
	scanf("%s",aux);

	data[0] = atoi(strtok(aux, "/"));
	data[1]= atoi(strtok(NULL, "/"));
	data[2]= atoi(strtok(NULL, "/"));

	while(atual!= NULL){

		d=atual->dados;
		if(d->data[0]==data[0] && d->data[1]==data[1] && d->data[2]==data[2]){
			printf("\n%dº:\nCompromisso:%s \ndata: %02d/%02d/%02d\nhora: %02d:%02d\n",
			i,d->texto,d->data[0],d->data[1],d->data[2],d->hora[0],d->hora[1]);
			i++;
		}

		atual=atual->prox;
	}

	if(i==1)
		printf("Nao foram encontrados compromissos com esta data na agenda.");

}

void procura_compromisso(LISTA l){

	NO*atual = l.inicio;
	DADOS*d;
	int i = 1;
	char aux[20];

	printf("Digite a palavra do compromisso a ser buscado:\n");
	scanf("%s",aux);

	while(atual!= NULL){

		d=atual->dados;
		if(strstr(d->texto,aux)){
			printf("\n%dº:\nCompromisso:%s \ndata: %02d/%02d/%02d\nhora: %02d:%02d\n",
			i,d->texto,d->data[0],d->data[1],d->data[2],d->hora[0],d->hora[1]);
			i++;
		}

		atual=atual->prox;
	}

	if(i==1)
		printf("Nao foi encontrado compromissos com esta data na agenda");


}

void remove_compromisso(LISTA *l){

	NO*atual = l->inicio;
	DADOS*d;
	NO*ant;
	int i=1;
	int data[3];
	char aux[20];

	printf("Digite a data do compromisso a ser buscado (dd/mm/aaaa):\n");
	scanf("%s",aux);

	data[0] = atoi(strtok(aux, "/"));
	data[1]= atoi(strtok(NULL, "/"));
	data[2]= atoi(strtok(NULL, "/"));

	while(atual!= NULL){

		d=atual->dados;
		//exclui no inicio
		if((l->inicio==atual) && (d->data[0]==data[0] && d->data[1]==data[1] && d->data[2]==data[2])){
			
			l->inicio=atual->prox;
			atual->prox = NULL;
			printf("Compromisso %s excluido com sucesso!\n",d->texto);
			free(atual); //excluindo no
			i++;
			atual=l->inicio;
			continue; //volta para verificar o restante;
			
		}
		//exclui no meio e no final
		else if(d->data[0]==data[0] && d->data[1]==data[1] && d->data[2]==data[2]){

			ant->prox=atual->prox;
			printf("Compromisso %s excluido com sucesso!\n",d->texto);
			free(atual); //excluindo no
			atual = ant->prox;
			i++;
			continue;
		}

		ant=atual;
		atual=atual->prox;
	}

	if(i==1)
		printf("Nao foram encontrado compromissos com esta data na agenda");

}

void menu(LISTA *l){
 	int sair = 1, op = 0;
 	while(sair){
 		printf("\n----------------AGENDA PRI S2-------------------\n");
 		printf("**  O que voce deseja fazer?  **\n");
 		printf("1)Adicionar um compromisso na agenda\n");
 		printf("2)Remove um compromisso da agenda\n");
 		printf("3)Consulta compromissos em uma data\n");
 		printf("4)Procura compromissos atraves de uma palavra\n");
 		printf("5)Salva a agenda em um arquivo no disco\n");
 		printf("6)Le a agenda de um arquivo do disco\n");
 		printf("7)Imprime compromissos\n");
 		printf("8)Sair\n");
 		printf("------------------------------------------------\n");

 		scanf("%d",&op);
 		switch(op){
 			case 1:
 				insere_compromisso(l,NULL);
 				printf("Compromisso inserido com sucesso! :)\n");
 				break;
 			case 2:
 				remove_compromisso(l);
 				break;
 			case 3:
 				consulta_compromisso(*l);
 				break;
 			case 4:
 				procura_compromisso(*l);
 				break;
 			case 5:
 				salva_compromissos(*l);
 				break;
 			case 6:
 				carrega_compromissos(l);
 				break;
 			case 7:
 				imprime_lista(*l);
 				break;
 			case 8:
 				sair = 0;
 				break;
 		}
 	}
}

int main(){
	LISTA l;
	
	inicializa(&l);
	menu(&l);

	printf("\nFinalizado!\n");
	return 1;	
}
